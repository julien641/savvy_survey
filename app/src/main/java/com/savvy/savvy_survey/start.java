package com.savvy.savvy_survey;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class start extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);





        nextactivity();
    }

    private void nextactivity(){



startActivity(new Intent(start.this,LoginActivity.class));
        finish();
    }

}
