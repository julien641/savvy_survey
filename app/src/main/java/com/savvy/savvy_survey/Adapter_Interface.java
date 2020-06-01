package com.savvy.savvy_survey;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

/**
 * Created by julien on 3/4/2018.
 */

public class Adapter_Interface implements AdapterView.OnItemSelectedListener {

    private boolean itemselected=false;
    public boolean getitemslected(){
        return itemselected;


    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        // If user change the default selection
        // First item is disable and it is used for hint
        if (position > 0 && view != null) {
            itemselected=true;

            ((TextView) view).setTextColor(view.getResources().getColor(R.color.darkblue,null));

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
