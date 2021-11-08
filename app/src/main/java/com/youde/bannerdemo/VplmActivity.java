package com.youde.bannerdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.leochuan.CarouselLayoutManager;
import com.leochuan.ScrollHelper;
import com.leochuan.ViewPagerLayoutManager;

public class VplmActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ViewPagerLayoutManager viewPagerLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vplm);

        recyclerView = findViewById(R.id.recycler);
        viewPagerLayoutManager = createLayoutManager();
        DataAdapter dataAdapter = new DataAdapter();
        dataAdapter.setOnItemClickListener(new DataAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Toast.makeText(v.getContext(), "clicked:" + pos, Toast.LENGTH_SHORT).show();
                ScrollHelper.smoothScrollToTargetView(recyclerView, v);
            }
        });
        recyclerView.setAdapter(dataAdapter);
        recyclerView.setLayoutManager(viewPagerLayoutManager);

        recyclerView.scrollToPosition(4);


    }

    private CarouselLayoutManager createLayoutManager() {
        return new CarouselLayoutManager(this, Util.Dp2px(this, 100));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }









}