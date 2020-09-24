package cl.maps.google.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import cl.maps.google.R
import cl.maps.google.view.ListQuoteragment.Companion.newInstance
import cl.maps.google.view.QuoteFragment.Companion.newInstance
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonMap.setOnClickListener{
                    }
       }
    }

