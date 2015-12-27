package com.oneworld.talukdar.oneworld;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import customAdepter.CountryAdepter;
import customAdepter.CountryItems;
import database.DBHelper;
import database.ExternalDbOpenHelper;
import database.Message;

public class listView extends AppCompatActivity {

    final ArrayList<CountryItems> countryItems = new ArrayList<>();
    CountryAdepter countryAdepter;
    ListView listView;
    private SQLiteDatabase database;


    private static final String DB_NAME = "Country_Details.db";

    //For Continent
    private static final String TABLE_NAME = "Continent";
    private static final String UID = "_id";
    private static final String CONTINENT = "Continent";
    private static final String AREA_KM = "Area_Km";
    private static final String POPULATION = "Population";
    private static final String DENSITY_KM = "Density_People_Per_Km";
    private static final String DENSITY_MILE = "Density_People_Per_Mile";
    private static final String MOST_POPULAS_CITY = "Most_Populas_city";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = (ListView)findViewById(R.id.listView);

        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(this, DB_NAME);
        database = dbOpenHelper.openDataBase();

        String s =getAllData();
        Message.message(this,s);

        /*CountryItems details = new CountryItems("Asia","Bangladesh",R.drawable.bhutan);
        countryItems.add(details);*/
       // fillList();
        setUpList();





        Intent intent = getIntent();
        String data = intent.getExtras().getString("key");

        if(data.equals("1")){
            Toast.makeText(getApplicationContext(),"One",Toast.LENGTH_LONG).show();
        }
        if(data.equals("2")){
            Toast.makeText(getApplicationContext(),"Two",Toast.LENGTH_LONG).show();
        }

    }


/*    private void fillList() {
        //friends = new ArrayList<String>();  which was countryItems
        //String[] columns = {UID,CONTINENT,AREA_KM,POPULATION,DENSITY_KM,DENSITY_MILE,MOST_POPULAS_CITY};
        Cursor continentNameCorsor = database.query(TABLE_NAME,new String[]{CONTINENT},null, null, null, null,null);
        Log.i("listView", "C1");
        Cursor populationCorsor = database.query(TABLE_NAME,new String[]{POPULATION},null, null, null, null,null);
        Log.i("listView", "2");
        continentNameCorsor.moveToFirst();
        populationCorsor.moveToFirst();

        int continent_Index = continentNameCorsor.getColumnIndex(CONTINENT);
        int population_Index = populationCorsor.getColumnIndex(POPULATION);

        if(!continentNameCorsor.isAfterLast()) {
            do {
                String ContinentName = continentNameCorsor.getString(continent_Index);
                String PopulationNumber = populationCorsor.getString(population_Index);
                Log.i("listView", "Do loop");
                CountryItems details = new CountryItems(ContinentName,PopulationNumber);
                countryItems.add(details);

            } while (continentNameCorsor.moveToNext());
        }
        continentNameCorsor.close();
        populationCorsor.close();
    }*/

    public String getAllData(){



        // SELECT _id,Name,Password from Continent //Table
        String[] columns = {UID,CONTINENT,AREA_KM,POPULATION,DENSITY_KM,DENSITY_MILE,MOST_POPULAS_CITY};
        Cursor cursor = database.query(TABLE_NAME, columns, null, null, null, null, null);

        StringBuffer buffer = new StringBuffer();
        while(cursor.moveToNext()){
            Context context=getApplicationContext();

            int continent_Index = cursor.getColumnIndex(CONTINENT);
            int population_Index = cursor.getColumnIndex(MOST_POPULAS_CITY);

            int cid = cursor.getInt(0);
            String name = cursor.getString(continent_Index);
            String nameLowerCase = name.toLowerCase().replaceAll("\\s+","");

            String pass = cursor.getString(population_Index);
            int id = context.getResources().getIdentifier(nameLowerCase, "drawable", context.getPackageName());
            //Drawable d = getResources().getDrawable(id);

            CountryItems details = new CountryItems(name,pass,id);
            countryItems.add(details);

            buffer.append(cid+" "+nameLowerCase+" "+pass+ "\n");
        }
        cursor.close();
        return buffer.toString();
    }


    private void setUpList() {
        /*setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, friends));
        listView = getListView();*/
        countryAdepter = new CountryAdepter(this, countryItems);
        listView.setAdapter(countryAdepter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {

                Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }


}
