package com.example.android.android_me.ui

import activitystarter.ActivityStarter
import activitystarter.Arg
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.android_me.R
import com.example.android.android_me.data.AndroidImageAssets
import kotlinx.android.synthetic.main.fragment_body_part.*

class BodyPartFragment : Fragment() {

    @Arg var imageId: Int = 0
    @Arg var images: ArrayList<Int> = AndroidImageAssets.heads

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_body_part, container, false)
        ActivityStarter.fill(this, savedInstanceState);
        return view
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        ActivityStarter.save(this, outState)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        imageView.setImageResource(images[imageId])
        imageView.setOnClickListener {
            imageId = ++imageId % images.size
            imageView.setImageResource(images[imageId])
        }
    }
}
