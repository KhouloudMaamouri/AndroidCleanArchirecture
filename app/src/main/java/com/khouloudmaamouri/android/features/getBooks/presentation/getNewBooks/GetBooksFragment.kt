package com.khouloudmaamouri.android.features.getBooks.presentation.getNewBooks

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.khouloudmaamouri.android.core.Resource
import com.khouloudmaamouri.android.databinding.FragmentGetBooksBinding
import com.khouloudmaamouri.android.features.getBooks.data.local.BookCacheEntity
import com.khouloudmaamouri.android.features.getBooks.data.remote.NewBooksApi
import com.khouloudmaamouri.android.features.getBooks.data.remote.dto.Book
import com.khouloudmaamouri.android.features.getBooks.presentation.getNewBooks.adapter.NewBooksAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GetBooksFragment : Fragment(), NewBooksAdapter.INewBooksAdapter {

    private val TAG = GetBooksFragment::class.simpleName
    private lateinit var viewModel: GetBooksViewModel
    private lateinit var binding: FragmentGetBooksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(requireActivity()).get(GetBooksViewModel::class.java)
        binding = FragmentGetBooksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getBooks()
        subscribeObserverGetBooks()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun subscribeObserverGetBooks() {
        viewModel.books.removeObservers(viewLifecycleOwner)
        viewModel.books.observe(viewLifecycleOwner) { books ->
            books?.let { booksItems ->
                when (booksItems) {
                    is Resource.Success -> {
                        booksItems.data?.let { myBooks ->
                            setupRecyclerView(myBooks)
                        }
                    }
                    is Resource.Error -> {
                        Log.d(TAG, "subscribeObserverGetBooks: Error")
                        Toast.makeText(
                            requireContext(),
                            "Une erreur est survenue",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    is Resource.Loading -> {
                        Log.d(TAG, "subscribeObserverGetBooks: Loading")
                    }
                }
            }
        }
    }


    private fun setupRecyclerView(books: List<BookCacheEntity?>) {
        val mNewBooksAdapter = NewBooksAdapter(this@GetBooksFragment,requireContext())
        mNewBooksAdapter.setData(books)

        val llm = LinearLayoutManager(requireContext())
        llm.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerViewListBooks.layoutManager = llm
        binding.recyclerViewListBooks.adapter = mNewBooksAdapter
    }

    override fun onItemClickedBook(mBook: Book) {
        Log.d(TAG, "onItemClickedBook: ${mBook.title}")
    }
}