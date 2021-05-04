package com.sawaf.contactsmvvm.main

import androidx.lifecycle.*
import com.sawaf.contactsmvvm.data.Contact
import com.sawaf.contactsmvvm.data.ContactsRepo
import kotlinx.coroutines.launch

class ContactsViewModel(
    private val contactsRepo: ContactsRepo
) : ViewModel() {

    private val _items: LiveData<List<Contact>> =
        contactsRepo.observeContacts().distinctUntilChanged()

    val items: LiveData<List<Contact>> = _items

    init {
        viewModelScope.launch {
            contactsRepo.refreshContacts()
        }
    }
}