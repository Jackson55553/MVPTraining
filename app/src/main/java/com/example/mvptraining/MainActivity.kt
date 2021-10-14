package com.example.mvptraining

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mvptraining.databinding.ActivityMainBinding
import java.lang.IllegalStateException

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listener = View.OnClickListener {
            val type = when(it.id){
                R.id.btn_counter1 -> CounterType.FIRST
                R.id.btn_counter2 -> CounterType.SECOND
                R.id.btn_counter3 -> CounterType.THIRD
                else -> throw IllegalStateException("такой кнопки нет")
            }
            presenter.counterClick(type)
        }

        binding.btnCounter1.setOnClickListener(listener)
        binding.btnCounter2.setOnClickListener(listener)
        binding.btnCounter3.setOnClickListener(listener)
    }

    
    override fun setButtonText(type: CounterType, text: String) {
        when(type){
            CounterType.FIRST -> binding.btnCounter1.text = text
            CounterType.SECOND -> binding.btnCounter2.text = text
            CounterType.THIRD -> binding.btnCounter3.text = text
        }
    }
}