package com.example.wishlist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist.R.id.*

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Getting recycler view
        recyclerView = findViewById(R.id.wishItem)

        //Default card
        recyclerView.adapter = WishlistAdapter(
            listOf(
                Wishlist(itemNameModel = "", itemPriceModel = "", itemURLModel = "")))


        //Setting the layout to linear
        recyclerView.layoutManager = LinearLayoutManager(this)

        //Button used to generate new card in RecyclerView with item info
        //Getting button and setting click event
        findViewById<Button>(button).setOnClickListener {
            //
            addCard()
        }

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun addCard() {
        val nameInputText = findViewById<EditText>(itemInput)
        val priceInputText = findViewById<EditText>(priceInput)
        val urlInputText = findViewById<EditText>(urlInput)

        val newItem = Wishlist(nameInputText.text.toString(), priceInputText.text.toString(), urlInputText.text.toString())

        val adapter = recyclerView.adapter as WishlistAdapter
        adapter.upDateWishList(adapter.wishListModel + newItem)


        nameInputText.setText("")
        priceInputText.setText("")
        urlInputText.setText("")
    }
}