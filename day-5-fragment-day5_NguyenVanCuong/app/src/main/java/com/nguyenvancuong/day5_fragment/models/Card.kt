package com.nguyenvancuong.day5_fragment.models

import android.text.Editable
import java.io.Serializable

class Card(
    val cardNumber: String,
    val cardName:String,
    val exp:String
    ):Serializable {}