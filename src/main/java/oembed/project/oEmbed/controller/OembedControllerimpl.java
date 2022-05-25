package oembed.project.oEmbed.controller;



import oembed.project.oEmbed.service.OembedServiceimpl;
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
public class OembedControllerimpl  implements  OemberController{

    @Autowired
    OembedServiceimpl oembedServiceimpl;

    @RequestMapping("/oembed")
    @Override
    public String controller(){
        return "thymeleaf/oembed";
    }


    @GetMapping("/search")
    @ResponseBody
    @Override
    public JSONObject search(HttpServletRequest request, Model model) throws IOException {
        String url = request.getParameter("url");
        return oembedServiceimpl.urlConnector(url);
    }
}
