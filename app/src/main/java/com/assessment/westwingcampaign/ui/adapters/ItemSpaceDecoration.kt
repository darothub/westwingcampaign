package com.assessment.westwingcampaign.ui.adapters

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class ItemSpaceDecoration(private val space: Int, private val columns: Int) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildLayoutPosition(view)
        // set right margin to all
        outRect.right = space
        // set bottom space to all
        outRect.bottom = space
        // we only add top space to the first row
        if (position <columns) {
            outRect.top = space
        }
        // add left space only to the first column
        if (position % columns == 0) {
            outRect.left = space
        }
    }
}
