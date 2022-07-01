package gst.trainingcourse.day5_nguyenquockhanh.presentation

import activityViewBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import gst.trainingcourse.day5_nguyenquockhanh.R
import gst.trainingcourse.day5_nguyenquockhanh.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by activityViewBinding(ActivityMainBinding::inflate)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}