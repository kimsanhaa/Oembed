package oembed.project.oEmbed;


import org.json.simple.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class jsonHadnler {


    public JSONObject jsonHadnler(String data){

        JSONObject jsonobj = new JSONObject();

        String [] key = new String[]{"title","author_name","author_url","type","height","width","version","provider_name","provider_url","thumbnail_height","thumbnail_width","thumbnail_url","html"};
        data=data.replace("{","");
        jsonobj.put("url","youtube");
        for(int i=0; i<key.length; i++){
            if(i== key.length-1){
                int start = data.indexOf(key[i]);
                int end= data.indexOf("}");
                String value = data.substring(start+key[i].length()+3, end-1);
                jsonobj.put(key[i], value);
            }
            else {

                int start = data.indexOf(key[i]);
                int end = data.indexOf(key[i + 1]);
                System.out.println(i + "번째");
                String value = data.substring(start+key[i].length()+2, end);
                value = value.replace(",","");
                value= value.replace("\"","");
                jsonobj.put(key[i], value);
            }

        }

        return jsonobj;



    }



}
