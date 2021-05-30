package com.example.bookdatabase.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bookdatabase.R
import com.example.bookdatabase.models.Book
import kotlinx.android.synthetic.main.fragment_book.view.*

class BookFragment(private val book: Book) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.book_fragment_title_text_view.text = book.title
        view.book_fragment_author_text_view.text = book.author
        view.book_fragment_description_text_view.text = book.description
    }

    companion object {
        @JvmStatic
        fun newInstance() = BookFragment(Book("", "", ""))
    }
}