package com.sawaf.contactsmvvm.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sawaf.contactsmvvm.R
import com.sawaf.contactsmvvm.ViewModelFactory
import com.sawaf.contactsmvvm.data.DefaultContactsRepo

class ContactsFragment : Fragment() {

    companion object {
        fun newInstance() = ContactsFragment()
    }

    private lateinit var viewModel: ContactsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.contacts_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val viewModelFactory = ViewModelFactory(DefaultContactsRepo())
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(ContactsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}