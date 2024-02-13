package com.example.cardscanner.util

import android.view.View


fun View.hide(onlyInvisible: Boolean = false) {
    this.visibility = if (onlyInvisible) View.INVISIBLE else View.GONE
}



fun View.show() {
    this.visibility = View.VISIBLE
}



