package com.savvy.savvy_survey;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class FormTools {

    static public void setEnabledall(ArrayList<View> check, View view,boolean enabled){

        for(int i=0;i<check.size();i++) {
            if(check.get(i) instanceof CheckBox) {
                check.get(i).setEnabled(enabled);
            }
        }

        }
    static public ArrayList<View> getAllViews(ViewGroup layout,ArrayList<View> list) {
        Log.e("jul", "getAllViews"+layout.getChildCount());
        if(list==null) {
            list = new ArrayList<View>();
        }
        for (int i = 0; i < layout.getChildCount(); i++) {
            View element=layout.getChildAt(i);
            //if(! (element instanceof TextView || element instanceof Space)) {
            list.add(element);
            Log.d("jul", "layout.getChildAt"+i+")");
            //}
        }

        return list;
    }

    static public ArrayList<String> getdata(ArrayList<View> list,ArrayList<String>data) {
        if(data==null) {
             data = new ArrayList<String>();
        }

        for(int iter_view=0;iter_view<list.size();iter_view++){
            View element =  list.get(iter_view);
            if( element instanceof EditText){

                String edit_text = ((EditText)element).getText().toString();
                String edit_hint=  ((EditText)element).getHint().toString();


                if(edit_text.equals(edit_hint)){
                    data.add("");
                }
                else
                {
                    data.add(edit_text);
                }

            }
            if(element instanceof TextView){
                String TextView_text = ((TextView)element).getText().toString();
                String TextView_hint=  ((TextView)element).getHint().toString();
                if(TextView_text.equals(TextView_hint)){
                    data.add("");
                }
                else
                {
                    data.add(TextView_text);
                }

            }
            if(element instanceof Spinner){
                String Spinner_text = ((Spinner)element).getSelectedItem().toString();
                boolean Spinner_hint=  ((Adapter_Interface)((Spinner)element).getOnItemClickListener()).getitemslected();
                if(!Spinner_hint){
                    data.add("");
                }
                else
                {
                    data.add(Spinner_text);
                }

            }
            if(element instanceof CheckBox){
                CheckBox checkbox=(CheckBox)element;

                if(checkbox.isChecked()){
                    data.add(checkbox.getText().toString());
                }

            }

        }
        // EditText
        return data;
    }
}
