package oembed.project.oEmbed.handler;

import java.io.IOException;

public interface dataHandler {
    public String getData(String url) throws IOException;
    public String convertString(String val);

}
