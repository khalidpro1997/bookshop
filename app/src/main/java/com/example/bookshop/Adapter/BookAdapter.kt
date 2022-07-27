package com.example.bookshop.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bookshop.Model.Book
import com.example.bookshop.R
import com.example.bookshop.ui.UpdateBookDetail
import kotlinx.android.synthetic.main.book_item.view.*

class BookAdapter(val context: Context, spinnerPos: Int) :
    RecyclerView.Adapter<BookAdapter.MainViewHolder>() {

    private var dataList = mutableListOf<Book>()
    var spinnerPosition = spinnerPos

    fun setListData(data: MutableList<Book>, spinnerPosi: Int) {
        dataList = data
        spinnerPosition = spinnerPosi
    }

    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


//        init {
//            val model = dataList.get(position)
//            var bookName:String = model.bookName.toString()
//            var bookDescription = model.bookDescription.toString()
//            var bookQuantity = model.bookQuantity.toString()
//            var bookPublisher = model.bookPublisher.toString()
//            var bookPrice = model.bookPrice.toString()
//          itemView.setOnClickListener {
//              val i = Intent(context.applicationContext,UpdateBookDetail::class.java)
//              i.putExtra("bookName",bookName)
//              i.putExtra("bookDescription",bookDescription)
//              i.putExtra("bookPublisher",bookPublisher)
//              i.putExtra("bookPrice",bookPrice)
//              i.putExtra("bookQuantity",bookQuantity)
//
//              context.startActivity(i)
//          }
//        }

        fun bindView(book: Book,holder: MainViewHolder) {
//            if (book.bookCategories.equals())
            val categoriesArray = context.resources.getStringArray(R.array.bookCategories)

            if (spinnerPosition == 0) {
                if (book.bookCategories.equals(categoriesArray[0])) {
                    Glide.with(context).load(book.bookImageUrl).into(itemView.circleImageView)
                    itemView.book_description_Tv.text = "Description: " + book.bookDescription
                    itemView.book_price_Tv.text = "Price: " + book.bookPrice.toString()
                    itemView.book_quantity_Tv.text = "Quantity: " + book.bookQuantity.toString()
                    itemView.book_title_Tv.text = "Name: " + book.bookName
                    itemView.book_publisher_Tv.text = "Publisher: " + book.bookPublisher
                    itemView.book_category_Tv.text = "Category: " + book.bookCategories
                    itemView.visibility = View.VISIBLE
                    holder.itemView.layoutParams = LinearLayout.LayoutParams(MATCH_PARENT,
                        WRAP_CONTENT)


                } else {
//                    itemView.circleImageView.visibility = View.VISIBLE
//                    itemView.book_description_Tv.visibility = View.VISIBLE
//                    itemView.book_price_Tv.visibility = View.VISIBLE
//                    itemView.book_quantity_Tv.visibility = View.VISIBLE
//                    itemView.book_title_Tv.visibility = View.VISIBLE
//                    itemView.book_publisher_Tv.visibility = View.VISIBLE
//                    itemView.book_category_Tv.visibility = View.VISIBLE
//                    Glide.with(context).load(book.bookImageUrl).into(itemView.circleImageView)
//                    itemView.book_description_Tv.text = "Description: " + book.bookDescription
//                    itemView.book_price_Tv.text = "Price: " + book.bookPrice.toString()
//                    itemView.book_quantity_Tv.text = "Quantity: " + book.bookQuantity.toString()
//                    itemView.book_title_Tv.text = "Name: " + book.bookName
//                    itemView.book_publisher_Tv.text = "Publisher: " + book.bookPublisher
//                    itemView.book_category_Tv.text = "Category: " + book.bookCategories
                    itemView.visibility = View.GONE
                    holder.itemView.layoutParams = LinearLayout.LayoutParams(0,0)


                }
            } else if (spinnerPosition == 1) {
                if (book.bookCategories.equals(categoriesArray[1])) {
                    Glide.with(context).load(book.bookImageUrl).into(itemView.circleImageView)
                    itemView.book_description_Tv.text = "Description: " + book.bookDescription
                    itemView.book_price_Tv.text = "Price: " + book.bookPrice.toString()
                    itemView.book_quantity_Tv.text = "Quantity: " + book.bookQuantity.toString()
                    itemView.book_title_Tv.text = "Name: " + book.bookName
                    itemView.book_publisher_Tv.text = "Publisher: " + book.bookPublisher
                    itemView.book_category_Tv.text = "Category: " + book.bookCategories
                    itemView.visibility = View.VISIBLE
                    holder.itemView.layoutParams = LinearLayout.LayoutParams(MATCH_PARENT,
                        WRAP_CONTENT)
                } else {
//                    itemView.circleImageView.visibility = View.VISIBLE
//                    itemView.book_description_Tv.visibility = View.VISIBLE
//                    itemView.book_price_Tv.visibility = View.VISIBLE
//                    itemView.book_quantity_Tv.visibility = View.VISIBLE
//                    itemView.book_title_Tv.visibility = View.VISIBLE
//                    itemView.book_publisher_Tv.visibility = View.VISIBLE
//                    itemView.book_category_Tv.visibility = View.VISIBLE
//                    Glide.with(context).load(book.bookImageUrl).into(itemView.circleImageView)
//                    itemView.book_description_Tv.text = "Description: " + book.bookDescription
//                    itemView.book_price_Tv.text = "Price: " + book.bookPrice.toString()
//                    itemView.book_quantity_Tv.text = "Quantity: " + book.bookQuantity.toString()
//                    itemView.book_title_Tv.text = "Name: " + book.bookName
//                    itemView.book_publisher_Tv.text = "Publisher: " + book.bookPublisher
//                    itemView.book_category_Tv.text = "Category: " + book.bookCategories
                    itemView.visibility = View.GONE
                    holder.itemView.layoutParams = LinearLayout.LayoutParams(0,0)

                }
            } else if (spinnerPosition == 2) {
//                if (itemView.book_category_Tv.text.equals(categoriesArray[2])) {
                if (book.bookCategories.equals(categoriesArray[2])) {

                    Glide.with(context).load(book.bookImageUrl).into(itemView.circleImageView)
                    itemView.book_description_Tv.text = "Description: " + book.bookDescription
                    itemView.book_price_Tv.text = "Price: " + book.bookPrice.toString()
                    itemView.book_quantity_Tv.text = "Quantity: " + book.bookQuantity.toString()
                    itemView.book_title_Tv.text = "Name: " + book.bookName
                    itemView.book_publisher_Tv.text = "Publisher: " + book.bookPublisher
                    itemView.book_category_Tv.text = "Category: " + book.bookCategories
                    itemView.visibility = View.VISIBLE
                    holder.itemView.layoutParams = LinearLayout.LayoutParams(MATCH_PARENT,
                        WRAP_CONTENT)
                } else {
//                    itemView.circleImageView.visibility = View.VISIBLE
//                    itemView.book_description_Tv.visibility = View.VISIBLE
//                    itemView.book_price_Tv.visibility = View.VISIBLE
//                    itemView.book_quantity_Tv.visibility = View.VISIBLE
//                    itemView.book_title_Tv.visibility = View.VISIBLE
//                    itemView.book_publisher_Tv.visibility = View.VISIBLE
//                    itemView.book_category_Tv.visibility = View.VISIBLE
//                    Glide.with(context).load(book.bookImageUrl).into(itemView.circleImageView)
//                    itemView.book_description_Tv.text = "Description: " + book.bookDescription
//                    itemView.book_price_Tv.text = "Price: " + book.bookPrice.toString()
//                    itemView.book_quantity_Tv.text = "Quantity: " + book.bookQuantity.toString()
//                    itemView.book_title_Tv.text = "Name: " + book.bookName
//                    itemView.book_publisher_Tv.text = "Publisher: " + book.bookPublisher
//                    itemView.book_category_Tv.text = "Category: " + book.bookCategories
                    itemView.visibility = View.GONE
                    holder.itemView.layoutParams = LinearLayout.LayoutParams(0,0)

                }
            } else if (spinnerPosition == 3) {

//                if (itemView.book_category_Tv.text.equals(categoriesArray[3])) {
                if (book.bookCategories.equals(categoriesArray[3])) {

                    Glide.with(context).load(book.bookImageUrl).into(itemView.circleImageView)
                    itemView.book_description_Tv.text = "Description: " + book.bookDescription
                    itemView.book_price_Tv.text = "Price: " + book.bookPrice.toString()
                    itemView.book_quantity_Tv.text = "Quantity: " + book.bookQuantity.toString()
                    itemView.book_title_Tv.text = "Name: " + book.bookName
                    itemView.book_publisher_Tv.text = "Publisher: " + book.bookPublisher
                    itemView.book_category_Tv.text = "Category: " + book.bookCategories
                    itemView.visibility = View.VISIBLE
                    holder.itemView.layoutParams = LinearLayout.LayoutParams(MATCH_PARENT,
                        WRAP_CONTENT)
                } else {
//                    itemView.circleImageView.visibility = View.VISIBLE
//                    itemView.book_description_Tv.visibility = View.VISIBLE
//                    itemView.book_price_Tv.visibility = View.VISIBLE
//                    itemView.book_quantity_Tv.visibility = View.VISIBLE
//                    itemView.book_title_Tv.visibility = View.VISIBLE
//                    itemView.book_publisher_Tv.visibility = View.VISIBLE
//                    itemView.book_category_Tv.visibility = View.VISIBLE
//                    Glide.with(context).load(book.bookImageUrl).into(itemView.circleImageView)
//                    itemView.book_description_Tv.text = "Description: " + book.bookDescription
//                    itemView.book_price_Tv.text = "Price: " + book.bookPrice.toString()
//                    itemView.book_quantity_Tv.text = "Quantity: " + book.bookQuantity.toString()
//                    itemView.book_title_Tv.text = "Name: " + book.bookName
//                    itemView.book_publisher_Tv.text = "Publisher: " + book.bookPublisher
//                    itemView.book_category_Tv.text = "Category: " + book.bookCategories
                    itemView.visibility = View.GONE
                    holder.itemView.layoutParams = LinearLayout.LayoutParams(0,0)

                }
            } else if (spinnerPosition == 4) {
//                if (itemView.book_category_Tv.text.equals(categoriesArray[4])) {
                if (book.bookCategories.equals(categoriesArray[4])) {
                    Glide.with(context).load(book.bookImageUrl).into(itemView.circleImageView)
                    itemView.book_description_Tv.text = "Description: " + book.bookDescription
                    itemView.book_price_Tv.text = "Price: " + book.bookPrice.toString()
                    itemView.book_quantity_Tv.text = "Quantity: " + book.bookQuantity.toString()
                    itemView.book_title_Tv.text = "Name: " + book.bookName
                    itemView.book_publisher_Tv.text = "Publisher: " + book.bookPublisher
                    itemView.book_category_Tv.text = "Category: " + book.bookCategories
                    itemView.visibility = View.VISIBLE
                    holder.itemView.layoutParams = LinearLayout.LayoutParams(MATCH_PARENT,
                        WRAP_CONTENT)
                } else {
//                    itemView.circleImageView.visibility = View.VISIBLE
//                    itemView.book_description_Tv.visibility = View.VISIBLE
//                    itemView.book_price_Tv.visibility = View.VISIBLE
//                    itemView.book_quantity_Tv.visibility = View.VISIBLE
//                    itemView.book_title_Tv.visibility = View.VISIBLE
//                    itemView.book_publisher_Tv.visibility = View.VISIBLE
//                    itemView.book_category_Tv.visibility = View.VISIBLE
//                    Glide.with(context).load(book.bookImageUrl).into(itemView.circleImageView)
//                    itemView.book_description_Tv.text = "Description: " + book.bookDescription
//                    itemView.book_price_Tv.text = "Price: " + book.bookPrice.toString()
//                    itemView.book_quantity_Tv.text = "Quantity: " + book.bookQuantity.toString()
//                    itemView.book_title_Tv.text = "Name: " + book.bookName
//                    itemView.book_publisher_Tv.text = "Publisher: " + book.bookPublisher
//                    itemView.book_category_Tv.text = "Category: " + book.bookCategories
                    itemView.visibility = View.GONE
                    holder.itemView.layoutParams = LinearLayout.LayoutParams(0,0)

                }
            } else if (spinnerPosition == 5) {

//                if (itemView.book_category_Tv.text.equals(categoriesArray[5])) {
                if (book.bookCategories.equals(categoriesArray[5])) {
                    Glide.with(context).load(book.bookImageUrl).into(itemView.circleImageView)
                    itemView.book_description_Tv.text = "Description: " + book.bookDescription
                    itemView.book_price_Tv.text = "Price: " + book.bookPrice.toString()
                    itemView.book_quantity_Tv.text = "Quantity: " + book.bookQuantity.toString()
                    itemView.book_title_Tv.text = "Name: " + book.bookName
                    itemView.book_publisher_Tv.text = "Publisher: " + book.bookPublisher
                    itemView.book_category_Tv.text = "Category: " + book.bookCategories
                    itemView.visibility = View.VISIBLE
                    holder.itemView.layoutParams = LinearLayout.LayoutParams(MATCH_PARENT,
                        WRAP_CONTENT)
                } else {
//                    itemView.circleImageView.visibility = View.VISIBLE
//                    itemView.book_description_Tv.visibility = View.VISIBLE
//                    itemView.book_price_Tv.visibility = View.VISIBLE
//                    itemView.book_quantity_Tv.visibility = View.VISIBLE
//                    itemView.book_title_Tv.visibility = View.VISIBLE
//                    itemView.book_publisher_Tv.visibility = View.VISIBLE
//                    itemView.book_category_Tv.visibility = View.VISIBLE
//                    Glide.with(context).load(book.bookImageUrl).into(itemView.circleImageView)
//                    itemView.book_description_Tv.text = "Description: " + book.bookDescription
//                    itemView.book_price_Tv.text = "Price: " + book.bookPrice.toString()
//                    itemView.book_quantity_Tv.text = "Quantity: " + book.bookQuantity.toString()
//                    itemView.book_title_Tv.text = "Name: " + book.bookName
//                    itemView.book_publisher_Tv.text = "Publisher: " + book.bookPublisher
//                    itemView.book_category_Tv.text = "Category: " + book.bookCategories
                    itemView.visibility = View.GONE
                    holder.itemView.layoutParams = LinearLayout.LayoutParams(0,0)

                }
            } else if (spinnerPosition == 6) {

//                if (itemView.book_category_Tv.text.equals(categoriesArray[6])) {
                if (book.bookCategories.equals(categoriesArray[6])) {
                    Glide.with(context).load(book.bookImageUrl).into(itemView.circleImageView)
                    itemView.book_description_Tv.text = "Description: " + book.bookDescription
                    itemView.book_price_Tv.text = "Price: " + book.bookPrice.toString()
                    itemView.book_quantity_Tv.text = "Quantity: " + book.bookQuantity.toString()
                    itemView.book_title_Tv.text = "Name: " + book.bookName
                    itemView.book_publisher_Tv.text = "Publisher: " + book.bookPublisher
                    itemView.book_category_Tv.text = "Category: " + book.bookCategories
                    itemView.visibility = View.VISIBLE
                    holder.itemView.layoutParams = LinearLayout.LayoutParams(MATCH_PARENT,
                        WRAP_CONTENT)
                } else {
//                    itemView.circleImageView.visibility = View.VISIBLE
//                    itemView.book_description_Tv.visibility = View.VISIBLE
//                    itemView.book_price_Tv.visibility = View.VISIBLE
//                    itemView.book_quantity_Tv.visibility = View.VISIBLE
//                    itemView.book_title_Tv.visibility = View.VISIBLE
//                    itemView.book_publisher_Tv.visibility = View.VISIBLE
//                    itemView.book_category_Tv.visibility = View.VISIBLE
//                Glide.with(context).load(book.bookImageUrl).into(itemView.circleImageView)
//                itemView.book_description_Tv.text = "Description: " + book.bookDescription
//                itemView.book_price_Tv.text = "Price: " + book.bookPrice.toString()
//                itemView.book_quantity_Tv.text = "Quantity: " + book.bookQuantity.toString()
//                itemView.book_title_Tv.text = "Name: " + book.bookName
//                itemView.book_publisher_Tv.text = "Publisher: " + book.bookPublisher
//                itemView.book_category_Tv.text = "Category: " + book.bookCategories
                    itemView.visibility = View.GONE
                    holder.itemView.layoutParams = LinearLayout.LayoutParams(0,0)


                }
            } else if (spinnerPosition == 7) {
//            if (itemView.book_category_Tv.text.equals(categoriesArray[7])) {
                if (book.bookCategories.equals(categoriesArray[7])) {
                    Glide.with(context).load(book.bookImageUrl).into(itemView.circleImageView)
                    itemView.book_description_Tv.text = "Description: " + book.bookDescription
                    itemView.book_price_Tv.text = "Price: " + book.bookPrice.toString()
                    itemView.book_quantity_Tv.text = "Quantity: " + book.bookQuantity.toString()
                    itemView.book_title_Tv.text = "Name: " + book.bookName
                    itemView.book_publisher_Tv.text = "Publisher: " + book.bookPublisher
                    itemView.book_category_Tv.text = "Category: " + book.bookCategories
                    itemView.visibility = View.VISIBLE
                    holder.itemView.layoutParams = LinearLayout.LayoutParams(MATCH_PARENT,
                        WRAP_CONTENT)
                } else {
//                itemView.circleImageView.visibility = View.VISIBLE
//                itemView.book_description_Tv.visibility = View.VISIBLE
//                itemView.book_price_Tv.visibility = View.VISIBLE
//                itemView.book_quantity_Tv.visibility = View.VISIBLE
//                itemView.book_title_Tv.visibility = View.VISIBLE
//                itemView.book_publisher_Tv.visibility = View.VISIBLE
//                itemView.book_category_Tv.visibility = View.VISIBLE
//                Glide.with(context).load(book.bookImageUrl).into(itemView.circleImageView)
//                itemView.book_description_Tv.text = "Description: " + book.bookDescription
//                itemView.book_price_Tv.text = "Price: " + book.bookPrice.toString()
//                itemView.book_quantity_Tv.text = "Quantity: " + book.bookQuantity.toString()
//                itemView.book_title_Tv.text = "Name: " + book.bookName
//                itemView.book_publisher_Tv.text = "Publisher: " + book.bookPublisher
//                itemView.book_category_Tv.text = "Category: " + book.bookCategories\
                    itemView.visibility = View.GONE
                    holder.itemView.layoutParams = LinearLayout.LayoutParams(0,0)

                }
//        }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.book_item, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val book: Book = dataList[position]
        val categoriesArray = context.resources.getStringArray(R.array.bookCategories)
//            if (book.bookCategories.equals(categoriesArray[0].toString())){
//                holder.bindView(book)
//            } else if (book.bookCategories.equals(categoriesArray[1].toString())){
//                holder.bindView(book)
//            }else if (book.bookCategories.equals(categoriesArray[2].toString())){
//                holder.bindView(book)
//            }else if (book.bookCategories.equals(categoriesArray[3].toString())){
//                holder.bindView(book)
//            }else if (book.bookCategories.equals(categoriesArray[4].toString())){
//                holder.bindView(book)
//            }else if (book.bookCategories.equals(categoriesArray[5].toString())){
//                holder.bindView(book)
//            }else if (book.bookCategories.equals(categoriesArray[6].toString())){
//                holder.bindView(book)
//            }else if (book.bookCategories.equals(categoriesArray[7].toString())){
//                holder.bindView(book)
//            } else{
//                return
//        }

      holder.bindView(book,holder)


        holder.itemView.setOnClickListener {
            val bookName = book.bookName
            val bookDescription = book.bookDescription
            val bookPublisher = book.bookPublisher
            val bookPrice = book.bookPrice
            val bookQuantity = book.bookQuantity
            val bookCategory = book.bookCategories
            val imageUrl = book.bookImageUrl
            val i = Intent(context.applicationContext, UpdateBookDetail::class.java)
            i.putExtra("bookName", bookName)
            i.putExtra("bookDescription", bookDescription)
            i.putExtra("bookPublisher", bookPublisher)
            i.putExtra("bookPrice", bookPrice)
            i.putExtra("bookQuantity", bookQuantity)
            i.putExtra("bookCategories", bookCategory)
            i.putExtra("imageUrl",imageUrl)

            context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        if (dataList.size > 0) {
            return dataList.size
        } else {
            return 0
        }
    }


}