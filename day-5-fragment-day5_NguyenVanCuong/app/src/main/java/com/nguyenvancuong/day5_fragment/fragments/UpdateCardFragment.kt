package com.nguyenvancuong.day5_fragment.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.nguyenvancuong.day5_fragment.R
import com.nguyenvancuong.day5_fragment.models.Card
import kotlinx.android.synthetic.main.fragment_update_card.*
import kotlinx.android.synthetic.main.fragment_update_card.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
/**
 * A simple [Fragment] subclass.
 * Use the [UpdateCardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UpdateCardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val card = arguments?.getSerializable("card") as Card
        val view:View =  inflater.inflate(R.layout.fragment_update_card, container, false)
        view.edt_cardname.setText(card.cardName)
        view.edt_cardnumber.setText(card.cardNumber)
        view.edt_exp.setText(card.exp)
        setActions(view)
        return view
    }
    private fun setActions(view:View){
        view.btn_save.setOnClickListener {
            Bundle().apply {
                val cardUpdated = Card(
                    view.edt_cardnumber.text.toString(),
                    view.edt_cardname.text.toString(),
                    view.edt_exp.text.toString()
                )
                this.putSerializable("cardUpdated", cardUpdated)
                setFragmentResult(REQUEST_KEY, this)
                Navigation.findNavController(view).navigateUp()
            }
        }
    }
    companion object {
        const val REQUEST_KEY = "UPDATE_REQUEST_KEY"
    }
}