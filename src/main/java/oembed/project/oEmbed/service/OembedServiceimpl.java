package oembed.project.oEmbed.service;


import oembed.project.oEmbed.handler.dataHandlerimpl;
import oembed.project.oEmbed.handler.jsonHadnlerimpl;
import oembed.project.oEmbed.jsonData.jsonData;
import org.json.JSONException;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class OembedServiceimpl implements OembedService {
    private static final Logger log = LoggerFactory.getLogger(OembedServiceimpl.class);

    private final dataHandlerimpl datahanlderimpl;
    private final jsonHadnlerimpl jsonhandler;
    private final jsonData jsondata;

    @Autowired
    public OembedServiceimpl(dataHandlerimpl datahanlderimpl, jsonHadnlerimpl jsonhandler, jsonData jsondata) {
        this.datahanlderimpl=datahanlderimpl;
        this.jsonhandler=jsonhandler;
        this.jsondata = jsondata;
    }


    public org.json.JSONObject urlConnector(String url) throws IOException {
        log.info("OembedServiceimpl.urlConnector");
        String youtube = "www.youtube.com";
        String instagram = "www.instagram.com";
        String twitter = "twitter.com";
        String vimeo = "vimeo.com";

//try {
//    if (url.contains(youtube)) return youtubeHandler(url);
//    else if (url.contains(instagram)) return instagramHandler(url);
//    else if (url.contains(twitter)) return twitterHandler(url);
//    else if (url.contains(vimeo)) return vimeoHandler(url);
//    else{ return getError();}
//}catch (NullPointerException | JSONException e){
//    log.info(String.valueOf(e));
//    getError();
//         return null;}
//    }
  try {
            if (url.contains(youtube)) return youtubeHandler(url);
        }catch (NullPointerException | JSONException e){
            log.info(String.valueOf(e));}
        return null;
    }

//    @Override
//    public JSONObject youtubeHandler(String url) throws IOException {
//        log.info("OembedServiceimpl.youtubeHandler");
//        String top="https://www.youtube.com/oembed?url=https%3A//youtube.com/watch%3Fv%3D";
//        String mid = url.split("watch\\?v=")[1];
//        String botm="&format=json";
//        String result=top+mid+botm;
//        System.out.println(result);
//        String jsonData = getJsonObject(result);
//        return  jsonhandler.youtubeJson(jsonData);
//    }
@Override
public org.json.JSONObject youtubeHandler(String url) throws IOException, JSONException {
    log.info("OembedServiceimpl.youtubeHandler");
    String top="https://www.youtube.com/oembed?url=https%3A//youtube.com/watch%3Fv%3D";
    String mid = url.split("watch\\?v=")[1];
    String botm="&format=json";
    String result=top+mid+botm;
    System.out.println(result);
    String jsonData = getJsonObject(result);
    return jsondata.json(jsonData);
//    return  jsonhandler.youtubeJson(jsonData);
}

    @Override
    public JSONObject instagramHandler(String url) throws IOException {
        String result= null;
        String jsonData = getJsonObject(result);

        return null;
    }

    @Override
    public JSONObject twitterHandler(String url) throws IOException {
        String  result = null;
        String jsonData = getJsonObject(result);
        return null;
    }

    @Override
    public JSONObject vimeoHandler(String url) throws IOException {
        log.info("OembedServiceimpl.vimeoHandler");
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
            jsonobj.put("error","error");
            jsonobj.put("msg","vimeo oembed 기능은 보안 오류 때문에 결과를 가져오는데 문제가 있을 수 있습니다.\n" +
                    "중복하여 누르면 결과가 나오니 다시 한번 눌러주세요.");
            log.info("StringIndexOutOfBoundsException");
            return jsonobj;
        }
    }
    private String getJsonObject(String result) throws IOException {
        String data = datahanlderimpl.getData(result);
        return data;
    }

    private JSONObject getError() {
        JSONObject jsonobj = new JSONObject();
        jsonobj.put("error","error");
        jsonobj.put("msg","죄송합니다. 아직 준비가 안된 서비스 url 입니다. 현재는 유튜브와 vimeo만 가능합니다. 빠른 시일 내에 반영 할 수 있도록 하겠습니다.");
        return jsonobj;
    }

}//end
