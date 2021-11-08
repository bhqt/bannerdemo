package com.youde.bannerdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.stx.xhb.xbanner.XBanner;
import com.youde.bannerdemo.entity.CustomViewsInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    private void initView() {
        XBanner banner = (XBanner) findViewById(R.id.banner);
        List<CustomViewsInfo> data = new ArrayList<>();
        data.add(new CustomViewsInfo("#FFA54F"));
        data.add(new CustomViewsInfo("#8EE5EE"));
        data.add(new CustomViewsInfo("#00FA9A"));
        data.add(new CustomViewsInfo("#CD8162"));
        banner.setBannerData(R.layout.layout_custom_view, data);
        banner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                TextView tvContent = (TextView) view.findViewById(R.id.tv);
                tvContent.setText(String.valueOf(position + 1));
                view.setBackgroundColor(Color.parseColor(((CustomViewsInfo) model).getXBannerUrl()));

                Button btnCmd = (Button) view.findViewById(R.id.btncmd);
                btnCmd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "你想提示的信息",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        banner.setOnItemClickListener(new XBanner.OnItemClickListener() {
            @Override
            public void onItemClick(XBanner banner, Object model, View view, int position) {
                Toast.makeText(MainActivity.this, "点击了" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }






}