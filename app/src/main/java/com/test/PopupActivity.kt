package com.test

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import xyz.klinker.android.drag_dismiss.activity.DragDismissRecyclerViewActivity


class PopupActivity : DragDismissRecyclerViewActivity() {

    override fun setupRecyclerView(recyclerView: RecyclerView) {
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = SampleAdapter(this, 2)
    }
}
