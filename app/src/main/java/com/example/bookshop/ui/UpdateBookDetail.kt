package com.example.bookshop.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Toast
import com.example.bookshop.Model.Book
import com.example.bookshop.R
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.SetOptions
import kotlinx.android.synthetic.main.activity_update_book_detail.*
import kotlinx.android.synthetic.main.activity_update_book_detail.book_description_Tv
import kotlinx.android.synthetic.main.activity_update_book_detail.view.*
import kotlinx.android.synthetic.main.book_item.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpdateBookDetail : AppCompatActivity() {
    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_book_detail)


//        val bundle = intent.extras
//        var sampleName: String = ""
//        if (bundle != null) {
//            sampleName = bundle.getString("samplename")
//        }

        val bookName = intent.getStringExtra("bookName")
        val bookDescription = intent.getStringExtra("bookDescription")
        val bookPrice = intent.getStringExtra("bookPrice")
        val bookQuantity = intent.getStringExtra("bookQuantity")
        val bookPublisher = intent.getStringExtra("bookPublisher")
        val bookCategories = intent.getStringExtra("bookCategories")

        bookNameTv.text = bookName
        book_description_Tv.text = bookDescription
        bookPrice_tv.text = bookPrice
        bookQuantityTv.text = bookQuantity
        bookPublisherTv.text = bookPublisher

        addBookNameEt.text = Editable.Factory.getInstance().newEditable(bookName)
        addDescriptionEt.text = Editable.Factory.getInstance().newEditable(bookDescription)
        addPriceEt.text = Editable.Factory.getInstance().newEditable(bookPrice)
        addQtyEt.text = Editable.Factory.getInstance().newEditable(bookQuantity)
        addPublisherEt.text = Editable.Factory.getInstance().newEditable(bookPublisher)

        if (bookCategories.equals("Action and Adventure")){
            addCategoriesSpinner?.setSelection(0)
        } else if (bookCategories.equals("Classics")){
            addCategoriesSpinner?.setSelection(1)
        } else if (bookCategories.equals("Comic Book or Graphic Novel")){
            addCategoriesSpinner?.setSelection(2)
        } else if (bookCategories.equals("Detective and Mystery")){
            addCategoriesSpinner?.setSelection(3)
        } else if (bookCategories.equals("Fantasy")){
            addCategoriesSpinner?.setSelection(4)
        } else if (bookCategories.equals("Historical Fiction")){
            addCategoriesSpinner?.setSelection(5)
        } else if (bookCategories.equals("Horror")){
            addCategoriesSpinner?.setSelection(6)
        } else if (bookCategories.equals("Literary Fiction")){
            addCategoriesSpinner?.setSelection(7)
        }

        deleteBtn.setOnClickListener(View.OnClickListener {
            deleteBook()
        })

        updateBtn.setOnClickListener(View.OnClickListener {
            updateBook()
        })


    }


//    private fun getNewBookDetail(): Map<String, Any> {
//        val bookName = addBookNameEt.text.toString()
//        val bookDescription = addDescriptionEt.text.toString()
//        val bookPrice = addPriceEt.text.toString()
//        val bookQty = addQtyEt.text.toString()
//        val bookPublisher = addPublisherEt.text.toString()
//        val map = mutableMapOf<String, Any>()
//        if (bookName.isNotEmpty()) {
//            map["bookName"] = bookName
//        }
//        if (bookDescription.isNotEmpty()) {
//            map["bookDescription"] = bookDescription
//        }
//
//        if (bookPrice.isNotEmpty()) {
//            map["bookPrice"] = bookPrice
//        }
//
//        if (bookQty.isNotEmpty()) {
//            map["bookQuantity"] = bookQty
//        }
//        if (bookPublisher.isNotEmpty()) {
//            map["bookPublisher"] = bookPublisher
//        }
//        return map
//
//    }

    private fun updateBook(){
     if (addBookNameEt.text.toString().isNotEmpty() && addDescriptionEt.text.toString().isNotEmpty() && addPriceEt.text.toString().isNotEmpty() && addQtyEt.text.toString().isNotEmpty() && addPublisherEt.text.toString().isNotEmpty()){
         val bookName = intent.getStringExtra("bookName")

         val book = hashMapOf(
             "bookName" to addBookNameEt.text.toString(),
             "bookDescription" to addDescriptionEt.text.toString(),
             "bookPrice" to addPriceEt.text.toString(),
             "bookQuantity" to addQtyEt.text.toString(),
             "bookPublisher" to addPublisherEt.text.toString(),
             "bookCategories" to addCategoriesSpinner?.selectedItem.toString()
         )

         val query = FirebaseFirestore.getInstance().collection("Book").whereEqualTo("bookName",bookName).get()
         query.addOnSuccessListener {
             for (document in it){
                 db.collection("Book").document(document.id).set(book, SetOptions.merge()).addOnSuccessListener {
                     val i = Intent(this, MainActivity::class.java)
                     startActivity(i)

                     Toast.makeText(applicationContext,"Updated",Toast.LENGTH_SHORT).show()
                 }
             }
         }


     }
    }


    private fun deleteBook(){
        val bookName = intent.getStringExtra("bookName")

        val query = FirebaseFirestore.getInstance().collection("Book").whereEqualTo("bookName",bookName).get()
        query.addOnSuccessListener {
            for (document in it){
                db.collection("Book").document(document.id).delete().addOnSuccessListener {
                    val i = Intent(this, MainActivity::class.java)
                    startActivity(i)

                    Toast.makeText(applicationContext,"Deleted",Toast.LENGTH_SHORT).show()
                }
            }
        }


    }
}