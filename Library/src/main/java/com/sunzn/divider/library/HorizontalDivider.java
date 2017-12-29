package com.sunzn.divider.library;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by sunzn on 2017/12/29.
 */

public class HorizontalDivider extends Divider {

    private int mMarginStart;
    private int mMarginEnd;

    public HorizontalDivider(Context context) {
        super(context);
    }

    public HorizontalDivider(Context context, int res) {
        super(context, res);
    }

    public void setMargin(float marginStart, float marginEnd) {
        mMarginStart = dp2px(getContext(), marginStart);
        mMarginEnd = dp2px(getContext(), marginEnd);
    }

    @Override
    public void onGetItemOffsets(Rect outRect) {
        outRect.set(0, 0, 0, getDivider().getIntrinsicHeight());
    }

    @Override
    public void onDrawDivider(Canvas c, RecyclerView parent) {
        final int left = mMarginStart;
        final int right = parent.getWidth() - mMarginEnd;

        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            android.support.v7.widget.RecyclerView v = new android.support.v7.widget.RecyclerView(parent.getContext());
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + getDivider().getIntrinsicHeight();
            getDivider().setBounds(left, top, right, bottom);
            getDivider().draw(c);
        }
    }

}
