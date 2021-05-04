package com.sawaf.contactsmvvm.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
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

    /**
     * Only called upon fragment creation and reattachment, not restart
     *
     * Fragment lifecycle: attach, create, createView, viewCreated, activityCreated, start.
     *
     * In case of viewLifecycle: createView, viewCreated, start.
     * */
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // so it's a suitable place for setup all things as it's called only with attachment state
        val viewModelFactory = ViewModelFactory(DefaultContactsRepo())
        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(ContactsViewModel::class.java)

        setupListAdapter()
    }

    private fun setupListAdapter() {
        val listAdapter = ContactsAdapter()
        view?.findViewById<RecyclerView>(R.id.contacts_list)?.adapter = listAdapter

        viewModel.items.observe(viewLifecycleOwner) {
            listAdapter.submitList(it)
        }

    }

}