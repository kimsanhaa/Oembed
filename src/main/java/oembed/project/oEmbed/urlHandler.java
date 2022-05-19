package oembed.project.oEmbed;


import org.springframework.stereotype.Component;

@Component
public class urlHandler implements oembedHandler {


    public String urlConnector(String url) {
        String youtube = "www.youtube.com";
        String instagram = "www.instagram.com";
        String twitter = "twitter.com";
        String vimeo = "vimeo.com";

        if(url.contains(youtube))return youtubeHandler(url);
        else if (url.contains(instagram))return instagramHandler(url);
        else if (url.contains(twitter))return twitterHandler(url);
        else if (url.contains(vimeo))return vimeoHandler(url);

        return "Controller가 없습니다.";
    }


    @Override
    public String youtubeHandler(String url) {
        System.out.println("urlHandler.youtubeHandler");
        String top="https://www.youtube.com/oembed?url=https%3A//youtube.com/watch%3Fv%3D";
        String mid = url.split("watch\\?v=")[1];
        String botm="&format=json";
        String result=top+mid+botm;
        return result;
    }
    @Override
    public String instagramHandler(String url) {
        System.out.println("urlHandler.instagramHandler");
        String top="https://www.youtube.com/oembed?url=https%3A//youtube.com/watch%3Fv%3D";
        String mid = url.split("watch\\?v=")[1];
        String botm="&format=json";
        String result=top+mid+botm;
        return result;
    }
    @Override
    public String twitterHandler(String url) {
        System.out.println("urlHandler.twitterHandler");
        String top="https://www.youtube.com/oembed?url=https%3A//youtube.com/watch%3Fv%3D";
        String mid = url.split("watch\\?v=")[1];
        String botm="&format=json";
        String result=top+mid+botm;
        return result;
    }
    @Override
    public String vimeoHandler(String url) {
        System.out.println("urlHandler.vimeoHandler");
        String top="https://www.youtube.com/oembed?url=https%3A//youtube.com/watch%3Fv%3D";
        String mid = url.split("watch\\?v=")[1];
        String botm="&format=json";
        String result=top+mid+botm;
        return result;
    }


}//end
