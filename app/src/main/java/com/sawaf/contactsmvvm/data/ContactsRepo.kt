package com.sawaf.contactsmvvm.data

import androidx.lifecycle.LiveData
import com.sawaf.contactsmvvm.data.Contact

interface ContactsRepo {

    fun observeContacts(): LiveData<List<Contact>>

//    suspend fun getContacts(): List<Contact>

    suspend fun refreshContacts()


}