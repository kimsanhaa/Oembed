package oembed.project.oEmbed;



import com.google.gson.JsonObject;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Controller
public class OembedController {
    //수정 해야함 좋은 di로
    @Autowired
    urlHandler urlHandler;

    @Autowired
    dataConfig dataconfig;

    @Autowired
    jsonHadnler jsonhandler;


    @RequestMapping("/oembed")
    public String controller(){
        System.out.println("oemberdController 작동");
        return "thymeleaf/oembed";
    }

    @GetMapping("/search")
    @ResponseBody
    public JSONObject search(HttpServletRequest request, Model model) throws IOException {
        String url = request.getParameter("url");
        String result = urlHandler.urlConnector(url);
        String data = dataconfig.getData(result);
        JSONObject jsonData = jsonhandler.jsonHadnler(data);
        return jsonData;
    }



}
