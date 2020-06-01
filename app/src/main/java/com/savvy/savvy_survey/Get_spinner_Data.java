package com.savvy.savvy_survey;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Spinner;

import com.savvy.savvy_survey.dummy.Frag_1_Tools;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Get_spinner_Data extends AsyncTask<URL, Integer, String[]> {

    private String url;
    String[] result;
    String RequestMethod;
    String urlParameters;
    Context context;
    Spinner spinner;
    int id;
    int layout;
    String key;
    protected void onPostExecute(String[] result) {
        Frag_1_Tools.settingupspinners(context,spinner,result,layout);

    }

    public Get_spinner_Data(String urlParameters, String url, String RequestMethod, Context context,  Spinner spinner, int layout, String key) {
        this.urlParameters = urlParameters;
        this.url = url;
        this.RequestMethod = RequestMethod;
        this.context=context;
        this.spinner=spinner;

        this.layout=layout;
        this.key=key;

    }

    public void onpreExecute() {


    }
    public boolean isConnectedToServer(String url, int timeout) {
        try{
            URL myUrl = new URL(url);
            URLConnection connection = myUrl.openConnection();
            connection.setConnectTimeout(timeout);
            connection.connect();
            return true;
        } catch (Exception e) {
            // Handle your exceptions
            return false;
        }
    }
    public String[] sendPost() throws Exception {

        try {
            URL obj = new URL(url);
            Log.e("jul", "con" + urlParameters);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            //add reuqest header
            con.setRequestMethod(RequestMethod);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            //      con.setRequestProperty("Content-Type", "application/json");
            //     con.setRequestProperty("Accept", "application/json");
            con.connect();


            //Request Parameters you want to send
            // Send post request
            OutputStream os = con.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
            writer.write(urlParameters);
            writer.close();
            os.close();
            Log.e("jul", "uploaded");


            int responseCode = con.getResponseCode();
            //  System.out.println("\nSending 'POST' request to URL : " + url);
            //   System.out.println("Post parameters : " + urlParameters);
            //   System.out.println("Response Code : " + responseCode);
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));


            String inputLine;
            String data = "";
            while ((inputLine = br.readLine()) != null) {
                Log.e("jul", "InputLine" + inputLine);
                data = "" + inputLine;

            }
            br.close();
            Log.e("jul", "rawjson" + data);
            ArrayList<String> stringArray = jsonStringToArray(data, key);

            //savvy.reset();
            //print result
            for (int i = 0; i < stringArray.size(); i++) {

                Log.e("jul", "ArrayList:" + i + ":" + stringArray.get(i));

            }
            result = StringArrayListtoArray(stringArray);

            for (int i = 0; i < result.length; i++) {

                Log.e("jul", "Array:" + i + ":" + result[i]);

            }
            return result;
        } catch (SocketTimeoutException e) {


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return null;
    }

    protected String[] doInBackground(URL... urls) {
        try {

            result = sendPost();
            return result;
        } catch (Exception e) {
            Log.e("jul", e.getLocalizedMessage());

        }

        return null;
    }

//source
//https://stackoverflow.com/questions/11527214/java-convert-a-json-string-to-an-array

    public String[] StringArrayListtoArray(ArrayList<String> list){
        String[] data =new String[list.size()];

        for(int i=0;i<list.size();i++){
            data[i]=list.get(i);
        }
        return data;
    }
    public ArrayList<String> jsonStringToArray(String jsonString,String key) throws JSONException {

        ArrayList<String> stringArray = new ArrayList<>();

        JSONArray jsonArray = new JSONArray(jsonString);
        stringArray.add(key.replace('_',' '));


        for (int i = 0; i < jsonArray.length(); i++) {
            stringArray.add(jsonArray.getJSONObject(i).getString(key));
        }

        return stringArray;
    }

}
