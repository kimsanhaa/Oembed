package oembed.project.oEmbed;




import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.MalformedJsonException;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.parser.ParserException;

import java.io.StringReader;
import java.text.ParseException;


@Component
public class temp {

    public JsonObject para(String data) throws MalformedJsonException {
        System.out.println("temp.para");
        System.out.println(data);
        data=data.replaceAll("/","");
        System.out.println(data);
        JsonParser jsonParser = new JsonParser();
        Object obj=null;
        obj = jsonParser.parse(data);

        JsonObject jsonobj = (JsonObject) obj;
        return jsonobj;
    }
}
