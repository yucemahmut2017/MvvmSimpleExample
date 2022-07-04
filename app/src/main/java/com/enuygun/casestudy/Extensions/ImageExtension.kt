package com.enuygun.casestudy.Extensions

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.enuygun.casestudy.R


/**
 * getProgressDrawable returns placeholder for image loading for imageview of countries
 */

fun getProgressDrawable(context:Context): CircularProgressDrawable {

    return CircularProgressDrawable(context).apply {
        strokeWidth = 10f
        centerRadius = 50f
        start()
    }
}

/**
 *  loadImage extension function uses glide to load given image's uri and it places the downloaded image
 *  into given imageview
 */
fun ImageView.loadImage(uri:String?, progressDrawable: CircularProgressDrawable){

    val options = RequestOptions()
        .placeholder(progressDrawable)
        .error(R.mipmap.ic_launcher_round)
        Glide.with(this.context)
            .setDefaultRequestOptions(options)
            .load(uri)
            .into(this)
}



