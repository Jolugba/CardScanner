package com.example.cardscanner.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cardscanner.R
import com.example.cardscanner.databinding.FragmentGetCardDetailBinding
import com.example.cardscanner.ui.base.ViewBindingFragment
import com.example.cardscanner.util.launchFragment


class GetCardDetailFragment : ViewBindingFragment<FragmentGetCardDetailBinding>() {


    override val layoutId: Int
        get() = R.layout.fragment_get_card_detail

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentGetCardDetailBinding {
        return FragmentGetCardDetailBinding.inflate(inflater, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            getInputButton.setOnClickListener {
                launchFragment(GetCardDetailFragmentDirections.goToInputCardDetailFragment())
            }
            scanButton.setOnClickListener {
                launchFragment(GetCardDetailFragmentDirections.goToScanCardFragment())
            }
        }
    }

    override fun run() {
        TODO("Not yet implemented")
    }
}