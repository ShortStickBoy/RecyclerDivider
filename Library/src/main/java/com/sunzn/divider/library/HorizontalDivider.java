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
    private int mDividerHeight;
    private boolean mIncludeEdge = true;

    enum Sort {
        DP, PX
    }

    public HorizontalDivider(Context context) {
        super(context);
    }

    public HorizontalDivider(Context context, int res) {
        super(context, res);
    }

    public HorizontalDivider(Context context, int res, boolean includeEdge) {
        super(context, res);
        setIncludeEdge(includeEdge);
    }

    public HorizontalDivider(Context context, int res, int height, boolean includeEdge) {
        super(context, res);
        setHeight(Sort.DP, height);
        setIncludeEdge(includeEdge);
    }

    public HorizontalDivider(Context context, int res, Sort sort, int height, boolean includeEdge) {
        super(context, res);
        setHeight(sort, height);
    }

    public HorizontalDivider(Context context, int res, float marginStart, float marginEnd, boolean includeEdge) {
        super(context, res);
        setIncludeEdge(includeEdge);
        setMargin(marginStart, marginEnd);
    }

    private void setHeight(Sort sort, int height) {
        switch (sort) {
            case PX:
                mDividerHeight = height;
                break;
            case DP:
                mDividerHeight = dp2px(getContext(), height);
                break;
        }
    }

    public void setIncludeEdge(boolean includeEdge) {
        this.mIncludeEdge = includeEdge;
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

        final int childCount = parent.getChildCount() - (mIncludeEdge ? 0 : 1);
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom() + params.bottomMargin;
            final int bottom = top + (mDividerHeight <= 0 ? getDivider().getIntrinsicHeight() : mDividerHeight);
            getDivider().setBounds(left, top, right, bottom);
            getDivider().draw(c);
        }
    }

}
