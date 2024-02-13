package com.example.cardscanner.ui.scancard

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.cardscanner.R
import com.example.cardscanner.databinding.FragmentScanCardBinding
import com.example.cardscanner.ui.base.ViewBindingFragment


class ScanCardFragment : ViewBindingFragment<FragmentScanCardBinding>() {


    override val layoutId: Int
        get() = R.layout.fragment_get_card_detail

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentScanCardBinding {
        return FragmentScanCardBinding.inflate(inflater, container, false)
    }

    override fun run() {
        TODO("Not yet implemented")
    }
}