package com.sawaf.contactsmvvm.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sawaf.contactsmvvm.R
import com.sawaf.contactsmvvm.data.Contact
import com.sawaf.contactsmvvm.databinding.ContactItemBinding
import com.sawaf.contactsmvvm.main.ContactsAdapter.ViewHolder

class ContactsAdapter :
        ListAdapter<Contact, ViewHolder>(ContactDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder(private val itemBinding: ContactItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(item: Contact) {
            itemBinding.contactNameTv.text = item.name
            itemBinding.contactPhoneTv.text = item.phone
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
//                val binding = ContactItemBinding.inflate(layoutInflater, parent, false)
                val itemView = layoutInflater.inflate(R.layout.contact_item, parent, false)
                val binding = ContactItemBinding.bind(itemView)
                return ViewHolder(binding)
            }
        }

    }
}

/**
 * Callback for calculating the diff between two non-null items in a list.
 *
 * Used by ListAdapter to calculate the minimum number of changes between and old list and a new
 * list that's been passed to `submitList`.
 */
class ContactDiffCallback : DiffUtil.ItemCallback<Contact>() {
    override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem.phone == newItem.phone
    }

    override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
        return oldItem == newItem
    }
}