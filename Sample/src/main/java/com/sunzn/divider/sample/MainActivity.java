package com.sunzn.divider.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sunzn.divider.library.HorizontalDivider;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mRecyclerView = findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new HorizontalDivider(this, R.drawable.shape_item_line, false));
//        mRecyclerView.addItemDecoration(new HorizontalDivider(this, R.drawable.shape_item_line, 10, 10, false));
        mRecyclerView.setAdapter(new RecyclerAdapter());
    }
}
