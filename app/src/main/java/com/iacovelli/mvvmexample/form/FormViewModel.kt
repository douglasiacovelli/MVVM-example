package com.iacovelli.mvvmexample.form

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FormViewModel: ViewModel() {

    private var inputValue = ""
    private val _onUserSentForm = MutableLiveData<String>()
    val onUserSentForm: LiveData<String> = _onUserSentForm

    fun onUserRequestedToSendForm() {
        _onUserSentForm.value = inputValue
    }

    fun onUserChangedInput(inputValue: String) {
        this.inputValue = inputValue
    }
}