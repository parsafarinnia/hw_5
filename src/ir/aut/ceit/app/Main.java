package ir.aut.ceit.app;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static String city = null;
    public static int weatherDeterminizer = 0;
    public static int day = 0;
    public static String ID = null;
    public static String address = null;

    public static void displayInfo() {
        System.out.println("city or city id?\n for city press of 1 and for cityID press 2");
        Scanner input = new Scanner(System.in);
        int cityDeterminizer = input.nextInt();
        System.out.println("enter city ");
        Scanner inputcity = new Scanner(System.in);
        String cityinput = inputcity.next();
        if (cityDeterminizer == 1) {
            city = cityinput;
        } else {
            ID = cityinput;
        }
        System.out.println("for current weather press 1 and for forcast weather press 2");
        Scanner input2 = new Scanner(System.in);
        weatherDeterminizer = input2.nextInt();
        if (weatherDeterminizer == 2) {
            System.out.println("how many days in front you need weather information?");
            Scanner input3 = new Scanner(System.in);
            day = input3.nextInt();
        }

    }

    private static String getAddress() {
        if (weatherDeterminizer == 1) {
            address = ApiWeather.apiWeatherCurrent(city, ID);
        } else {
            address = ApiWeather.apiWeatherForcast(city, ID);
        }
        return address;
    }
    private static void lastDisplay(String[] array){
        String [] array1 ={"city","humidity","Description","Wind-Info","Coordination"};
        System.out.println("====================================================================");
        System.out.format("%-15s,%-10s,%-17s,%-17s,%-17s",array1[0],array1[1],array1[2],array1[3],array1[4]+"\n");
        System.out.println("====================================================================");
        System.out.format("%-15s,%-10s,%-17s,%-17s,%-17s",array[0],array[1],array[2],array[3],array[4]);



    }

    public static void main(String[] args) {
        displayInfo();
        String[] resultArray = new String[5];
        String jsonin = InputFileReader.reading(getAddress());
        if (weatherDeterminizer == 1) {
            resultArray[0] = CurrentWeather.currentweather(jsonin)[0];
            resultArray[4] = CurrentWeather.currentweather(jsonin)[1];
            resultArray[1] = CurrentWeather.baseWeather(jsonin)[0];
            resultArray[2] = CurrentWeather.baseWeather(jsonin)[1];
            resultArray[3] = CurrentWeather.baseWeather(jsonin)[2];
        }
        else {
            /*JSONObject jsonObject = new JSONObject(jsonin);
            JSONArray jsonArrayforcast = jsonObject.getJSONArray("List");
            JSONObject forcastjsonObject=jsonArrayforcast.getJSONObject(day);
            String forcastjson=forcastjsonObject.toString();
            resultArray[0] =ForcastWeather.forcast(jsonin)[0];
            resultArray[4] =ForcastWeather.forcast(jsonin)[1];
            resultArray[1] = ForcastWeather.baseWeather(forcastjson)[0];
            resultArray[2] = ForcastWeather.baseWeather(forcastjson)[1];
            resultArray[3] = ForcastWeather.baseWeather(forcastjson)[2];
        }
        lastDisplay(resultArray);
*/
            System.out.println(address);}
    }
}
