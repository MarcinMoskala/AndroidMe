/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.android_me.ui

import activitystarter.ActivityStarter
import activitystarter.Arg
import activitystarter.Optional
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.example.android.android_me.R
import com.example.android.android_me.data.AndroidImageAssets

class AndroidMeActivity : BaseActivity() {

    @Optional @Arg var headId: Int = 0
    @Optional @Arg var bodyId: Int = 0
    @Optional @Arg var legsId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_me)
        // Hack suggested by tutorial to check if it is first-time initialization
        if(savedInstanceState != null) return
        fillBodyParts(R.id.headContainer, headId, AndroidImageAssets.heads)
        fillBodyParts(R.id.bodyContainer, bodyId, AndroidImageAssets.bodies)
        fillBodyParts(R.id.legsContainer, legsId, AndroidImageAssets.legs)
    }

    private fun fillBodyParts(containerId: Int, id: Int, images: ArrayList<Int>) {
        supportFragmentManager.beginTransaction()
                .add(containerId, BodyPartFragmentStarter.newInstance(id, images))
                .commit()
    }
}
