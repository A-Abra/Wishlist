package com.example.wishlist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wishlist.R.id.*

class MainActivity : AppCompatActivity() {
    var items:MutableList<Wishlist> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val submit = findViewById<Button>(R.id.button)
        val item = findViewById<EditText>(R.id.itemInput)
        val url = findViewById<EditText>(R.id.urlInput)
        val price = findViewById<EditText>(R.id.priceInput)
        val itemRec = findViewById<RecyclerView>(R.id.wishItem)

        val adapter = WishlistAdapter(items)
        itemRec.adapter = adapter
        itemRec.layoutManager = LinearLayoutManager(this)

        submit.setOnClickListener{
            var name = item.text.toString()
            var itemUrl = url.text.toString()
            var price = price.text.toString()
            val item = Wishlist(name, itemUrl, price)
            items.add(item)
            adapter.notifyDataSetChanged()
        }
    }

}