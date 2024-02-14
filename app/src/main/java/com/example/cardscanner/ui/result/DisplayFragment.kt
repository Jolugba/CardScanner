package com.example.cardscanner.ui.result


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.cardscanner.R
import com.example.cardscanner.databinding.FragmentDisplayBinding
import com.example.cardscanner.network.models.CardDetail
import com.example.cardscanner.ui.base.ViewBindingFragment
import com.example.cardscanner.ui.result.viewmodel.ResultViewModel
import com.example.cardscanner.ui.result.viewmodel.UiState
import com.example.cardscanner.util.hide
import com.example.cardscanner.util.observe
import com.example.cardscanner.util.show
import com.example.cardscanner.util.showLongSnackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DisplayFragment : ViewBindingFragment<FragmentDisplayBinding>() {
    private val safeArgs: DisplayFragmentArgs by navArgs()
    private val viewModel: ResultViewModel by viewModels()


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
        viewModel.fetchCardInfo(safeArgs.cardnumber)
          run()
    }

    override fun run() {
        observe(viewModel.state) {
            when (it) {
                is UiState.LOADING -> {
                    if (it.loading) {
                        binding.loader.root.show()
                    } else {
                       binding.loader.root.hide()
                    }
                }
                is UiState.SUCCESS -> {
                    setupScreen(it.data)
                    binding.loader.root.hide()
                }
                is UiState.ERROR -> {
                    showLongSnackbar(it.errorMessage)
                    binding.loader.root.hide()
                }

            }
        }
    }
  private  fun setupScreen(cardDetail: CardDetail)= with(binding){
      cardBank.text=getString(R.string.card_bank,cardDetail.bank.name)
      cardBrand.text=getString(R.string.card_brand,cardDetail.brand)
      cardCountry.text=getString(R.string.card_country,cardDetail.country.name)
      cardType.text=getString(R.string.card_type,cardDetail.type)
  }
}