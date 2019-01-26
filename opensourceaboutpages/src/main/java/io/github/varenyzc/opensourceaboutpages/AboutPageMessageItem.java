package io.github.varenyzc.opensourceaboutpages;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class AboutPageMessageItem extends LinearLayout {

    private View mView;
    private LinearLayout linearLayout;
    private ImageView icon;
    private TextView MainText,DescriptionText;
    private AboutPageOnItemClick aboutPageOnItemClick;


    public AboutPageMessageItem(Context context) {
        super(context);
        initView(context);
    }

    public AboutPageMessageItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
        //getCustomStyle(context, attrs);
    }

    public AboutPageMessageItem(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
        //getCustomStyle(context, attrs);
    }

    private void getCustomStyle(Context context, AttributeSet attrs) {

    }

    public void initView(Context context) {
        mView = View.inflate(context, R.layout.message_item, this);
        linearLayout = mView.findViewById(R.id.Layout);
        icon = mView.findViewById(R.id.icon);
        MainText = mView.findViewById(R.id.tv_maintext);
        DescriptionText = mView.findViewById(R.id.tv_description);
        linearLayout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (aboutPageOnItemClick != null) {
                    aboutPageOnItemClick.onClick();
                }
            }
        });
    }
    public LinearLayout getLinearLayout() {
        return linearLayout;
    }


    public ImageView getIcon() {
        return icon;
    }

    public AboutPageMessageItem setIcon(Drawable drawable) {
        this.icon.setImageDrawable(drawable);
        return this;
    }

    public TextView getMainText() {
        return MainText;
    }

    public AboutPageMessageItem setMainText(String text) {
        MainText.setText(text);
        return this;
    }

    public TextView getDescriptionText() {
        return DescriptionText;
    }

    public AboutPageMessageItem setDescriptionText(String text) {
        DescriptionText.setText(text);
        return this;
    }

    public AboutPageMessageItem setOnItemClickListener(AboutPageOnItemClick aboutPageOnItemClick) {
        this.aboutPageOnItemClick = aboutPageOnItemClick;
        return this;
    }

    public AboutPageMessageItem setMainTextSize(float size) {
        this.MainText.setTextSize(size);
        return this;
    }

    public AboutPageMessageItem setMainTextColor(int color) {
        this.MainText.setTextColor(color);
        return this;
    }

    public AboutPageMessageItem setDescriptionTextSize(float size) {
        this.DescriptionText.setTextSize(size);
        return this;
    }

    public AboutPageMessageItem setDescriptionTextColor(int color) {
        this.DescriptionText.setTextColor(color);
        return this;
    }

    public interface AboutPageOnItemClick {
        void onClick();
    }
}
