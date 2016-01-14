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

    Intent intentNext;
    final ArrayList<CountryItems> countryItems = new ArrayList<>();
    CountryAdepter countryAdepter;
    ListView listView;
    private SQLiteDatabase database;
    String data;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listView = (ListView)findViewById(R.id.listView);

        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(this, DB_NAME);
        database = dbOpenHelper.openDataBase();

        Intent intent = getIntent();
        data = intent.getExtras().getString("key");

        String s =getAllData();
        Message.message(this,s);

        /*CountryItems details = new CountryItems("Asia","Bangladesh",R.drawable.bhutan);
        countryItems.add(details);*/
       // fillList();
        setUpList();
    }

 public String getAllData(){
        // SELECT _id,Name,Password from Continent //Table
        Cursor cursor=null;
        String[] columns_Continent = {UID,CONTINENT,AREA_KM,POPULATION,DENSITY_KM,DENSITY_MILE,MOST_POPULAS_CITY};
        String[] columns_country = {UID_C,CONTINENT_C,COUNTRY_C,CAPITAL_C,CURRENCY_C,REGION_C,POPULATION_C,
             AREA_KM_C,DENSITY_MILE_C,GBP_C,LITERACY_C,PHONE_CODE_C};
     StringBuffer buffer = new StringBuffer();
     if(data.equals("1")){
            Toast.makeText(getApplicationContext(),"One",Toast.LENGTH_LONG).show();
            cursor = database.query(TABLE_NAME, columns_Continent, null, null, null, null, null);
         while(cursor.moveToNext()){
             Context context=getApplicationContext();

            //Getting the Index number from database
             int Index_Continent = cursor.getColumnIndex(CONTINENT);
             int Index_Area_KM = cursor.getColumnIndex(AREA_KM);
             int Index_POPULATION = cursor.getColumnIndex(POPULATION);
             int Index_Density_KM = cursor.getColumnIndex(DENSITY_KM);
             int Index_Density_Mile = cursor.getColumnIndex(DENSITY_MILE);
             int Index_Populas_City = cursor.getColumnIndex(MOST_POPULAS_CITY);

            //getting the particular data from db by using index
             int cid = cursor.getInt(0);
             String name = cursor.getString(Index_Continent);
             String Area_KM = cursor.getString(Index_Area_KM);
             String population = cursor.getString(Index_POPULATION);
             String Density_KM = cursor.getString(Index_Density_KM);
             String Density_Mile = cursor.getString(Index_Density_Mile);
             String Populas_City = cursor.getString(Index_Populas_City);

             //getting the drawable name from drawable folder by name column from db
             String nameLowerCase = name.toLowerCase().replaceAll("\\s+", "");
             int id = context.getResources().getIdentifier(nameLowerCase, "drawable", context.getPackageName());

             CountryItems details = new CountryItems(name,population,id);
             countryItems.add(details);

             buffer.append(cid+" "+name+" "+population+ "\n");
         }
         cursor.close();
         database.close();
        }
        if(data.equals("2")){
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
        }

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
                intentNext =new Intent(listView.this,CountryDetails.class);
                intentNext.putExtra("key1", position+1+" "+data);

                startActivity(intentNext);
                Toast.makeText(getApplicationContext(),"Clicked",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private  void bindIntentWithData(int position){
        intentNext.putExtra("getCountryName", ""+countryItems.get(position).getCountryName());
        intentNext.putExtra("getCountryName", ""+countryItems.get(position).getCountryName());
        intentNext.putExtra("getCountryName", ""+countryItems.get(position).getCountryName());
    }

}
