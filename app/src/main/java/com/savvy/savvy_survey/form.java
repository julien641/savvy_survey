package com.savvy.savvy_survey;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Space;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by julien on 8/30/2017.
 */

public class form {

    private String[] appart;
    private String[] entrence;
    private String[] liv_din;
    private String[] laundryroom;
    private String[] utilitycheck;
    private String[] bedroom1;
    private String[] bathroom1;
    private String[] bedroom2;
    private String[] bathroom2;
    private String[] bedroom3;
    private String[] bathroom3;
    private String[] kitchen;
    private String[] can;
    private String[] patio;

    public form() {


    }


    public void setAppart(String[][] appart) {
        this.appart = new String[appart.length];
        for (int i = 0; i < appart.length; i++) {
            this.appart[i] = appart[i][0];


        }
    }

    public String[] getAppart() {
        return appart;
    }

    public String[] getEntrence() {
        return entrence;
    }

    public String[] getLiv_din() {
        return liv_din;
    }

    public String[] getLaundryroom() {
        return laundryroom;
    }

    public String[] getUtilitycheck() {
        return utilitycheck;
    }

    public String[] getBedroom1() {
        return bedroom1;
    }

    public String[] getBathroom1() {
        return bathroom1;
    }

    public String[] getBedroom2() {
        return bedroom2;
    }

    public String[] getBathroom2() {
        return bathroom2;
    }

    public String[] getBedroom3() {
        return bedroom3;
    }

    public String[] getBathroom3() {
        return bathroom3;
    }

    public String[] getKitchen() {
        return kitchen;
    }

    public String[] getCan() {
        return can;
    }

    public String[] getPatio() {
        return patio;
    }

    public void setEntrence(String[] entrence) {
        this.entrence = entrence.clone();
    }

    public void setLaundryroom(String[] Laundryroom) {
        this.laundryroom = Laundryroom.clone();
    }

    public void setutilitycheck(String[] utilitycheck) {
        this.utilitycheck = utilitycheck.clone();
    }

    public void setliv_din(String[] liv_din) {


        this.liv_din = liv_din.clone();
    }

    public void setbedroom1(String[] bedroom1) {
        this.bedroom1 = bedroom1.clone();
    }


    public void setbathroom1(String[] bathroom1) {
        this.bathroom1 = bathroom1;
    }

    public void setbedroom2(String[] bedroom2) {
        this.bedroom2 = bedroom2.clone();
    }

    public void setbathroom2(String[] bathroom2) {
        this.bathroom2 = bathroom2.clone();
    }

    public void setbedroom3(String[][] bedroom3) {
        this.bedroom3 = new String[bedroom3.length];

    }

    public void setbathroom3(String[] bathroom3) {
        this.bathroom3 = bathroom3.clone();
    }

    public void setkitchen(String[] kitchen) {
        this.kitchen = kitchen.clone();
    }

    public void setcan(String[] can) {
        this.can = can.clone();
    }

    public void setpatio(String[] patio) {
        this.patio = patio.clone();
    }

    public String toJSON() {
        Log.e("jul", "hello json");
        JSONObject jsonObject = new JSONObject();

        try {
            JSONArray jSONArray = new JSONArray(appart);
            jsonObject.put("appartment", jSONArray);

            /*
            jsonObject.put("Entrence", getEntrence());
            jsonObject.put("Liv_din", getLiv_din());
            jsonObject.put("Laundryroom", getLaundryroom());
            jsonObject.put("Utilitycheck", getUtilitycheck());
*/
            Log.e("jul", jsonObject.toString());

            return jsonObject.toString();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "";
        }

    }



}