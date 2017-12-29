package com.sunzn.divider.library;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by sunzn on 2017/12/29.
 */

public abstract class Divider extends RecyclerView.ItemDecoration {

    private Context mContext;

    private Drawable mDivider;

    public Divider(Context context) {
        mContext = context;
    }

    public Context getContext() {
        return mContext;
    }

    public Drawable getDivider() {
        return mDivider;
    }

    public void setDivider(int resId) {
        mDivider = mContext.getResources().getDrawable(resId);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        onDrawDivider(c, parent);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        onGetItemOffsets(outRect);
    }


    public static int dp2px(Context context, float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public abstract void onGetItemOffsets(Rect outRect);

    public abstract void onDrawDivider(Canvas c, RecyclerView parent);

}
