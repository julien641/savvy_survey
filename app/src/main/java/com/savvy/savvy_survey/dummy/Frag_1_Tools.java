package com.savvy.savvy_survey.dummy;

import android.content.Context;
import android.view.View;
import android.widget.Spinner;

import com.savvy.savvy_survey.Adapter_Interface;
import com.savvy.savvy_survey.SpinnerformAdapter;
public class Frag_1_Tools{


    static public View settingupspinners(Context context,Spinner spinner, String[] array, int layout ){


        SpinnerformAdapter adapter =
                new SpinnerformAdapter(
                        context,
                        layout,
                        array
                        );
        adapter.setDropDownViewResource(layout);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(  new Adapter_Interface());
        return spinner;
    }

    /*
    public int getallinfo(form savvy,View view/*, Context context){
        ArrayList<View> x =new ArrayList<View>();

        x =FormTools.getAllViews(
                (ViewGroup)((LinearLayout)getView().findViewById(R.id.layout1)),
                x);
        ArrayList<String> data= new ArrayList<String>();

        data=FormTools.getdata(x,data);




            CharSequence text = test[i][1];
            int duration = Toast.LENGTH_SHORT;

            //   Toast toast = Toast.makeText(context, text, duration);
            // toast.show();
            return 0;
        }else{
            savvy.setAppart(test);
            return 1;
        }

    }
*/
    static public int arraychecker(String[][] s) {

        for (int i = 0; i < s.length; i++) {
            if (s[i][0] == null || s[i][0].isEmpty()) {
                return i;

            }
        }
        return -1;
    }

}
