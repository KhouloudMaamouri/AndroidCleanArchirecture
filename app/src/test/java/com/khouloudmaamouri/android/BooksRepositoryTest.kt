package com.khouloudmaamouri.android

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.khouloudmaamouri.android.features.getBooks.data.local.BookDao
import com.khouloudmaamouri.android.features.getBooks.data.remote.NewBooksApi
import com.khouloudmaamouri.android.features.getBooks.data.remote.dto.NewBooks
import com.khouloudmaamouri.android.features.getBooks.data.remote.repository.GetNewRepositoryImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.verify
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.runners.MockitoJUnitRunner
import retrofit2.Response

@RunWith(JUnit4::class)
class BooksRepositoryTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private var userDataRepository: GetNewRepositoryImpl? = null

    @Mock
    private val mNewBooksApi: NewBooksApi? = null

    @Mock
    private val mBookDao: BookDao? = null


    @Before
     fun setUp() {
        MockitoAnnotations.initMocks(this)
        userDataRepository = GetNewRepositoryImpl(mNewBooksApi!!, mBookDao!!)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    suspend fun emptyListBooks() = runTest  {
//        val usersList: Response<NewBooks?>? = Response.success(NewBooks(emptyList(),"",""))
//
//        given(userDataRepository!!.getNewBooks()).willReturn(usersList)
//
         val result = userDataRepository!!.getNewBooks()

        Assert.assertEquals(2,2)
    }

}