package gst.trainingcourse.day5_nguyenquockhanh.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import gst.trainingcourse.day5_nguyenquockhanh.domain.entity.Card

class CardViewModel : ViewModel() {
    val listCard = MutableLiveData<List<Card>>()
    val card = MutableLiveData<Card>()
    val cardName = MutableLiveData<String>()
    val cardNumber = MutableLiveData<String>()
    val expDate = MutableLiveData<String>()

    var position = 0

    init {
        listCard.value = listOf(
            Card("Nguyen Van A", "21610000625432", "02/30"),
            Card("Nguyen Van B", "21610000625432", "02/30"),
            Card("Nguyen Van C", "21610000625432", "02/30"),
            Card("Nguyen Van D", "21610000625432", "02/30"),
            Card("Nguyen Van E", "21610000625432", "02/30"),
        )
    }

    fun setCardData() {
        cardName.value = card.value!!.name
        cardNumber.value = card.value!!.cardNumber
        expDate.value = card.value!!.expDate
    }

    fun saveDate(): Boolean {
        if (validCard()) {
            val updatedCard = Card(
                name = cardName.value!!,
                cardNumber = cardNumber.value!!,
                expDate = expDate.value!!
            )

            card.value = updatedCard
            listCard.value!![position].apply {
                name = updatedCard.name
                cardNumber = updatedCard.cardNumber
                expDate = updatedCard.expDate
            }

            return true
        }

        return false
    }

    private fun validCard(): Boolean {
        return cardName.value != null && cardNumber.value != null && expDate.value != null
    }
}