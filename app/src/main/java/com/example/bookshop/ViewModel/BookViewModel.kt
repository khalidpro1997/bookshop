package com.example.bookshop.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bookshop.Model.Book
import com.example.bookshop.domain.data.network.Repo

class BookViewModel:ViewModel() {

    val repo = Repo()
    fun fetchBookData():LiveData<MutableList<Book>>{
        val mutabledata = MutableLiveData<MutableList<Book>>()
        repo.getBookData().observeForever{ bookList ->
            mutabledata.value = bookList
        }
        return mutabledata
    }
}