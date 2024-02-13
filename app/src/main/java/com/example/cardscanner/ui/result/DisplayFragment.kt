package com.example.cardscanner.ui.result


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.cardscanner.R
import com.example.cardscanner.databinding.FragmentDisplayBinding
import com.example.cardscanner.ui.base.ViewBindingFragment
import timber.log.Timber


class DisplayFragment : ViewBindingFragment<FragmentDisplayBinding>() {
    private val safeArgs: DisplayFragmentArgs by navArgs()

    override val layoutId: Int
        get() = R.layout.fragment_display

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDisplayBinding {
        return FragmentDisplayBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Timber.e(safeArgs.cardnumber)

        with(binding) {

        }
    }

    override fun run() {
        TODO("Not yet implemented")
    }
}