package com.sawaf.contactsmvvm.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sawaf.contactsmvvm.data.Contact
import com.sawaf.contactsmvvm.data.ContactsRepo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class DefaultContactsRepo(
    private val ioDispatcher: CoroutineDispatcher =Dispatchers.IO
): ContactsRepo {


    private val observableContacts = MutableLiveData<List<Contact>>()

    fun getContacts(): List<Contact> {
        return listOf(
            Contact("Sawaf", "01111111"),
            Contact("Sawaf2", "02222222")
        )
    }

    override fun observeContacts(): LiveData<List<Contact>> {
        return observableContacts
    }

    override suspend fun refreshContacts() {
        observableContacts.postValue(getContacts())
    }
}