package com.meczyki.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.meczyki.R;
import com.meczyki.holders.MainHeaderViewHolder;
import com.meczyki.holders.WideoViewHolder;
import com.meczyki.holders.SeparatorViewHolder;
import com.meczyki.models.MainDataModel;

import java.util.ArrayList;

/**
 * Created by Przemysław Skitał on 2016-07-17.
 */
public class MainRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final ArrayList<MainDataModel> mainDataModelList = new ArrayList<>();
    private final LayoutInflater layoutInflater;
    private final Context context;

    public MainRecyclerViewAdapter(Context context) {
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case MainDataModel.HEADER_VIEW_TYPE:
                return new MainHeaderViewHolder(
                        this.layoutInflater.inflate(R.layout.main_hedear_item, parent, false),
                        this.context);
            case MainDataModel.VIDEO_VIEW_TYPE:
                return new WideoViewHolder(
                        this.layoutInflater.inflate(R.layout.news_item, parent, false),
                        this.context);
            case MainDataModel.SEPARATOR_VIEW_TYPE:
                return new SeparatorViewHolder(
                        this.layoutInflater.inflate(R.layout.separator_item, parent, false),
                        this.context);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MainDataModel mainDataModel = this.mainDataModelList.get(position);
        switch (getItemViewType(position)) {
            case MainDataModel.HEADER_VIEW_TYPE:
                MainHeaderViewHolder headerViewHolder = (MainHeaderViewHolder) holder;
                headerViewHolder.onBind(mainDataModel);
                break;
            case MainDataModel.VIDEO_VIEW_TYPE:
                WideoViewHolder wideoViewHolder = (WideoViewHolder) holder;
                wideoViewHolder.onBind(mainDataModel);
                break;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return this.mainDataModelList.get(position).getViewType();
    }

    public void setMainDataModelList(ArrayList<MainDataModel> mainDataModelList) {
        this.mainDataModelList.addAll(mainDataModelList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return this.mainDataModelList.size();
    }
}
