package com.savvy.savvy_survey;


import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;


public class upload extends AsyncTask<URL, Integer, String[]> {

    private String url;
    String[] result;
    String RequestMethod;
    String urlParameters;

    public upload(String urlParameters, String url, String RequestMethod) {
        this.urlParameters = urlParameters;
        this.url = url;
        this.RequestMethod = RequestMethod;

    }

    public void onpreExecute(String urlParameters, String url, String RequestMethod) {


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
            ArrayList<String> x =new ArrayList<>();
            while ((inputLine = br.readLine()) != null) {
                x.add(inputLine);

            }
            br.close();


            //savvy.reset();
            //print result
            Log.e("jul", x.toArray().toString());
            return (String[])x.toArray();
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


    protected void onPostExecute(String[] result) {


    }









    /*

        protected void onProgressUpdate(Integer... progress) {

        }




    protected Long doInBackground( URL... urls) {
        try {
            String url = "http://localhost:8080/foodreviews/savvy.php";
            String charset = "UTF-8";  // Or in Java 7 and later, use the constant: java.nio.charset.StandardCharsets.UTF_8.name()

            String param2 = "value2";


            String query = String.format("param1=%s" ,URLEncoder.encode(savvy.toJSON(), charset));
            URLConnection connection = new URL(url).openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("Accept-Charset", charset);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);

            Log.e("jul",savvy.toJSON());
            try (OutputStream output = connection.getOutputStream()) {
                output.writegetPostData();savvy.toJSON().getBytes()
                output.flush();
                output.close();
            }

            InputStream response = connection.getInputStream();


        } catch (IOException e) {

            Log.e("HTTP Post", "IO error = " + e.toString());
            return  (long)0;
        }
        return  (long)1 ;
    }
    */
}
