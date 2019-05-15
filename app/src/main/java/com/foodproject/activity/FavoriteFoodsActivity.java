package com.foodproject.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.foodproject.R;
import com.foodproject.adapter.PlaceAdapter;
import com.foodproject.adapter.ProductAdapter;
import com.foodproject.model.Products;

public class FavoriteFoodsActivity extends AppCompatActivity implements
        ProductAdapter.OnProductClickListener{

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_foods);

        initialize();
        setupWidgets();
    }

    private void initialize() {
        mRecyclerView = findViewById(R.id.recycler_view);
    }

    private void setupWidgets() {
        //change status bar color to transparent
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.headerColor));
        }

        //setup product recycler view
        GridLayoutManager llmProduct = new GridLayoutManager(this, 2);
        LinearLayoutManager llmPlace = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(llmProduct);
        ProductAdapter mProductAdapter = new ProductAdapter(this);
        mRecyclerView.setAdapter(mProductAdapter);
    }

    @Override
    public void OnProductNoFavoriteClick(Products products) {
        Toast.makeText(this, "no favorite", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnProductFavoriteClick(Products products) {
        Toast.makeText(this, "favorite", Toast.LENGTH_SHORT).show();
    }
}