package com.meczyki.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.meczyki.R;
import com.meczyki.models.MainDataModel;
import com.meczyki.utils.Constants;

/**
 * Created by Przemysław Skitał on 2016-07-17.
 */
public class DetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_news_details);
        this.onCreateToolbar();
        MainDataModel mainDataModel = (MainDataModel) getIntent().getSerializableExtra(Constants.MAIN_DATA_MODEL);
        String photoUrl = mainDataModel.getPhotoUrl();

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setTransitionName("image");
        Glide.with(this).load(photoUrl).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
    }

    private void onCreateToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.m_logo);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
