package com.example.android.udacitypraticalquiz_1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    EditText user, email, descriptin ;
    Button next;
    public static final String savedUser = "callbacks";
    public static final String savedEmail = "callbacks";
    public static final String saveDescription = "callbacks";


    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(R.color.colorPrimaryDark);

        user = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        descriptin =(EditText) findViewById(R.id.description);
        next = (Button) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailsIntent = new Intent(MainActivity.this, DetailsActivity.class);
                detailsIntent.putExtra("user", String.valueOf(user.getText()));
                detailsIntent.putExtra("email", String.valueOf(email.getText()) );
                detailsIntent.putExtra("description",  String.valueOf(descriptin.getText()));
                startActivity(detailsIntent);
            }
        });
        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey(savedUser) && savedInstanceState.containsKey(savedEmail) && savedInstanceState.containsKey(saveDescription) ) {
                String mUser = savedInstanceState.getString(savedUser);
                String mEmail = savedInstanceState.getString(savedEmail);
                String mDescription = savedInstanceState.getString(saveDescription);
                user.setText(mUser);
                email.setText(mEmail);
                descriptin.setText(mDescription);
            }
        }




    }

  /*  @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user", user.getText().toString());
        editor.putString("email", email.getText().toString());
        editor.putString("description", descriptin.getText().toString());
        editor.apply();
    }
*/
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.action_account) {
            Intent detailsIntent = new Intent(this, DetailsActivity.class);
            detailsIntent.putExtra("user", String.valueOf(user.getText()));
            detailsIntent.putExtra("email", String.valueOf(email.getText()) );
            detailsIntent.putExtra("description",  String.valueOf(descriptin.getText()));
            startActivity(detailsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String savedStateUser = user.getText().toString();
        String saveStateEmail = email.getText().toString();
        String saveStateDescription = descriptin.getText().toString();
        outState.putString(savedUser, savedStateUser);
        outState.putString(savedEmail, saveStateEmail);
        outState.putString(saveDescription, saveStateDescription);
    }
}
