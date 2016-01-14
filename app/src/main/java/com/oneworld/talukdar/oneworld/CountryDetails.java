package com.oneworld.talukdar.oneworld;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import customAdepter.CountryItems;

public class CountryDetails extends AppCompatActivity {
    private SQLiteDatabase database;
private String[] elements;
    //For Continent
    private static final String TABLE_NAME = "Continent";
    private static final String UID = "_id";
    private static final String CONTINENT = "Continent";
    private static final String AREA_KM = "Area_Km";
    private static final String POPULATION = "Population";
    private static final String DENSITY_KM = "Density_People_Per_Km";
    private static final String DENSITY_MILE = "Density_People_Per_Mile";
    private static final String MOST_POPULAS_CITY = "Most_Populas_city";

    //For Country
    private static final String TABLE_NAME_COUNTRY = "Country";
    private static final String UID_C = "_id";
    private static final String CONTINENT_C = "Continent";
    private static final String COUNTRY_C = "Country";
    private static final String CAPITAL_C = "Capital";
    private static final String CURRENCY_C = "Currency";
    private static final String REGION_C = "Region";
    private static final String POPULATION_C = "Population";
    private static final String AREA_KM_C = "Area_sq_mi";
    private static final String DENSITY_MILE_C = "Pop_Density_per_sq_mile";
    private static final String GBP_C = "GDP";
    private static final String LITERACY_C = "Literacy";
    private static final String PHONE_CODE_C = "PhoneCode";

    ImageView imageView;
    TextView countryTV;
    String data,data1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);
        countryTV = (TextView) findViewById(R.id.CountryNameDetails);

        Intent intent = getIntent();
        data = intent.getExtras().getString("key1");
        data1 = intent.getExtras().getString("ss");

        //In elements[0] will contain the clicked items position, & elements[1] will contain the database table name;
        elements = data.split(" ");
        countryTV.setText(data1);
       // getAllData();
    }





        public void getAllData(){
        // SELECT _id,Name,Password from Continent //Table
        Cursor cursor=null;
        String[] columns_Continent = {UID,CONTINENT,AREA_KM,POPULATION,DENSITY_KM,DENSITY_MILE,MOST_POPULAS_CITY};
        String[] columns_country = {UID_C,CONTINENT_C,COUNTRY_C,CAPITAL_C,CURRENCY_C,REGION_C,POPULATION_C,
                AREA_KM_C,DENSITY_MILE_C,GBP_C,LITERACY_C,PHONE_CODE_C};

        if(elements[1].trim().equals("1")){
           Toast.makeText(getApplicationContext(), "One", Toast.LENGTH_LONG).show();
            cursor = database.query(TABLE_NAME, columns_Continent, UID+" = '"+Integer.parseInt(elements[0])+"'", null, null, null, null);
            while(cursor.moveToNext()){
                Context context=getApplicationContext();

                int Index_Continent = cursor.getColumnIndex(CONTINENT);
                int Index_POPULATION = cursor.getColumnIndex(POPULATION);

                int cid = cursor.getInt(0);
                String name = cursor.getString(Index_Continent);
                String population = cursor.getString(Index_POPULATION);

                String nameLowerCase = name.toLowerCase().replaceAll("\\s+", "");
                int id = context.getResources().getIdentifier(nameLowerCase, "drawable", context.getPackageName());
                //Drawable d = getResources().getDrawable(id);

                countryTV.setText(name);
            }
            cursor.close();
            database.close();
        }
    /*    if(data.equals("2")){
            Toast.makeText(getApplicationContext(),"Two",Toast.LENGTH_LONG).show();
            cursor = database.query(TABLE_NAME_COUNTRY, columns_country, null, null, null, null, null);
            while(cursor.moveToNext()){
                Context context=getApplicationContext();

                int country_Index = cursor.getColumnIndex(COUNTRY_C);
                int capital_Index = cursor.getColumnIndex(CAPITAL_C);

                int cid = cursor.getInt(0);
                String name = cursor.getString(country_Index);
                String population = cursor.getString(capital_Index);

                String nameLowerCase = name.toLowerCase().replaceAll("\\s+", "");
                int id = context.getResources().getIdentifier(nameLowerCase, "drawable", context.getPackageName());
                //Drawable d = getResources().getDrawable(id);

                CountryItems details = new CountryItems(name,population,id);
                countryItems.add(details);

                buffer.append(cid + " " + name + " " + population + "\n");
            }
            cursor.close();
            database.close();
        }*/


    }


    }

