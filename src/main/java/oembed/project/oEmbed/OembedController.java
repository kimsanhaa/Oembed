package oembed.project.oEmbed;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class OembedController {

    @RequestMapping("/oembed")
    public String controller(){
        System.out.println("hi");
        return "thymeleaf/oembed";
    }

    @RequestMapping("/search")
    public void search(HttpServletRequest request){
        String value = request.getParameter("value");
        System.out.println(value);
    }
}
