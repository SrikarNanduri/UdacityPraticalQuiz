package com.example.android.udacitypraticalquiz_1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    EditText user, email, descriptin ;


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

    }
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
}
