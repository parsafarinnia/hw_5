package ir.aut.ceit.app;

import org.json.JSONArray;
import org.json.JSONObject;
/**
 * Created by parsa on 4/14/17.
 */
public class ForcastWeather extends BaseWeather {
    public static String [] forcast(String jsonin){
        JSONObject json = new JSONObject(jsonin);
        String [] forcast = new String[2];
        JSONObject jsonObjectCity= json.getJSONObject("city");
        forcast[0]=jsonObjectCity.getString("name");
        JSONObject jsonObjectCoord= jsonObjectCity.getJSONObject("coord");
        forcast[1]="lat:"+jsonObjectCoord.getDouble("lat")+"\t lon:"+jsonObjectCoord.getDouble("lon");
        return forcast;
    }

}
