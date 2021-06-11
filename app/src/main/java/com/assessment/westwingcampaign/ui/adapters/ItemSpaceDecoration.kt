package com.assessment.westwingcampaign.ui.adapters

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration

class ItemSpaceDecoration(private val space: Float, val verticalOrientation: Boolean = true) : ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.top = SizeUtils.dp2px(view.context, space)
        if (verticalOrientation) {
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.set(
                    0,
                    SizeUtils.dp2px(view.context, space),
                    0,
                    SizeUtils.dp2px(view.context, space)
                )
            } else {
                outRect.set(0, 0, 0, SizeUtils.dp2px(view.context, space))
            }
        } else {
            if (parent.getChildAdapterPosition(view) == 0) {
                outRect.set(SizeUtils.dp2px(view.context, space), 0, 0, 0)
            } else {
                outRect.set(
                    SizeUtils.dp2px(view.context, space),
                    0,
                    SizeUtils.dp2px(view.context, space),
                    0
                )
            }
        }
    }
}

object SizeUtils {
    fun dp2px(context: Context, dpValue: Float): Int {
        val scale: Float = context.resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }
}
