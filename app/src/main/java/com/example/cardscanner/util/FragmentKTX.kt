package com.example.cardscanner.util

import android.Manifest
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.cardscanner.R
import com.example.cardscanner.util.Constants.PermissionCodes.PERMISSION_REQUEST_CAMERA
import com.google.android.material.snackbar.Snackbar


fun Fragment.launchFragment(direction: NavDirections) {
    findNavController().navigate(direction)
}


fun Fragment.showLongSnackbar(message: String) {
    val snackbar = Snackbar.make(requireView(), message, Snackbar.LENGTH_LONG)
    val snackbarView: View = snackbar.view
    val snackTextView: TextView =
        snackbarView.findViewById(com.google.android.material.R.id.snackbar_text)
    snackTextView.maxLines = 3
    snackbar.show()
}
fun Fragment.popFragment() {
    findNavController().popBackStack()
}

fun Fragment.requestCameraPermission() {
    // Permission has not been granted and must be requested.
    if (shouldShowRequestPermissionRationale(Manifest.permission.CAMERA)) {
        // Provide an additional rationale to the user if the permission was not granted
        // and the user would benefit from additional context for the use of the permission.
        // Display a Dialog with a button to request the missing permission.
        AlertDialog.Builder(requireContext(), R.style.dialogTheme).apply {
            setTitle(getString(R.string.text_camera_permission))
            setMessage(getString(R.string.text_camera_permission_rationale))
            setNeutralButton(getString(R.string.text_ok)) { dialog, _ ->
                requestPermissions(
                    arrayOf(Manifest.permission.CAMERA),
                    PERMISSION_REQUEST_CAMERA
                )
                dialog.dismiss()
            }
        }.show().create()
    } else {
        // Request the permission. The result will be received in onRequestPermissionResult().

    }
}





