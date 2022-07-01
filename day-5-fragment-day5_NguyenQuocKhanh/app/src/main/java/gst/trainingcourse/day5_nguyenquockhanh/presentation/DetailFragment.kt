package gst.trainingcourse.day5_nguyenquockhanh.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import fragmentViewBinding
import gst.trainingcourse.day5_nguyenquockhanh.R
import gst.trainingcourse.day5_nguyenquockhanh.databinding.FragmentDetailBinding

class DetailFragment: BaseFragment() {
    override val layoutResId: Int = R.layout.fragment_detail
    override val binding by fragmentViewBinding(FragmentDetailBinding::bind)

    private val viewModel: CardViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.card.observe(viewLifecycleOwner) { card ->
            if (card != null) {
                binding.card = card
            }
        }

        initAction()
    }

    private fun initAction() {
        binding.buttonClose.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.buttonUpdate.setOnClickListener {
            viewModel.setCardData()
            findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToUpdateFragment())
        }
    }
}