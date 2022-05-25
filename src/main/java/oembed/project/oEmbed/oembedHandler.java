package oembed.project.oEmbed;

import org.json.simple.JSONObject;

import java.io.IOException;

public interface oembedHandler {
     JSONObject youtubeHandler(String url) throws IOException;
     JSONObject instagramHandler(String url) throws IOException;
     JSONObject twitterHandler(String url) throws IOException;
     JSONObject vimeoHandler(String url) throws IOException;
}
