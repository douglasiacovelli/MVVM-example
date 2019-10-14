package com.iacovelli.mvvmexample.result

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.iacovelli.mvvmexample.R

class ResultActivity : AppCompatActivity() {

    private val text by lazy { intent.getStringExtra(TEXT)!! }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        setupUI()
    }

    private fun setupUI() {
        findViewById<TextView>(R.id.result).text = text.length.toString()
    }

    companion object {
        private const val TEXT = "text"

        fun createIntent(context: Context, text: String): Intent {
            return Intent(context, ResultActivity::class.java).apply {
                putExtra(TEXT, text)
            }
        }
    }
}
