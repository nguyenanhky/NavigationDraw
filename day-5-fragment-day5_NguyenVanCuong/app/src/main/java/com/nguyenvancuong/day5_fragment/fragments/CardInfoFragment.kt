package com.nguyenvancuong.day5_fragment.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.Navigation
import com.nguyenvancuong.day5_fragment.R
import com.nguyenvancuong.day5_fragment.models.Card
import kotlinx.android.synthetic.main.card_row_item.view.*
import kotlinx.android.synthetic.main.fragment_infor_card.*
import kotlinx.android.synthetic.main.fragment_infor_card.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [InforCardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CardInfoFragment : Fragment(), View.OnClickListener {
    private var card:Card? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            card = it.getSerializable("card") as Card
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View =  inflater.inflate(R.layout.fragment_infor_card, container, false)
        setActions(view)
        view.tv_cardname.text = card?.cardName
        view.tv_cardnumber.text = card?.cardNumber
        view.tv_exp.text = card?.exp
        return view
    }
    private fun setActions(view: View){
        view.btn_update.setOnClickListener(this)
        view.btn_close.setOnClickListener(this)
    }
    fun update(card: Card){
        view?.let {
            this.card = card
            it.tv_cardname.text = card.cardName
            it.tv_cardnumber.text = card.cardNumber
            it.tv_exp.text = card.exp
        }
    }
    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_update->{
                view?.let {
                    val cardB:Bundle = Bundle()
                    cardB.putSerializable("card",card)
                    setFragmentResultListener(UpdateCardFragment.REQUEST_KEY){ resultKey, bundle ->
                        update(bundle.getSerializable("cardUpdated") as Card)
                    }
                    Navigation.findNavController(it).navigate(R.id.action_infor_to_update, cardB)
                }
            }
            R.id.btn_close->{
                view?.let {
                    setFragmentResult(REQUEST_KEY, Bundle().apply {
                        this.putSerializable("card",card)
                    })
                    Navigation.findNavController(it).navigateUp()

                }
            }
        }
    }
    companion object {
        const val REQUEST_KEY = "INFO_REQUEST_KEY"
    }
}