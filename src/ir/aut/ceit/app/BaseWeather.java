package ir.aut.ceit.app;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by parsa on 4/14/17.
 */
public class BaseWeather {
    public static String[] baseWeather(String json) {
        String[] returnArray = new String[3];
        JSONObject jsonObject = new JSONObject(json);

        //"coord"
        JSONObject jsonObjectCoord = jsonObject.getJSONObject("coord");
        Double resultLon = jsonObjectCoord.getDouble("lon");
        Double resultLat = jsonObjectCoord.getDouble("lat");

        //"sys"
        JSONObject jsonObjectSys = jsonObject.getJSONObject("sys");
        String resultCountry = jsonObjectSys.getString("country");
        int resultSunrise = jsonObjectSys.getInt("sunrise");
        int resultSunset = jsonObjectSys.getInt("sunset");

        //"weather"
        String result_weather;
        JSONArray jsonArrayWeather = jsonObject.getJSONArray("weather");
        if (jsonArrayWeather.length() > 0) {
            JSONObject jsonObjectWeather = jsonArrayWeather.getJSONObject(0);
            int resultId = jsonObjectWeather.getInt("id");
            String resultMain = jsonObjectWeather.getString("main");
            String resultDescription = jsonObjectWeather.getString("description");
            String resultIcon = jsonObjectWeather.getString("icon");

            result_weather = resultDescription;
            //"weather\tid: " + resultId + "\tmain: " + resultMain + "\tdescription: " + resultDescription + "\ticon: " + resultIcon;
        } else {
            result_weather = "weather empty!";
        }

        //"base"
        String resultBase = jsonObject.getString("base");

        //"main"
        JSONObject jsonObjectMain = jsonObject.getJSONObject("main");
        Double resultTemp = jsonObjectMain.getDouble("temp");
        Double resultPressure = jsonObjectMain.getDouble("pressure");
        Double resultHumidity = jsonObjectMain.getDouble("humidity");
        Double resultTempMin = jsonObjectMain.getDouble("temp_min");

        //"wind"
        JSONObject jsonObjectWind = jsonObject.getJSONObject("wind");
        Double resultSpeed = jsonObjectWind.getDouble("speed");
//        Double resultGust = jsonObjectWind.getDouble("gust");
        Double resultDeg = jsonObjectWind.getDouble("deg");
        String resultWind = "speed: " + resultSpeed + " deg: " + resultDeg;

        //"clouds"
        JSONObject jsonObjectClouds = jsonObject.getJSONObject("clouds");
        int resultAll = jsonObjectClouds.getInt("all");

        //"dt"
        int resultDt = jsonObject.getInt("dt");

        //"id"
        int resultId = jsonObject.getInt("id");

        //"name"
        String resultName = jsonObject.getString("name");

        //"cod"
        int resultCod = jsonObject.getInt("cod");
        returnArray[0] = resultHumidity.toString();
        returnArray[1] = result_weather;
        returnArray[2] = resultWind;

        return returnArray;

    }

}
