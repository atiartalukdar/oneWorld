package com.oneworld.talukdar.oneworld;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.MailTo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import database.DBHelper;

public class MainActivity extends AppCompatActivity {
DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*dbHelper = new DBHelper(this);
        SQLiteDatabase sqLiteDatabase = dbHelper.getWritableDatabase();*/
    }


    public void continentBtn(View view){
        Intent intent =new Intent(this,listView.class);
        intent.putExtra("key", "1");
        startActivity(intent);
    }
    public void countryBtn(View view){
        Intent intent =new Intent(this,listView.class);
        intent.putExtra("key", "2");
        startActivity(intent);

    }










































    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
