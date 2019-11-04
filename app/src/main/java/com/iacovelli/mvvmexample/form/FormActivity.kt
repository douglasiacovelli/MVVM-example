package com.iacovelli.mvvmexample.form

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.iacovelli.mvvmexample.R
import com.iacovelli.mvvmexample.result.ResultActivity
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {

    private lateinit var viewModel: FormViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        //viewModel = ViewModelProviders.of(this).get(FormViewModel::class.java)
        viewModel = ViewModelProvider(this).get(FormViewModel::class.java)

        setupInputChangeListener()
        setupButtonClickedListener()
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.onUserSentForm.observe(this, Observer {
            startActivity(ResultActivity.createIntent(this, it))
        })
    }

    private fun setupButtonClickedListener() {
        button.setOnClickListener {
            viewModel.onUserRequestedToSendForm()
        }
    }

    private fun setupInputChangeListener() {
        formInput.addTextChangedListener {
            viewModel.onUserChangedInput(it.toString())
        }
    }
}
