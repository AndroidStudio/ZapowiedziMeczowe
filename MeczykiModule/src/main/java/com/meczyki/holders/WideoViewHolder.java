package com.meczyki.holders;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.meczyki.R;
import com.meczyki.activities.DetailsActivity;
import com.meczyki.models.MainDataModel;
import com.meczyki.utils.Constants;

/**
 * Created by Przemysław Skitał on 2016-07-17.
 */
public class WideoViewHolder extends RecyclerView.ViewHolder {
    private final View view;
    private final Context context;
    private final TextView titleTextView;
    private final TextView descriptionTextView;
    private final TextView dateTextView;
    private final ImageView imageView;

    public WideoViewHolder(View view, Context context) {
        super(view);
        this.view = view;
        this.context = context;

        this.titleTextView = (TextView) view.findViewById(R.id.titleTextView);
        this.descriptionTextView = (TextView) view.findViewById(R.id.descriptionTextView);
        this.dateTextView = (TextView) view.findViewById(R.id.dateTextView);

        this.imageView = (ImageView) view.findViewById(R.id.imageView);

    }

    public void onBind(final MainDataModel mainDataModel) {
        this.titleTextView.setText(mainDataModel.getTitle());
        this.descriptionTextView.setText(mainDataModel.getDescription());
        this.dateTextView.setText(mainDataModel.getDate());

        Glide.with(context).load(mainDataModel.getPhotoUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).into(this.imageView);

        this.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra(Constants.MAIN_DATA_MODEL, mainDataModel);
                ActivityOptions activityOptions = ActivityOptions.makeSceneTransitionAnimation((Activity) context, imageView, "image");
                context.startActivity(intent, activityOptions.toBundle());
            }
        });
    }
}
