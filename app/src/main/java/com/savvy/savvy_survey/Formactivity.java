package com.savvy.savvy_survey;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import layout.form_frag_2;
import layout.form_frag_3;
import layout.form_frag_4;
import layout.form_frag_5;

public class Formactivity extends AppCompatActivity implements Form_Frag.OnFragmentInteractionListener,
        Base_frag.OnFragmentInteractionListener,
        form_frag_2.OnFragmentInteractionListener,
        form_frag_3.OnFragmentInteractionListener,
        form_frag_4.OnFragmentInteractionListener,
        form_frag_5.OnFragmentInteractionListener {
    Submit_event submit_event;
    CHANGE_NEXTFRAG_Event nextfrag;
    private Toolbar toolbar;


    FragmentManager fragmentManager = this.getFragmentManager();
    FragmentTransaction ft = fragmentManager.beginTransaction();


    private Button submit;

    private String TAG = "jul";
    private form savvy = new form();

    ArrayList<Form_Frag> frag_list = new ArrayList<>();
    ArrayList<Integer> layout = new ArrayList<>();
    //TODO add more layout
    int[] layoutarr = {R.layout.fragment_form_frag_1, R.layout.fragment_form_frag_2,
            R.layout.fragment_form_frag_3, R.layout.fragment_form_frag_4, R.layout.fragment_form_frag_5,
            R.layout.fragment_form_frag_6, R.layout.fragment_form_frag_7, R.layout.fragment_form_frag_8,
            R.layout.fragment_form_frag_9, R.layout.fragment_form_frag_10, R.layout.fragment_form_frag_11,
            R.layout.fragment_form_frag_12, R.layout.fragment_form_frag_13, R.layout.fragment_form_frag_14,
            R.layout.fragment_form_frag_15};

    Button next;

    final String[] fragments = {"0", "1", "2", "3", "4", "5", "6"};

    public void onFragmentInteraction(Uri uri) {
        //you can leave it empty
    }

    // public getMenuInflater();
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onBackPressed() {
        //   super.onBackPressed();
        nextfrag.currentfragindex=nextfrag.currentfragindex-2 ;
        if(nextfrag.currentfragindex<=-2){





        }else{
            nextfrag.onClick(next);

        }

    }

    public void optionselect(int x) {
        nextfrag.currentfragindex = x-1;
        nextfrag.onClick(next);


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement

        switch (id) {
            case R.id.frag1:
                optionselect(0);
                break;
            case R.id.frag2:
                optionselect(1);
                break;
            case R.id.frag3:
                optionselect(2);
                break;
            case R.id.frag4:
                optionselect(3);
                break;
            case R.id.frag5:
                optionselect(4);
                break;
            case R.id.frag6:
                optionselect(5);
                break;
            case R.id.frag7:
                optionselect(6);
                break;
            case R.id.frag8:
                optionselect(7);
                break;
            case R.id.frag9:
                optionselect(8);
                break;
            case R.id.frag10:
                optionselect(9);
                break;
            case R.id.frag11:
                optionselect(10);
                break;
            case R.id.frag12:
                optionselect(11);
                break;
            case R.id.frag13:
                optionselect(12);
                break;
            case R.id.frag14:
                optionselect(13);
                break;
            case R.id.frag15:
                optionselect(14);
                break;
            default:
                return super.onOptionsItemSelected(item);

        }
        return true;
    }




final int start_index=-1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_form);
         toolbar=findViewById(R.id.toolbar2);
         toolbar.setTitleTextColor(getResources().getColor(R.color.white,null));
        setSupportActionBar(toolbar);

        next = findViewById(R.id.nextbutton);

        nextfrag= new CHANGE_NEXTFRAG_Event(start_index);

        next.setOnClickListener(nextfrag);
        next.callOnClick();
        submit_event= new Submit_event();
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(submit_event);

        //  MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.emin);
        //  mediaPlayer.start();

    }

public void scrollreset(){
    ScrollView scroll=(ScrollView) findViewById(R.id.scroll);
    scroll.scrollTo(0,0);

}


    public class CHANGE_NEXTFRAG_Event implements View.OnClickListener {
        int currentfragindex;
        public CHANGE_NEXTFRAG_Event(int currentfragindex){
            this.currentfragindex=currentfragindex;
        }
        public void onClick(View view) {

            scrollreset();
            currentfragindex++;

            if (currentfragindex>frag_list.size()-1) {

                frag_list.add( Form_Frag.newInstance(currentfragindex,layoutarr[currentfragindex]));

            }


            loadFragment(frag_list.get(currentfragindex),fragments[currentfragindex]);


        }

        public void loadFragment(Form_Frag frag, String tag) {

            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            Fragment fragment = getFragmentManager().findFragmentById(R.id.fragcountainer);

            if (fragment == null) {

                ft.add(R.id.fragcountainer, frag, tag);

            } else {
                ft.replace(R.id.fragcountainer, frag, tag);
            }

            //ft.addToBackStack(tag);

            ft.commit();
        }

    }


    private class Submit_event implements View.OnClickListener {

        public void onClick(View v) {
           // fragment1.getallinfo(savvy);
           // new upload(savvy, "https://productreview.000webhostapp.com/phpscript/savvy/savvy.php").execute();


            // }



/*
        for (int i = 1; i < 13+1; i++) {
            savvy.setLiv_din(savvy.getLiv_din()+"."+ gettingmarks( findViewById(getResources().
                    getIdentifier("liv_din_check" + i, "id", getPackageName()))));
        }

        for (int i = 1; i < 5+1; i++) {
            savvy.setLaundryroom( savvy.getLaundryroom()+"."+ gettingmarks( findViewById(getResources().
                    getIdentifier("Laundryroom_check" + i, "id", getPackageName()))));
        }
        for (int i = 1; i < 5+1; i++) {
            savvy.setUtilitycheck( savvy.getUtilitycheck()+"."+  gettingmarks( findViewById(getResources().
                    getIdentifier("utilitycheck" + i, "id", getPackageName()))));
        }

        Log.d(TAG, "onClick: "+RCSTRING);

            new upload(savvy, "https://productreview.000webhostapp.com/phpscript/savvy/savvy.php").execute();

        Log.d(TAG, "onClick: "+RCSTRING);
                Log.d(TAG, "uploaded: " + RCSTRING);


*/

        }

    }



    public String gettingmarks(View x) {
        String RSTRING = "";
        CheckBox y = (CheckBox) x;
        if (y.isChecked()) {
            RSTRING = y.getText().toString();
         //   points++;
            return RSTRING + "/";
        }
        return "";

    }

/*
    StringRequest request = new StringRequest(Request.Method.POST, "https://productreview.000webhostapp.com/phpscript/savvy/savvy.php", new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {

            System.out.println(response.toString());
        }
    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    });

*/
}
