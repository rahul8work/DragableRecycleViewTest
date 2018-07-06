package com.test

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import xyz.klinker.android.drag_dismiss.DragDismissIntentBuilder


class SampleAdapter(private val mContext: Context, val type: Int) : RecyclerView.Adapter<SampleAdapter.TextViewHolder>() {

    private val POST = 1
    private val COMMENT = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextViewHolder {
        val mInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = mInflater.inflate(R.layout.textview, parent, false)
        return TextViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 20;
    }

    override fun onBindViewHolder(holder: TextViewHolder, position: Int) {
        if (type == POST)
            holder.textView.text = "This is my " + position + " Post."
        else if (type == COMMENT)
            holder.textView.text = "This is " + position + " comment on Post."
    }


    inner class TextViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textView: TextView = itemView.findViewById(R.id.text_tv)

        init {
            textView.setOnClickListener {
                if (type == POST) {
                    val dragDismissActivity = Intent(mContext, PopupActivity::class.java)

                    DragDismissIntentBuilder(mContext)
                            .setTheme(DragDismissIntentBuilder.Theme.LIGHT)
                            .setPrimaryColorResource(R.color.colorPrimary)
                            .setShowToolbar(false)
                            .setShouldScrollToolbar(false)
                            .setDragElasticity(DragDismissIntentBuilder.DragElasticity.XXLARGE)
                            .setDrawUnderStatusBar(true)
                            .build(dragDismissActivity)

                    mContext.startActivity(dragDismissActivity)
                }
            }
        }
    }
}