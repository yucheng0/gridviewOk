package com.example.givemepass.gridviewdemo

import android.os.Bundle
import android.widget.AdapterView
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private val image = intArrayOf(R.drawable.cat, R.drawable.flower, R.drawable.hippo, R.drawable.monkey, R.drawable.mushroom, R.drawable.panda, R.drawable.rabbit, R.drawable.raccoon)
    private val imgText = arrayOf("cat", "flower", "hippo", "monkey", "mushroom", "panda", "rabbit", "raccoon")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val items = ArrayList<Map<String, Any>>()
        for (i in image.indices) {
            val item = HashMap<String, Any>()
            item["image"] = image[i]
            item["text"] = imgText[i]
            items.add(item)
        }
        val adapter = SimpleAdapter(this,
                items, R.layout.grid_item, arrayOf("image", "text"),
                intArrayOf(R.id.image, R.id.text))
        main_page_gridview.numColumns = 3
        main_page_gridview.adapter = adapter
        main_page_gridview.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            Toast.makeText(this@MainActivity, "你選擇了" + imgText[position], Toast.LENGTH_SHORT).show()
        }
    }
}
