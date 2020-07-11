package com.assignment.imageloader

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Divya Gupta.
 */
class ImagesListAdapter(
    val context: Context,
    private var imagesUrls: MutableList<SubRedditJsonResponse.DataBeanX.ChildrenBean>
) : RecyclerView.Adapter<ImagesListAdapter.ImagesViewHolder>() {

    private lateinit var imageDownloadTask: ImageDownloadTask


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImagesViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.rec_view_list_item, parent, false)
        return ImagesViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imagesUrls.size
    }

    override fun onBindViewHolder(holder: ImagesViewHolder, position: Int) {
        val imagesData = imagesUrls[position].data
        val bmp = holder.cache.getImageFromWarehouse(imagesData?.url)
        if (bmp != null) {
            holder.ivImage.setImageBitmap(bmp)
        } else {
            holder.ivImage.setImageBitmap(null)
            imageDownloadTask = ImageDownloadTask(this, 300, 300)
            imageDownloadTask.execute(imagesData?.url)
        }
    }

    fun setValues(imagesUrls: MutableList<SubRedditJsonResponse.DataBeanX.ChildrenBean>) {
        this.imagesUrls = imagesUrls
    }

    class ImagesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivImage: ImageView = itemView.findViewById(R.id.iv_image_from_reddit)

        val cache = ImagesCache.getInstance()

        init {
            cache.initializeCache()
        }
    }
}