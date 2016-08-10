package com.meczyki.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.meczyki.R;
import com.network.library.MultipartRequestParams;
import com.network.library.NetworkManager;
import com.network.library.RequestCreator;
import com.network.library.RequestHeaders;
import com.network.library.RequestMethod;
import com.network.library.RequestParams;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class FootballPreviewsFragment extends Fragment {
    public static final String TAG = "PreviewsFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.football_previews_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        NetworkManager networkManager = new NetworkManager(getActivity(), true);
        networkManager.addRequest(new RequestCreator() {

            @Override
            public String onCreateUrl() {
                return "https://api.transmitsms.com/send-sms.json";
            }

            @Override
            public void onCreateRequestParams(RequestParams requestParams) {

            }

            @Override
            public void onCreateRequestHeaders(RequestHeaders requestHeaders) {

            }

            @Override
            public void onCreateMultipartRequestParams(MultipartRequestParams multipartRequestParams) {

            }

            @Override
            public int onCreateRetryCount() {
                return 3;
            }

            @Override
            public String onCreateRequestMethod() {
                return RequestMethod.GET;
            }

            @Override
            public Object onDownloadSuccess(InputStream inputStream) throws Exception {
                String response = getNetworkManager().convertInputStreamToString(inputStream);

                Log.e(TAG, response);
                return null;
            }

            @Override
            public void onResult(Object result) throws Exception {

            }
        });
        networkManager.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR);
    }
}
