package ir.aut.ceit.app;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by parsa on 4/14/17.
 */
public class BaseWeather {
    /**
     * this method is in a supper class of two other kind of weather information
     * that gets humidity wind speed and descrioption weather of the requested city
     * @param json
     * @return array string of the middle 3 information
     */
    public static String[] baseWeather(String json) {
        String[] returnArray = new String[3];
        JSONObject jsonObject = new JSONObject(json);
        String result_weather;
        JSONArray jsonArrayWeather = jsonObject.getJSONArray("weather");
        if (jsonArrayWeather.length() > 0) {
            JSONObject jsonObjectWeather = jsonArrayWeather.getJSONObject(0);
            String resultDescription = jsonObjectWeather.getString("description");
            result_weather = resultDescription;
        } else {
            result_weather = "weather empty!";
        }
        JSONObject jsonObjectMain = jsonObject.getJSONObject("main");
        Double resultHumidity = jsonObjectMain.getDouble("humidity");
        JSONObject jsonObjectWind = jsonObject.getJSONObject("wind");
        Double resultSpeed = jsonObjectWind.getDouble("speed");
        Double resultDeg = jsonObjectWind.getDouble("deg");
        String resultWind = "speed: " + resultSpeed + " deg: " + resultDeg;
        returnArray[0] = resultHumidity.toString();
        returnArray[1] = result_weather;
        returnArray[2] = resultWind;

        return returnArray;

    }

}
