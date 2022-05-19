package oembed.project.oEmbed;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class urlHandler implements Handler {
    @Override
    //https://www.youtube.com/watch?v=dBD54EZIrZo
    public String youtubeHandler(String url) {
        String[] split = url.split("watch?v=");
        String result="";
        String top="https://www.youtube.com/oembed?url=https%3A//youtube.com/watch%3Fv%3D ";
        String mid="";
        String botm="&format=json";
        return "youtube!";
    }
    public static void main(String[] args) {
        urlHandler temp = new urlHandler();
        String url = "https://www.youtube.com/watch?v=dBD54EZIrZo";
        temp.youtubeHandler(url);
    }
}//end
