package com.example.android.udacitypraticalquiz_1;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    TextView mUser, mEmail, mDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        SharedPreferences mPrefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        String user = mPrefs.getString("user",null);
        String email = mPrefs.getString("email", null);
        String description = mPrefs.getString("description", null);
        mUser = findViewById(R.id.demousername);
        mEmail= findViewById(R.id.demoemail);
        mDescription= findViewById(R.id.demodescription);
        Bundle bundle = getIntent().getExtras();
      /*  String user = bundle.getString("user");
        String email = bundle.getString("email");
        String description = bundle.getString("description");*/

        mUser.setText(user);
        mEmail.setText(email);
        mDescription.setText(description);


    }
}
