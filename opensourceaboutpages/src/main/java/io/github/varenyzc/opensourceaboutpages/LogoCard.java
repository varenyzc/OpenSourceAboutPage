package io.github.varenyzc.opensourceaboutpages;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LogoCard extends CardView {

    /*整体根布局view*/
    private View mView;
    private ImageView iv_logo;
    private TextView tv_appname,tv_copyright;
    private LinearLayout ll_item;
    private CardView cardView;


    private String appname,copyright;
    private Drawable logo;
    private int appname_color,copyright_color;
    public LogoCard(@NonNull Context context) {
        super(context);
        initView(context);
    }

    public LogoCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        getCustomStyle(context, attrs);
    }

    public LogoCard(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        getCustomStyle(context, attrs);
    }

    private void getCustomStyle(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LogoCard);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            if (attr == R.styleable.LogoCard_appName) {
                appname = a.getString(attr);
                tv_appname.setText(appname);
            } else if (attr == R.styleable.LogoCard_copyright) {
                copyright = a.getString(attr);
                tv_copyright.setText(copyright);
            } else if (attr == R.styleable.LogoCard_logoSrc) {
                logo = a.getDrawable(attr);
                if (null != logo) {
                    iv_logo.setImageDrawable(logo);
                }
            } else if (attr == R.styleable.LogoCard_appNameTextSize) {
               //默认20dp
                float textSize = a.getFloat(attr, 20);
                tv_appname.setTextSize(textSize);
            } else if (attr == R.styleable.LogoCard_copyrightTextSize) {
                float textSize = a.getFloat(attr, 14);
                tv_copyright.setTextSize(textSize);
            } else if (attr == R.styleable.LogoCard_appNameTextColor) {
                appname_color = a.getColor(attr, Color.BLACK);
                tv_appname.setTextColor(appname_color);
            } else if (attr == R.styleable.LogoCard_copyrightTextColor) {
                copyright_color = a.getColor(attr, Color.GRAY);
                tv_copyright.setTextColor(copyright_color);
            }
        }
        a.recycle();
    }

    private void initView(Context context) {
        mView = View.inflate(context, R.layout.logocard_layout, this);
        cardView = mView.findViewById(R.id.cardview);
        iv_logo = mView.findViewById(R.id.iv_logo);
        tv_appname = mView.findViewById(R.id.tv_appname);
        tv_copyright = mView.findViewById(R.id.tv_copyright);
        ll_item = mView.findViewById(R.id.list_item);
    }
    /**
     * 获取根布局对象
     *
     * @return
     */
    public CardView getCardView() {
        return cardView;
    }
    public ImageView getLogo() {
        return iv_logo;
    }

    public LogoCard setLogo(Drawable drawable) {
        this.iv_logo.setImageDrawable(drawable);
        return this;
    }

    public TextView getAppname() {
        return tv_appname;
    }

    public LogoCard setAppname(String text) {
        this.tv_appname.setText(text);
        return this;
    }

    public TextView getCopyright() {
        return tv_copyright;
    }

    public LogoCard setCopyright(String text) {
        this.tv_copyright.setText(text);
        return this;
    }

    public LogoCard setAppnameTextSize(float size) {
        this.tv_appname.setTextSize(size);
        return this;
    }

    public LogoCard setAppnameTextColor(int color) {
        this.tv_appname.setTextColor(color);
        return this;
    }

    public LogoCard setCopyrightTextSize(float size) {
        this.tv_copyright.setTextSize(size);
        return this;
    }

    public LogoCard setCopyrightTextColor(int color) {
        this.tv_copyright.setTextColor(color);
        return this;
    }

    public LogoCard addMessageItem(@NonNull AboutPageMessageItem... aboutPageMessageItems) {
        for (AboutPageMessageItem temp : aboutPageMessageItems) {
            ll_item.addView(temp);
        }
        return this;
    }
}
