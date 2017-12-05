package com.example.gabe.emojiweather;
import android.widget.TextView;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
/**
 * Class for parsing the traffic data
 */
public class TrafficParser
{

    //Unparsed string data is passed, which returns a string
    public String getTraffic(String data)
    {
        try
        {
            String output = "";

            //Parsing for Weather description, split by using the short description of the event
            String[] parts = data.split("shortDesc\":\"");

            for (int i = 1; i < parts.length; i++)
            {
                if(i < 4)
                {
                    String[] temp = parts[i].split("\",\"fullDesc\"");
                    output = output + "\uD83D\uDEA6" + temp[0] + "\n\n";
                }
            }
            if(output == "")
            {
                return "No Traffic Incidents Found!";
            }
            return output;
        }
        catch (Exception e){
            e.printStackTrace();

            return "Error!";
        }
    }
}