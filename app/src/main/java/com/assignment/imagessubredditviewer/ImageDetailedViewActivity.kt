package com.assignment.imagessubredditviewer

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.assignment.imagessubredditviewer.commons.Constants

class ImageDetailedViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_detailed_view)

        val ivDetailedImage: ImageView = findViewById(R.id.ivImageDetailed)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = ""

        val bitmapReceivedAsArray = intent.getByteArrayExtra(Constants.BITMAP_PASSED_INTENT_KEY)

        if (bitmapReceivedAsArray != null) {
            val bitmap =
                BitmapFactory.decodeByteArray(bitmapReceivedAsArray, 0, bitmapReceivedAsArray.size)
            ivDetailedImage.setImageBitmap(bitmap)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}