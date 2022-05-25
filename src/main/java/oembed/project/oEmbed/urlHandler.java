package oembed.project.oEmbed;


import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class urlHandler implements oembedHandler {

    @Autowired
    dataConfig dataconfig;

    @Autowired
    jsonHadnler jsonhandler;

    @Autowired
    jsonHadnler jsonhander;



    public JSONObject urlConnector(String url) throws IOException {
        String youtube = "www.youtube.com";
        String instagram = "www.instagram.com";
        String twitter = "twitter.com";
        String vimeo = "vimeo.com";
        //nullpointer exception -> controller가 없습니다. 해야함


        if(url.contains(youtube))return youtubeHandler(url);
        else if (url.contains(instagram))return instagramHandler(url);
        else if (url.contains(twitter))return twitterHandler(url);
        else if (url.contains(vimeo))return vimeoHandler(url);
        return null;
    }

    @Override
    public JSONObject youtubeHandler(String url) throws IOException {
        System.out.println("urlHandler.youtubeHandler");
        String top="https://www.youtube.com/oembed?url=https%3A//youtube.com/watch%3Fv%3D";
        String mid = url.split("watch\\?v=")[1];
        String botm="&format=json";
        String result=top+mid+botm;

        String jsonData = getJsonObject(result);
        return  jsonhander.youtubeJson(jsonData);
    }

    @Override
    public JSONObject instagramHandler(String url) throws IOException {
        System.out.println("urlHandler.instagramHandler");
        String top="https://www.youtube.com/oembed?url=https%3A//youtube.com/watch%3Fv%3D";
        String mid = url.split("watch\\?v=")[1];
        String botm="&format=json";
        String result=top+mid+botm;
        String jsonData = getJsonObject(result);

        return null;
    }

    @Override
    public JSONObject twitterHandler(String url) throws IOException {
        System.out.println("urlHandler.twitterHandler");
        String top="https://www.youtube.com/oembed?url=https%3A//youtube.com/watch%3Fv%3D";
        String mid = url.split("watch\\?v=")[1];
        String botm="&format=json";
        String result=top+mid+botm;

        String jsonData = getJsonObject(result);
        return null;
    }
    @Override
    public JSONObject vimeoHandler(String url) throws IOException {
        System.out.println("urlHandler.vimeoHandler");
        //https://vimeo.com/api/oembed.json?url=https://vimeo.com/20097015
        String top="https://vimeo.com/api/oembed.json?url=";
        String mid = url;
        String result=top+mid;
        System.out.println(result);

        String jsonData = getJsonObject(result);

        return jsonhandler.vimeoJson(jsonData);
    }

    private String getJsonObject(String result) throws IOException {
        String data = dataconfig.getData(result);
        return data;
    }

}//end
