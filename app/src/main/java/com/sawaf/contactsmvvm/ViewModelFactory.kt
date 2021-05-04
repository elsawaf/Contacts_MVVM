package com.sawaf.contactsmvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sawaf.contactsmvvm.data.ContactsRepo
import com.sawaf.contactsmvvm.main.ContactsViewModel

class ViewModelFactory(
    private val contactsRepo: ContactsRepo
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactsViewModel::class.java)) {
            return ContactsViewModel(contactsRepo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}