package oembed.project.oEmbed;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OembedController {

    //수정 해야함 좋은 di로
    @Autowired
    urlHandler urlHandler;

    @RequestMapping("/oembed")
    public String controller(){
        System.out.println("oemberdController 작동");
        return "thymeleaf/oembed";
    }

    @RequestMapping("/search")
    public void search(HttpServletRequest request){
        String value = request.getParameter("value");
        //System.out.println("value?==="+value);
        String temp = urlHandler.youtubeHandler(value);
        System.out.println(temp);
    }



}