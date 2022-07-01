package gst.trainingcourse.day5_nguyenquockhanh.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import fragmentViewBinding
import gst.trainingcourse.day5_nguyenquockhanh.R
import gst.trainingcourse.day5_nguyenquockhanh.databinding.FragmentListBinding
import gst.trainingcourse.day5_nguyenquockhanh.presentation.adapter.CardAdapter

class ListFragment: BaseFragment() {
    override val layoutResId: Int = R.layout.fragment_list
    override val binding: FragmentListBinding by fragmentViewBinding(FragmentListBinding::bind)

    private val viewModel: CardViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CardAdapter(viewLifecycleOwner) { card, position ->
            viewModel.card.value = card
            viewModel.position = position
            findNavController().navigate(ListFragmentDirections.actionListFragmentToDetailFragment())
        }

        binding.rvCard.apply {
            this.adapter = adapter
            layoutManager = LinearLayoutManager(requireContext())
        }

        viewModel.listCard.observe(viewLifecycleOwner) {
            if (it != null) {
                adapter.submitList(it)
            }
        }
    }
}