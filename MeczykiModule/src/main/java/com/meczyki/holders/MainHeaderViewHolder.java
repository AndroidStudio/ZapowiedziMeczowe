package com.meczyki.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.meczyki.R;
import com.meczyki.models.MainDataModel;

/**
 * Created by Przemysław Skitał on 2016-07-17.
 */
public class MainHeaderViewHolder extends RecyclerView.ViewHolder {
    private final Context context;
    private final TextView titleTextView;

    public MainHeaderViewHolder(View view, Context context) {
        super(view);
        this.context = context;
        this.titleTextView = (TextView) view.findViewById(R.id.titleTextView);
    }

    public void onBind(MainDataModel mainDataModel) {
        this.titleTextView.setText(mainDataModel.getTitle());
    }
}
