package oembed.project.oEmbed.service;


import oembed.project.oEmbed.handler.dataHandlerimpl;
import oembed.project.oEmbed.handler.jsonHadnlerimpl;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OembedServiceimpl implements OembedService {

    @Autowired
    dataHandlerimpl dataconfig;

    @Autowired
    jsonHadnlerimpl jsonhandler;

    public JSONObject urlConnector(String url) throws IOException {
        String youtube = "www.youtube.com";
        String instagram = "www.instagram.com";
        String twitter = "twitter.com";
        String vimeo = "vimeo.com";


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
        return  jsonhandler.youtubeJson(jsonData);
    }

    @Override
    public JSONObject instagramHandler(String url) throws IOException {
        System.out.println("urlHandler.instagramHandler");
        String result= null;
        String jsonData = getJsonObject(result);

        return null;
    }

    @Override
    public JSONObject twitterHandler(String url) throws IOException {
        System.out.println("urlHandler.twitterHandler");
        String  result = null;
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

        try {
            return jsonhandler.vimeoJson(jsonData);
        } catch(StringIndexOutOfBoundsException e){
            JSONObject jsonobj = new JSONObject();
            jsonobj.put("error","vimeo");
            jsonobj.put("msg","vimeo oembed 기능은 보안 오류 때문에 결과를 가져오는데 문제가 있을 수 있습니다.\n" +
                    "중복하여 누르면 결과가 나오니 다시 한번 눌러주세요.");
            return jsonobj;
        }
    }

    private String getJsonObject(String result) throws IOException {
        String data = dataconfig.getData(result);
        return data;
    }

}//end
