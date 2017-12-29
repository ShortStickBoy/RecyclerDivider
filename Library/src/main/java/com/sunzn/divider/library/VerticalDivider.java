package com.sunzn.divider.library;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by sunzn on 2017/12/29.
 */

public class VerticalDivider extends Divider {

    private int mMarginTop;
    private int mMarginBottom;

    public VerticalDivider(Context context) {
        super(context);
    }

    public VerticalDivider(Context context, int res) {
        super(context, res);
    }

    public void setMargin(float marginTop, float marginBottom) {
        mMarginTop = dp2px(getContext(), marginTop);
        mMarginBottom = dp2px(getContext(), marginBottom);
    }

    @Override
    public void onGetItemOffsets(Rect outRect) {
        outRect.set(0, 0, getDivider().getIntrinsicWidth(), 0);
    }

    @Override
    public void onDrawDivider(Canvas c, RecyclerView parent) {
        final int top = mMarginTop;
        final int bottom = parent.getHeight() - mMarginBottom;

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + getDivider().getIntrinsicHeight();
            getDivider().setBounds(left, top, right, bottom);
            getDivider().draw(c);
        }
    }

}
