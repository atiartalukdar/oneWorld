package com.oneworld.talukdar.oneworld;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import database.ExternalDbOpenHelper;

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
        Log.i("listView", "C1");

        ExternalDbOpenHelper dbOpenHelper = new ExternalDbOpenHelper(this, DB_NAME);
        database = dbOpenHelper.openDataBase();
        fillFreinds();
        setUpList();

        /*String[] Continents_SortBy_Population = new String[]{"Asia", "Africa","North America","South America","Antarctica","Europe","Australia"};
        String[] Continents_SortBy_Name = new String[]{ "Africa","Antarctica","Asia","Australia","Europe","North America","South America"};

        String[] Countries_Asia = new String[]{"Afghanistan","Bangladesh","Bhutan","Brunei"};
        String[] Capital_Asia = new String[]{"Kabul","Dhaka","Thimphu","Bandar Seri Begawan"};*/



/*        CountryItems Afghanistan = new CountryItems("Afghanistan","Kabul",R.drawable.afghanistan);
        CountryItems Bangladesh = new CountryItems("Bangladesh","Dhaka",R.drawable.bangladesh);
        CountryItems Bhutan = new CountryItems("Bhutan","Thimphu",R.drawable.bhutan);
        CountryItems Brunei = new CountryItems("Brunei","Bandar Seri Begawan",R.drawable.brunei);

        countryItems.add(Afghanistan);
        countryItems.add(Bangladesh);
        countryItems.add(Bhutan);
        countryItems.add(Brunei);

        countryAdepter = new CountryAdepter(this, countryItems);
        listView.setAdapter(countryAdepter);*/


        Intent intent = getIntent();
        String data = intent.getExtras().getString("key");

        if(data.equals("1")){
            Toast.makeText(getApplicationContext(),"One",Toast.LENGTH_LONG).show();
        }
        if(data.equals("2")){
            Toast.makeText(getApplicationContext(),"Two",Toast.LENGTH_LONG).show();
        }

    }


    private void fillFreinds() {
        //friends = new ArrayList<String>();  which was countryItems
        String[] columns = {UID,CONTINENT,AREA_KM,POPULATION,DENSITY_KM,DENSITY_MILE,MOST_POPULAS_CITY};
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
    }



    private void setUpList() {
        /*setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, friends));
        listView = getListView();*/
        countryAdepter = new CountryAdepter(this, countryItems);
        listView.setAdapter(countryAdepter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        ((TextView) view).getText().toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }


}
