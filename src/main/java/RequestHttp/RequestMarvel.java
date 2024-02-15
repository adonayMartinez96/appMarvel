package RequestHttp;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

public class RequestMarvel {

    public static void requestGetMarvel() throws IOException {
        URL url = new URL("http://gateway.marvel.com/v1/public/characters?ts=1000&apikey=056f8011c12dde0c29a512fc164ed7ad&hash=48f052f9e40c77e75b6380f200a55442");
        URLConnection connection = url.openConnection();

        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream())))
        {
            String line;
            while ((line = in.readLine()) != null) {

                JSONObject jsonObject = new JSONObject(line);
                //System.out.println(jsonObject);
                //System.out.println(line);

                Iterator<String> keys = jsonObject.keys();
                while (keys.hasNext()){
                    String key = keys.next();

                    Object value = jsonObject.get(key);
                    System.out.println("Clave: " + key + ", Valor: " + value);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
