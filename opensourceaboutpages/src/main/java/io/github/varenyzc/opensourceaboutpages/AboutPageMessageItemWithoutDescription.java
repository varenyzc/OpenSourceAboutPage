package io.github.varenyzc.opensourceaboutpages;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AboutPageMessageItemWithoutDescription extends AboutPageMessageItem {

    private View mView;
    private LinearLayout linearLayout;
    private ImageView icon;
    private TextView MainText;

    private AboutPageOnItemClick aboutPageOnItemClick;

    public AboutPageMessageItemWithoutDescription(Context context) {
        super(context);
    }

    public AboutPageMessageItemWithoutDescription(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AboutPageMessageItemWithoutDescription(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void initView(Context context) {
        mView = View.inflate(context, R.layout.message_item_without_desciption, this);
        linearLayout = mView.findViewById(R.id.Layout);
        icon = mView.findViewById(R.id.icon);
        MainText = mView.findViewById(R.id.tv_maintext);
        linearLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aboutPageOnItemClick != null) {
                    aboutPageOnItemClick.onClick();
                }
            }
        });
    }

    public AboutPageMessageItemWithoutDescription setMessage(String text) {
        this.MainText.setText(text);
        return this;
    }

    public AboutPageMessageItemWithoutDescription setIcon(Drawable drawable) {
        this.icon.setImageDrawable(drawable);
        return this;
    }

    public AboutPageMessageItemWithoutDescription setMessageTextSize(float size) {
        this.MainText.setTextSize(size);
        return this;
    }

    public AboutPageMessageItemWithoutDescription setMessageTextColor(int color) {
        this.MainText.setTextColor(color);
        return this;
    }
    public AboutPageMessageItemWithoutDescription setOnItemClickListener(AboutPageOnItemClick aboutPageOnItemClick) {
        this.aboutPageOnItemClick = aboutPageOnItemClick;
        return this;
    }
}
