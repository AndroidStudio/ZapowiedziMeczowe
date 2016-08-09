package com.meczyki.tasks;

import android.os.AsyncTask;

import com.meczyki.models.MainDataModel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

/**
 * Created by Przemysław Skitał on 2016-07-17.
 */
public class MainHtmlParseTask extends AsyncTask<String, String, ArrayList<MainDataModel>> {
    private final int boxIndex;

    public MainHtmlParseTask(int boxIndex) {
        this.boxIndex = boxIndex;
    }

    @Override
    protected ArrayList<MainDataModel> doInBackground(String... strings) {
        ArrayList<MainDataModel> mainDataModelArrayList = new ArrayList<>();
        try {
            Thread.sleep(500);

            Document document = Jsoup.connect("http://www.meczyki.pl").get();
            Elements contents = document.getElementsByClass("box-list-items");
            Element element = contents.get(boxIndex);

            Elements links = element.getElementsByTag("a");
            int size = links.size();
            if (size > 8) {
                for (int i = 0; i < 8; i++) {
                    MainDataModel mainDataModel = new MainDataModel();
                    mainDataModel.setViewType(MainDataModel.HEADER_VIEW_TYPE);
                    mainDataModel.setTitle(links.get(i).text());
                    mainDataModel.setUrl(links.get(i).attr("abs:href"));
                    mainDataModelArrayList.add(mainDataModel);
                }
            } else {
                for (Element link : links) {
                    MainDataModel mainDataModel = new MainDataModel();
                    mainDataModel.setViewType(MainDataModel.HEADER_VIEW_TYPE);
                    mainDataModel.setTitle(link.text());
                    mainDataModel.setUrl(link.attr("abs:href"));
                    mainDataModelArrayList.add(mainDataModel);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mainDataModelArrayList;
    }
}
