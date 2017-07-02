package com.example.android.android_me.ui

import activitystarter.ActivityStarter
import activitystarter.Arg
import activitystarter.Optional
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle

import com.example.android.android_me.R
import com.example.android.android_me.data.AndroidImageAssets
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    @Optional @Arg var headId: Int = 0
    @Optional @Arg var bodyId: Int = 0
    @Optional @Arg var legsId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = MasterListFragment()
        supportFragmentManager.beginTransaction()
                .add(R.id.masterListFragment, fragment)
                .commit()

        fragment.onImageClicked = { position ->
            // This looks really bed, but this is how tutorial suggested to do it
            val bodyPart = position / 12
            val id = position - bodyPart * 12
            when (bodyPart) {
                0 -> headId = id
                1 -> bodyId = id
                2 -> legsId = id
            }
            if (isTablet()) showBodyParts()
        }

        fragment.onNextClicked = {
            AndroidMeActivityStarter.start(this, headId, bodyId, legsId)
        }
    }

    fun showBodyParts() {
        fillBodyParts(R.id.headContainer, headId, AndroidImageAssets.heads)
        fillBodyParts(R.id.bodyContainer, bodyId, AndroidImageAssets.bodies)
        fillBodyParts(R.id.legsContainer, legsId, AndroidImageAssets.legs)
    }

    private fun fillBodyParts(containerId: Int, id: Int, images: ArrayList<Int>) {
        supportFragmentManager.beginTransaction()
                .add(containerId, BodyPartFragmentStarter.newInstance(id, images))
                .commit()
    }

    private fun isTablet() = findViewById(R.id.androidMeLinearLayout) != null
}
