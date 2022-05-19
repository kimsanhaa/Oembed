package oembed.project.oEmbed;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    dataHandler service;

    @RequestMapping("/oembed")
    public String controller(){
        System.out.println("oemberdController 작동");
        return "thymeleaf/oembed";
    }

    @GetMapping("/search")
    @ResponseBody
    public void search(HttpServletRequest request) throws IOException {
        String url = request.getParameter("url");
        //System.out.println("value?==="+value);
        String result = urlHandler.urlConnector(url);
        System.out.println(result);
        String data = service.getData(result);

    }



}
