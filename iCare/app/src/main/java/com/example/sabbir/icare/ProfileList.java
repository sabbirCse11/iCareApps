package com.example.sabbir.icare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class ProfileList extends AppCompatActivity {

    private ListView profileList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_list);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile_list, menu);
        return true;
    }

    public void btnAddClick(View v){
        Intent intent = new Intent(getApplicationContext(), AddProfile.class);
        startActivity(intent);
    }
    public void btnDiet(View v){
        Intent i=new Intent(getApplicationContext(),AddDiet_Activity.class);
        startActivity(i);
    }
    public void btnVaccine(View v){
        Intent i=new Intent(getApplicationContext(),AddVaccine.class);
        startActivity(i);
    }

    public void initialize(){
        profileList = (ListView) findViewById(R.id.profileList);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
