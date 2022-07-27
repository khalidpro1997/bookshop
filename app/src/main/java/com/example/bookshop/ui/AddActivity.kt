package com.example.bookshop.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.bookshop.Model.Photo
import com.example.bookshop.R
import com.example.bookshop.ViewModel.BookViewModel
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class AddActivity : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 71
    private var filePath: Uri? = null
    private var firebaseStore: FirebaseStorage? = null
    private var storageReference: StorageReference? = null
    private val viewModel by lazy { ViewModelProviders.of(this).get(BookViewModel::class.java) }
    private val photos:ArrayList<Photo> = ArrayList<Photo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        storageReference = FirebaseStorage.getInstance().reference


        addBtn.setOnClickListener(View.OnClickListener {
            insertDatatoDatabase()
        })

        imageView.setOnClickListener(View.OnClickListener {
        launchGallery()
        })
    }

    private fun validateCheck(bookName:String, bookDescription:String,bookPrice:String,bookQuantity:String,bookPublisher:String):Boolean {

        return  !(TextUtils.isEmpty(bookName) && TextUtils.isEmpty(bookDescription) && TextUtils.isEmpty(bookPrice) && TextUtils.isEmpty(bookQuantity) && TextUtils.isEmpty(bookPublisher))

    }


    private fun insertDatatoDatabase(){

        val bookName = addBookNameEt.text.toString()
        val bookDescription = addDescriptionEt.text.toString()
        val bookPrice = addPriceEt.text.toString()
        val bookQuantity = addQtyEt.text.toString()
        val bookPublisher = addPublisherEt.text.toString()
        val bookCategories = addCategoriesSpinner.selectedItem.toString()


        if (validateCheck(bookName,bookDescription,bookPrice,bookQuantity,bookPublisher)) {
            val add = HashMap<String,Any>()
            add["bookName"] = bookName
            add["bookDescription"] = bookDescription
            add["bookPrice"] = bookPrice
            add["bookQuantity"] = bookQuantity
            add["bookPublisher"] = bookPublisher
            add["bookCategories"] = bookCategories

            FirebaseFirestore.getInstance().collection("Book").add(add).addOnSuccessListener {
                uploadImage()

                Toast.makeText(applicationContext,"Successfully added",Toast.LENGTH_SHORT).show()
            } .addOnFailureListener(OnFailureListener {
                Toast.makeText(applicationContext,"Failed",Toast.LENGTH_SHORT).show()
            })

            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }else{
            Toast.makeText(applicationContext,"Please input all field",Toast.LENGTH_SHORT).show()
        }
    }

    private fun launchGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            if(data == null || data.data == null){
                return
            }

            filePath = data.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
                imageView.setImageBitmap(bitmap)
                imageView.setImageURI(filePath)
                val photo = Photo(filePath.toString())



            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }

    private fun uploadImage(){
        if(filePath != null){
            val fileName = UUID.randomUUID().toString() +".jpg"
//            val ref = storageReference?.child("myImages/" + UUID.randomUUID().toString())
            val ref = FirebaseStorage.getInstance().getReference("myImages/$fileName")
            val uploadTask = ref?.putFile(filePath!!)

            ref.putFile(filePath!!).addOnSuccessListener(OnSuccessListener<UploadTask.TaskSnapshot> { taskSnapshot ->
                taskSnapshot.storage.downloadUrl.addOnSuccessListener {
                    imageView.setImageURI(null)
                    Toast.makeText(this, "Image added to firebase", Toast.LENGTH_SHORT).show()
                }
            })

                ?.addOnFailureListener(OnFailureListener { e ->
                    print(e.message)
                })
        } else{
            Toast.makeText(this, "Please Upload an Image", Toast.LENGTH_SHORT).show()
        }
    }

}