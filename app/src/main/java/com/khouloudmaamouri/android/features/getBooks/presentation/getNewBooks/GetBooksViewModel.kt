package com.khouloudmaamouri.android.features.getBooks.presentation.getNewBooks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khouloudmaamouri.android.core.Resource
import com.khouloudmaamouri.android.features.getBooks.data.local.BookCacheEntity
import com.khouloudmaamouri.android.features.getBooks.domain.useCases.GetNewBooksUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GetBooksViewModel @Inject constructor(
    private val mGetNewBooksUseCase: GetNewBooksUseCase,
) : ViewModel() {

    private val _books: MutableLiveData<Resource<List<BookCacheEntity?>?>> =
        MutableLiveData<Resource<List<BookCacheEntity?>?>>()
    val books: LiveData<Resource<List<BookCacheEntity?>?>>
        get() = _books


    fun getBooks() {
        viewModelScope.launch(Dispatchers.IO) {
            mGetNewBooksUseCase.invoke()
                .onEach { resource ->
                    _books.postValue(resource)
                }.launchIn(viewModelScope)
        }
    }
}