package com.savvy.savvy_survey;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.savvy.savvy_survey.dummy.DummyContent.DummyItem;
public class Mainmenu extends AppCompatActivity implements fraglist.OnListFragmentInteractionListener {
    public void onListFragmentInteraction(DummyItem item){




    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        Button form=(Button)findViewById(R.id.form);
        form.setOnClickListener(new forms());
        Button list=(Button)findViewById(R.id.list);
        list.setOnClickListener(new lists());
        Button getinspectors =findViewById(R.id.getinspectors);
        getinspectors.setOnClickListener(new getinspector());


        //// TODO: 2/15/2018 make this a button
     //  gotoformcleaning();
    }

    public void gotoformcleaning(){

        startActivity(new Intent(Mainmenu.this,Formactivity.class));
        finish();
    }





    private class getinspector implements View.OnClickListener{

        public void onClick(View view) {


            Log.d("jul", "added?");

            Log.d("jul", "we made it");
        }




    }







    private class lists implements View.OnClickListener{

        public void onClick(View view) {
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            Fragment fragment = getFragmentManager().findFragmentById(R.id.fragcontainer);
            ft.add(R.id.fragcontainer, new fraglist(), "yo");
            Log.d("jul", "added?");
            ft.addToBackStack("yo");
            ft.commit();
            Log.d("jul", "we made it");
        }




    }
    private class forms implements View.OnClickListener{

        public void onClick(View view) {

            startActivity(new Intent(Mainmenu.this,Formactivity.class));
            finish();
        }




    }
}
