package com.example.cardscanner.ui.Inputcard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.cardscanner.R
import com.example.cardscanner.databinding.FragmentInputCardDetailBinding
import com.example.cardscanner.ui.base.ViewBindingFragment
import com.example.cardscanner.util.launchFragment
import com.example.cardscanner.util.observe
import timber.log.Timber


class InputCardDetailFragment : ViewBindingFragment<FragmentInputCardDetailBinding>() {
    private val viewModel: InputViewModel by viewModels()



    override val layoutId: Int
        get() = R.layout.fragment_input_card_detail

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentInputCardDetailBinding {
        return FragmentInputCardDetailBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        run()
        with(binding){
          getResultButton.setOnClickListener {
              viewModel.getNumber(cardNumber.text.toString())
              Timber.e(cardNumber.text.toString())
          }
        }
    }

    override fun run() {
        observe(viewModel.state) { state ->
            when (state) {
                is InputViewModel.ViewState.SUCCESS -> {
                    launchFragment(InputCardDetailFragmentDirections.goToDisplayFragment(state.number))
                    Timber.e("ww ${state.number}")

                }

                is InputViewModel.ViewState.ERROR -> {
                    Timber.e("error${state.errorMessage}")
                    binding.cardNumber.error=state.errorMessage
                }

            }
        }
    }
}