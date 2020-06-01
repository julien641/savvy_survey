package com.savvy.savvy_survey;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import java.util.ArrayList;

public class disabled_button implements CompoundButton.OnCheckedChangeListener {
View view;
    int layout;
    public disabled_button(View view,int layout){
        this.view=view;
        this.layout=layout;


    }

    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked ) {
        if(isChecked==true){
            disable(false,view,layout);


        }
        if(isChecked==false){
            disable(true,view,layout);


        }
    }public void disable(boolean bool,View view,int layout){
        ArrayList<View> x=FormTools.getAllViews((ViewGroup) view.findViewById(layout),null);
        FormTools.setEnabledall(x,view,bool);


    }
}


