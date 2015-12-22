package com.oneworld.talukdar.oneworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import customAdepter.CountryAdepter;
import customAdepter.CountryItems;

public class listView extends AppCompatActivity {

    final ArrayList<CountryItems> countryItems = new ArrayList<>();
    CountryAdepter countryAdepter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        String[] Continents_SortBy_Population = new String[]{"Asia", "Africa","North America","South America","Antarctica","Europe","Australia"};
        String[] Continents_SortBy_Name = new String[]{ "Africa","Antarctica","Asia","Australia","Europe","North America","South America"};

        String[] Countries_Asia = new String[]{"Afghanistan","Bangladesh","Bhutan","Brunei"};
        String[] Capital_Asia = new String[]{"Kabul","Dhaka","Thimphu","Bandar Seri Begawan"};

        ListView listView = (ListView)findViewById(R.id.listView);

        CountryItems Afghanistan = new CountryItems("Afghanistan","Kabul",R.drawable.afghanistan);
        CountryItems Bangladesh = new CountryItems("Bangladesh","Dhaka",R.drawable.bangladesh);
        CountryItems Bhutan = new CountryItems("Bhutan","Thimphu",R.drawable.bhutan);
        CountryItems Brunei = new CountryItems("Brunei","Bandar Seri Begawan",R.drawable.brunei);

        countryItems.add(Afghanistan);
        countryItems.add(Bangladesh);
        countryItems.add(Bhutan);
        countryItems.add(Brunei);

        Intent intent = getIntent();
        String data = intent.getExtras().getString("key");

        countryAdepter = new CountryAdepter(this, countryItems);
        listView.setAdapter(countryAdepter);

        if(data.equals("1")){
            Toast.makeText(getApplicationContext(),"One",Toast.LENGTH_LONG).show();
        }
        if(data.equals("2")){
            Toast.makeText(getApplicationContext(),"Two",Toast.LENGTH_LONG).show();
        }

    }
}
