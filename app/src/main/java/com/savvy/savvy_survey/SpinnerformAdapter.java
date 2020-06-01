package com.savvy.savvy_survey;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by julien on 2/18/2018.
 */

public class SpinnerformAdapter extends ArrayAdapter<String> implements AdapterView.OnItemSelectedListener{
    public SpinnerformAdapter(Context searchFragment, int resource, String[] arrayEstablishType)
    {
        super(searchFragment, resource, arrayEstablishType);
    }

    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        View view = super.getDropDownView(position, convertView, parent);
        TextView tv = (TextView) view;

        if (position == 0) {
            // Set the hint text color gray
            tv.setTextColor(view.getResources().getColor(R.color.light_blue,null));
        } else {
            tv.setTextColor(view.getResources().getColor(R.color.dark_blue,null));
        }
        return view;
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        // If user change the default selection
        // First item is disable and it is used for hint
        if(position > 0){

            ((TextView) view).setTextColor(view.getResources().getColor(R.color.dark_blue,null));


        }
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }
    public boolean isEnabled(int position) {
        if (position == 0) {
            // Disable the first item from Spinner
            // First item will be use for hint
            return false;
        } else {
            return true;
        }
    }
    @Override
    public int getCount()
    {
        return super.getCount();
    }

    @Override
    public String getItem(int position) {
        super.getItem(position);

        return super.getItem(position);
    }

        public long getItemId(int position)
        {
            return super.getItemId(position);
        }
    }




