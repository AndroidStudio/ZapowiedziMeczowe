package com.meczyki.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.meczyki.R;
import com.meczyki.adapters.MainRecyclerViewAdapter;
import com.meczyki.models.MainDataModel;
import com.meczyki.tasks.MainHtmlParseTask;
import com.meczyki.utils.Constants;

import java.util.ArrayList;

/**
 * Created by Przemysław Skitał on 2016-07-17.
 */
public class MainFragment extends BaseFragment {
    private MainRecyclerViewAdapter mainRecyclerViewAdapter;
    private MainHtmlParseTask mainHtmlParseTask;
    private int boxIndex;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        this.boxIndex = bundle.getInt(Constants.BOX_INDEX);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);

        this.mainRecyclerViewAdapter = new MainRecyclerViewAdapter(getActivity());
        recyclerView.setAdapter(this.mainRecyclerViewAdapter);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onDownloadMatchPreviews();
    }

    private void onDownloadMatchPreviews() {
        onResetHtmlPrseTask();
        this.mainHtmlParseTask = new MainHtmlParseTask(this.boxIndex) {

            @Override
            protected void onPreExecute() {
                ProgressBar progressBar = (ProgressBar) getView().findViewById(R.id.progressBar);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            protected void onPostExecute(ArrayList<MainDataModel> list) {
                ProgressBar progressBar = (ProgressBar) getView().findViewById(R.id.progressBar);
                progressBar.setVisibility(View.GONE);
                mainRecyclerViewAdapter.setMainDataModelList(list);
            }
        };
        this.mainHtmlParseTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }

    private void onResetHtmlPrseTask() {
        if (this.mainHtmlParseTask != null && this.mainHtmlParseTask.getStatus() != AsyncTask.Status.FINISHED) {
            this.mainHtmlParseTask.cancel(true);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        onResetHtmlPrseTask();
    }
}
