package oembed.project.oEmbed.controller;

import org.json.simple.JSONObject;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public interface OemberController {
    public String controller();
    public JSONObject search(HttpServletRequest request, Model model) throws IOException;
}
