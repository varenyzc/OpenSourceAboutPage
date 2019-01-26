package io.github.varenyzc.opensourceaboutpages;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MessageCard extends CardView {
    private View mView;
    private TextView tv_title;
    private LinearLayout linearLayout;

    private String title;
    private float titleTextSize;
    private int titleTextColor;
    public MessageCard(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public MessageCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        getCustomStyle(context, attrs);
    }

    public MessageCard(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        getCustomStyle(context, attrs);
    }

    private void initView(Context context) {
        mView = View.inflate(context, R.layout.messagecard_layout, this);
        tv_title = mView.findViewById(R.id.tv_title);
        linearLayout = mView.findViewById(R.id.list_item);
    }
    private void getCustomStyle(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MessageCard);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.MessageCard_title) {
                title = a.getString(attr);
                tv_title.setText(title);
            } else if (attr == R.styleable.MessageCard_titleTextSize) {
                titleTextSize = a.getFloat(attr, 15);
                tv_title.setTextSize(titleTextSize);
            } else if (attr == R.styleable.MessageCard_titleTextColor) {
                titleTextColor = a.getColor(attr,Color.BLACK);
                tv_title.setTextColor(titleTextColor);
            }
        }
        //a.recycle();
    }

    public LinearLayout getLinearLayout() {
        return linearLayout;
    }

    public void setLinearLayout(LinearLayout linearLayout) {
        this.linearLayout = linearLayout;
    }

    public String getTitle() {
        return title;
    }

    public MessageCard setTitle(String title) {
        this.tv_title.setText(title);
        return this;
    }

    public float getTitleTextSize() {
        return titleTextSize;
    }

    public MessageCard setTitleTextSize(float titleTextSize) {
        this.tv_title.setTextSize(titleTextSize);
        return this;
    }

    public int getTitleTextColor() {
        return titleTextColor;
    }

    public MessageCard setTitleTextColor(int titleTextColor) {
        this.tv_title.setTextColor(titleTextColor);
        return this;
    }

    public MessageCard addMessageItem(AboutPageMessageItem... items) {
        for (AboutPageMessageItem temp : items) {
            linearLayout.addView(temp);
        }
        return this;
    }
}
