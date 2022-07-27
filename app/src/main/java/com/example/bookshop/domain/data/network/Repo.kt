package com.example.bookshop.domain.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.bookshop.Model.Book
import com.example.bookshop.R
import com.google.firebase.firestore.FirebaseFirestore

class Repo {

    fun getBookData():LiveData<MutableList<Book>>{
        val mutableData = MutableLiveData<MutableList<Book>>()

            FirebaseFirestore.getInstance().collection("Book").get().addOnSuccessListener {result ->
            val listData = mutableListOf<Book>()
            for (document in result){
                val imageUrl = document.getString("imageUrl")
                val bookName = document.getString("bookName")
                val bookDescription = document.getString("bookDescription")
                val bookPrice = document.getString("bookPrice")
                val bookQty = document.getString("bookQuantity")
                val bookPublisher = document.getString("bookPublisher")
                val bookCategories = document.getString("bookCategories")
                val book = Book(bookName,bookDescription,bookPrice, bookQty,bookPublisher,imageUrl,bookCategories)
                listData.add(book)
            }
            mutableData.value =listData
        }
        return mutableData


    }

}