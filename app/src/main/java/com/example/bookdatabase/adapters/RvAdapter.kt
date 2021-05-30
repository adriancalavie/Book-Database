package com.example.bookdatabase.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.bookdatabase.R
import com.example.bookdatabase.activities.MainActivity
import com.example.bookdatabase.database.Operations
import com.example.bookdatabase.fragments.BookFragment
import com.example.bookdatabase.interfaces.IActivityFragmentCommunication
import com.example.bookdatabase.models.Book
import com.example.bookdatabase.util.HashUtil
import kotlinx.android.synthetic.main.rv_item_book.view.*


class RvAdapter(
    private val books: ArrayList<Book>,
    private val activity: IActivityFragmentCommunication?
) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleView: TextView = itemView.title_text_view
        val authorView: TextView = itemView.author_text_view
        val descriptionView: TextView = itemView.description_text_view
        val btnDelete: Button = itemView.button_delete

        fun bind(book: Book) {
            titleView.text = book.title
            authorView.text = book.author
            descriptionView.text = book.description
        }
    }

    private fun deleteFromDB(key: String, index: Int) {

        val databaseReference = Operations.database.child("books").child(key)
        databaseReference.setValue(null)
        books.removeAt(index)
        notifyItemRemoved(index)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.rv_item_book, parent, false)

        return BookViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentItem = books[position]

        (holder as BookViewHolder).itemView.setOnClickListener {
            val myFragment: Fragment = BookFragment(currentItem)
            (activity as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, myFragment).addToBackStack(null).commit()
        }
        holder.bind(currentItem)

        holder.btnDelete.setOnClickListener(null)
        holder.btnDelete.setOnClickListener {
            deleteFromDB(HashUtil.makeKey(holder.titleView.text.toString() + holder.authorView.text.toString()), position)
        }
    }

    override fun getItemCount() = books.size

}