package com.nguyenvancuong.day5_fragment.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.nguyenvancuong.day5_fragment.R
import com.nguyenvancuong.day5_fragment.adapters.CardAdapter
import com.nguyenvancuong.day5_fragment.models.Card
import kotlinx.android.synthetic.main.fragment_list_card.*
import kotlinx.android.synthetic.main.fragment_list_card.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
/**
 * A simple [Fragment] subclass.
 * Use the [ListCardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListCardFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var rcvAdapter: CardAdapter?=null;
    private val listCard:MutableList<Card> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initDataAdater()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list_card, container, false)
        rcvAdapter = CardAdapter(listCard,{card, position ->
            infoOnclick(card, view, position)
        });
        view.rcv_card.layoutManager = LinearLayoutManager(container?.context,LinearLayoutManager.VERTICAL,false)
        view.rcv_card.adapter = rcvAdapter;
        return view;
    }
    private fun infoOnclick(card:Card, view:View, position:Int){
        val cardBundle:Bundle = Bundle()
        cardBundle.putSerializable("card",card)
        setFragmentResultListener(CardInfoFragment.REQUEST_KEY){ resultKey, bundle ->
            listCard[position] = bundle.getSerializable("card") as Card
            rcvAdapter?.notifyDataSetChanged()
        }
        Navigation.findNavController(view).navigate(R.id.action_list_to_info,cardBundle)
    }
    private fun initDataAdater(){
        for(i in 10..30){
            listCard.add(Card("123456$i", "Nguyen Van "+('A'+(i-10)),"08/$i"))
        }

    }
}