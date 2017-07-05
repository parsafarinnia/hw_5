package ir.aut.ceit.app;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by parsa on 4/14/17.
 */
public class CurrentWeather extends BaseWeather {
    /**
     * this method is for getting the city name and city coordinates
     */
    public static String [] currentweather(String json){
        JSONObject jsonObject = new JSONObject(json);
        //"coord"fbdd
        String coord=null;
        JSONObject jsonObjectCoord = jsonObject.getJSONObject("coord");
        Double resultLon = jsonObjectCoord.getDouble("lon");
        Double resultLat = jsonObjectCoord.getDouble("lat");
       coord ="lon: " + resultLon + "\tlat: " + resultLat ;
        String resultName = jsonObject.getString("name");
        String [] current = new String[2];
        current[0]=resultName;
        current[1]=coord;
        return current;
    }

}
