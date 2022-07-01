package gst.trainingcourse.day5_nguyenquockhanh.presentation

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import fragmentViewBinding
import gst.trainingcourse.day5_nguyenquockhanh.R
import gst.trainingcourse.day5_nguyenquockhanh.databinding.FragmentUpdateBinding

class UpdateFragment: BaseFragment() {
    override val layoutResId: Int = R.layout.fragment_update
    override val binding by fragmentViewBinding(FragmentUpdateBinding::bind)
    private val viewModel: CardViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        initAction()
    }

    private fun initAction() {
        binding.editExpDate.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                val calendar = Calendar.getInstance()

                DatePickerDialog(
                    requireContext(),
                    { _, year, month, _ ->
                        val date = "${month + 1}/$year"
                        viewModel.expDate.value = date
                    },
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
                ).show()
            }
        }

        binding.buttonSave.setOnClickListener {
            if (viewModel.saveDate()) {
                findNavController().popBackStack()
            } else {
                Snackbar.make(
                    requireContext(),
                    requireView(),
                    "Invalid Information",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }
    }
}