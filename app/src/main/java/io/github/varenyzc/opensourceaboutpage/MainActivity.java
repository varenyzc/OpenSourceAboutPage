package io.github.varenyzc.opensourceaboutpage;

import android.content.Intent;
import android.graphics.Color;
import android.icu.text.UnicodeSetSpanner;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import io.github.varenyzc.opensourceaboutpages.AboutPageMessageItem;
import io.github.varenyzc.opensourceaboutpages.AboutPageMessageItemWithoutDescription;
import io.github.varenyzc.opensourceaboutpages.LogoCard;
import io.github.varenyzc.opensourceaboutpages.MessageCard;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AboutPageMessageItem item1 = new AboutPageMessageItem(this).
                setIcon(getDrawable(R.drawable.ic_launcher_round)).
                setDescriptionText("1.0").
                setMainText("版本号").
                setOnItemClickListener(new AboutPageMessageItem.AboutPageOnItemClick() {
                    @Override
                    public void onClick() {
                        Toast.makeText(MainActivity.this,"当前版本号为1.0",Toast.LENGTH_SHORT).show();
                    }
                });
        AboutPageMessageItem item2 = new AboutPageMessageItem(this).
                setIcon(getDrawable(R.drawable.ic_launcher_round)).
                setDescriptionText("开源代码").
                setMainText("Star来支持我").
                setOnItemClickListener(new AboutPageMessageItem.AboutPageOnItemClick() {
                    @Override
                    public void onClick() {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://github.com/varenyzc/OpenSourceAboutPage"));
                        startActivity(intent);
                    }
                });
        AboutPageMessageItemWithoutDescription item3 = new AboutPageMessageItemWithoutDescription(this).
                setIcon(getDrawable(R.drawable.ic_launcher_round)).
                setMessage("varenyzc").
                setOnItemClickListener(new AboutPageMessageItem.AboutPageOnItemClick() {
                    @Override
                    public void onClick() {
                        Intent intent = new Intent(Intent.ACTION_VIEW);
                        intent.setData(Uri.parse("https://varenyzc.github.io"));
                        startActivity(intent);
                    }
                });
        LogoCard logoCard = (LogoCard) findViewById(R.id.logo);
        logoCard.addMessageItem(item1,item2);
        MessageCard messageCard = (MessageCard) findViewById(R.id.message);
        messageCard.addMessageItem(item3);
    }
}
