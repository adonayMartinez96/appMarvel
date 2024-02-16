package RequestHttp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class RequestMarvel {

    public static void requestGetMarvel() throws IOException {
        URL url = new URL("http://gateway.marvel.com/v1/public/characters?ts=1000&apikey=056f8011c12dde0c29a512fc164ed7ad&hash=48f052f9e40c77e75b6380f200a55442");
        URLConnection connection = url.openConnection();

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream())))
        {
            String line;
            while ((line = in.readLine()) != null) {

                JSONObject jsonObject = new JSONObject(line);
                //System.out.println(jsonObject);
                //System.out.println(line);
                String code = jsonObject.getString("code");
                String status = jsonObject.getString("status");
                String copyright = jsonObject.getString("copyright");


                String dataString = jsonObject.getString("data");
                JSONObject dataJson = new JSONObject(dataString);
                JSONArray dataArray = dataJson.getJSONArray("results");

                //String id = jsonData.getString("results");
                //System.out.println("--> get value from key results: "+results);

                for(int i =0; i<dataArray.length();i++){
                    JSONObject resultsOb =  dataArray.getJSONObject(i);

                    String idCharacter = resultsOb.getString("id");
                    String nameCharacter = resultsOb.getString("name");
                    String descriptionCharacter = resultsOb.getString("description");

                    System.out.println("your ID is: "+idCharacter);
                    System.out.println("your NAME is: "+nameCharacter);
                    System.out.println("your DESCRIPTION id: "+descriptionCharacter+"\n\n");

                }

                System.out.println("--> get value from key code: "+ code);
                System.out.println("--> get value from key status: "+ status);
                System.out.println("--> get value from key copyright: "+ copyright);


            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void requestAbstractMarvel(String url, List<String> findParams) throws Exception{
        URL callApiGet = new URL(url);
        URLConnection connection = callApiGet.openConnection();

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream())))
        {
            String line;
            while ((line = in.readLine()) != null){

            }

        }
    }

    public void findKey(JSONObject detail, HashMap<String,String> findParams, List<String> getParams) throws JSONException {
        String returnValue ="";
        for(int i =0; i<getParams.size(); i++){
            findParams.put(getParams.get(i),detail.getString(getParams.get(i).toString()));
        }
    }
}
