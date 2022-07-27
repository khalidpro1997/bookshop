package com.example.bookshop.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookshop.Adapter.BookAdapter
import com.example.bookshop.R
import com.example.bookshop.ViewModel.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private lateinit var adapter:BookAdapter
    var spinnerPos : Int = 0
    //    val bookCategories = resources.getStringArray(R.array.bookCategories)
    private val viewModel by lazy { ViewModelProviders.of(this).get(BookViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupSpinner()
        adapter = BookAdapter(this,spinnerPos)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
        observeData(0)

        fab.setOnClickListener(View.OnClickListener {
            val i = Intent(this,AddActivity::class.java)
            startActivity(i)
        })

//        val dummyList = mutableListOf<Book>()
//        dummyList.add(Book("ABC","this is a book description of",10,20,"David","https://assets.brightspot.abebooks.a2z.com/dims4/default/995708e/2147483647/strip/true/crop/450x704+0+0/resize/900x1408!/format/webp/quality/90/?url=http%3A%2F%2Fabebooks-brightspot.s3.amazonaws.com%2Fb7%2Fcd%2Fcdd482f84a6a94f264f4746323b0%2Fcocktails-jimmy.png"))


//        adapter.setListData(dummyList)
//        adapter.notifyDataSetChanged()

//        val spinner = findViewById<Spinner>(R.id.spinner)
//        if (spinner!= null){
//            val categoriesAdapter = ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,bookCategories)
//            spinner.adapter = categoriesAdapter
//        }

    }

    fun observeData(spinnerPosition:Int){
        viewModel.fetchBookData().observe(this, Observer {
            adapter.setListData(it,spinnerPosition)
            adapter.notifyDataSetChanged()
        })
    }

    private fun setupSpinner(){
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent!!.getItemAtPosition(position)
                if (position == 0){
                    spinnerPos = 0
                    observeData(spinnerPos)
                } else if (position == 1){
                    spinnerPos = 1
                    observeData(spinnerPos)

                }else if (position == 2){
                    spinnerPos = 2
                    observeData(spinnerPos)

                }else if (position == 3){
                    spinnerPos = 3
                    observeData(spinnerPos)

                }else if (position == 4){
                    spinnerPos = 4
                    observeData(spinnerPos)


                }else if (position == 5){
                    spinnerPos = 5
                    observeData(spinnerPos)

                }else if (position == 6){
                    spinnerPos = 6
                    observeData(spinnerPos)

                }else if (position == 7){
                    spinnerPos = 7
                    observeData(spinnerPos)

                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }
    }

}