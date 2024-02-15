package com.example.cardscanner.ui.scancard

import OCRConfiguration
import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.SurfaceHolder
import android.view.SurfaceView
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.viewModels
import com.example.cardscanner.R
import com.example.cardscanner.databinding.FragmentScanCardBinding
import com.example.cardscanner.ocr.ProcessText
import com.example.cardscanner.ui.Inputcard.InputViewModel
import com.example.cardscanner.ui.base.ViewBindingFragment
import com.example.cardscanner.util.Constants
import com.example.cardscanner.util.launchFragment
import com.example.cardscanner.util.observe
import com.example.cardscanner.util.requestCameraPermission
import com.example.cardscanner.util.showLongSnackbar
import com.google.android.gms.vision.CameraSource
import com.google.android.gms.vision.text.TextRecognizer
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import java.io.IOException

@AndroidEntryPoint
class ScanCardFragment : ViewBindingFragment<FragmentScanCardBinding>() {

    private lateinit var cameraSource: CameraSource
    private lateinit var textRecognizer: TextRecognizer
    private lateinit var ocr: OCRConfiguration
    private val viewModel: ScanCardViewModel by viewModels()

    override val layoutId: Int
        get() = R.layout.fragment_scan_card

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ocr = OCRConfiguration(requireActivity().application)

        textRecognizer = ocr.textRecognizer
        processText()


    }
    fun processText(){
        if (!textRecognizer.isOperational) {
            Timber.e("Detector dependencies are not yet available.")

        } else {
            cameraSource = ocr.cameraSource
            setUpSurfaceView()
            val processor =
                ProcessText(viewModel::getNumber)
            textRecognizer.setProcessor(processor)
        }
    }
    private fun setUpSurfaceView() = with(binding){
        if (
            ActivityCompat.checkSelfPermission(requireActivity().applicationContext,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED
        ) {
            requestCameraPermission()
        } else {
            surfaceView.holder
                .addCallback(
                    getSurfaceViewCallback(surfaceView, cameraSource)
                )
        }
    }

    private fun getSurfaceViewCallback(surfaceView: SurfaceView, cameraSource: CameraSource)
            : SurfaceHolder.Callback {
        return object : SurfaceHolder.Callback {

            @SuppressLint("MissingPermission")
            override fun surfaceCreated(holder: SurfaceHolder) {
                try {
                    cameraSource.start(surfaceView.holder)
                } catch (e: IOException) {
                    Timber.e("hhhhhh$e")
                    e.printStackTrace()
                }
            }

            override fun surfaceChanged(
                holder: SurfaceHolder,
                format: Int,
                width: Int,
                height: Int
            ) {}

            override fun surfaceDestroyed(holder: SurfaceHolder) {
                cameraSource.stop()
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String?>,
        grantResults: IntArray
    ) {
        if (requestCode != Constants.PermissionCodes.CAMERA_REQUEST_CODE) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
            return
        }
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            try {
                if (ActivityCompat.checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED
                ) {
                    return
                }
                cameraSource.start(binding.surfaceView.holder)
            } catch (e: IOException) {
                showLongSnackbar("Sorry unable to display camera try again")
                Timber.e("$e")
            }
        }
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentScanCardBinding {
        return FragmentScanCardBinding.inflate(inflater, container, false)
    }

    override fun run() {
        observe(viewModel.state) { state ->
            when (state) {
                is InputViewModel.ViewState.SUCCESS -> {
                    binding.resultText.text=state.number
                    launchFragment(ScanCardFragmentDirections.goToDisplayFragment(state.number))

                }
                is InputViewModel.ViewState.ERROR -> {
                    binding.getInputButton.isEnabled=false
                    showLongSnackbar(state.errorMessage)
                }

            }
        }
        observe(viewModel.isEnabled) { state ->
            when (state) {
                true -> {
                    binding.getInputButton.isEnabled=true

                }
               false -> {
                    binding.getInputButton.isEnabled=false
                }

            }
        }
    }
}