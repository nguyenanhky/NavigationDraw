package com.nguyenvancuong.day5_fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nguyenvancuong.day5_fragment.adapters.CardAdapter
class MainActivity : AppCompatActivity() {
    val cardAdapter:CardAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}