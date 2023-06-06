package com.google.ar.core.examples.kotlin.helloar

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomePageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content view to activity_home_page.xml
        setContentView(R.layout.activity_home_page)

        // Retrieve the ListView from the layout
        val listView: ListView = findViewById(R.id.list_view)

        val item1 = ListItem(
            "Item 1",
            "desc",
            "models/Chair_albedo.png",//image
            "models/Chair.obj",
            "models/Chair_Metallic.png",
            "models/Chair_albedo.png",
            "models/Chair_albedo_instant_placement.png",
        )

        val item2 = ListItem(
            "Item 2",
            "desc",
            "models/pawn_albedo.png",//image
            "models/pawn.obj",
            "models/pawn_roughness_metallic_ao.png",
            "models/pawn_albedo.png",
            "models/pawn_albedo_instant_placement.png",
        )

        // Create an array of items for the ListView
        val items = arrayOf(
            item1, item2
        )


        // Create a custom ArrayAdapter that uses the list_item_layout.xml layout file
        val adapter = object : ArrayAdapter<ListItem>(this, R.layout.list_item_layout, items) {
            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false)

                // Get the item at the specified position
                val listItem = items[position]

                // Set the name and description in the TextViews
                val nameTextView = view.findViewById<TextView>(R.id.item_name)
                nameTextView.text = listItem.name

                val descriptionTextView = view.findViewById<TextView>(R.id.item_description)
                descriptionTextView.text = listItem.description

                val imageImageView = view.findViewById<ImageView>(R.id.item_image)
                val uri =  Uri.parse(listItem.imagePath)
                imageImageView.setImageURI(uri)

                return view
            }
        }

        listView.adapter = adapter

        // Set an item click listener for the ListView
        listView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                // Start the AR view activity when an item is tapped
                val selectedItem: ListItem = items[position]
                val intent = Intent(this, HelloArActivity::class.java)
                intent.putExtra("selectedItem", selectedItem)

                startActivity(intent)
            }
    }
}

