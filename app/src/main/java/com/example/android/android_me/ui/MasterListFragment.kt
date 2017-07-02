package com.example.android.android_me.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import com.example.android.android_me.R
import com.example.android.android_me.data.AndroidImageAssets
import kotlinx.android.synthetic.main.fragment_master_list.*


class MasterListFragment : Fragment() {

    var onImageClicked: (position: Int)->Unit = {}
    var onNextClicked: ()->Unit = {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_master_list, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val masterListAdapter = MasterListAdapter(context, AndroidImageAssets.all)
        gridView.adapter = masterListAdapter
        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, l -> onImageClicked(position) }
        nextButton.setOnClickListener { onNextClicked() }
    }
}
