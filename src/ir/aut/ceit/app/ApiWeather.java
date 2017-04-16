package ir.aut.ceit.app;

/**
 * Created by parsa on 4/14/17.
 */
public class ApiWeather {
    public static String apiWeatherForcast(String city, String ID) {
        String address = null;
        if (city.equals(null)) {
            return "http://api.openweathermap.org/data/2.5/forecast?id=" + ID + "&appid=af831b5166cf90875cf56f9c07031679";
        } else if (!city.equals(null)) {
            return "http://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=af831b5166cf90875cf56f9c07031679";
        } else return "no city given";
    }

    public static String apiWeatherCurrent(String city, String ID) {
        if (city.equals(null)) {
            return "http://api.openweathermap.org/data/2.5/weather?id=" + ID + "&appid=af831b5166cf90875cf56f9c07031679";
        } else if (!city.equals(null)) {
            return "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=af831b5166cf90875cf56f9c07031679";
        } else return "no city given";
    }

}
