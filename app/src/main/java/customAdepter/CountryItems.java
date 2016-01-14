package customAdepter;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import com.oneworld.talukdar.oneworld.R;

/**
 * Created by Talukdar on 12/22/2015.
 */


public class CountryItems {
    //For Continent
    int ID_Continent;
    String Continent_Continent;
    String Population_Continent;
    String Density_People_Per_Km_Continent;
    String Density_People_Per_Mile_Continent;
    String Most_Populas_city_Continent;

    //For Countries
    int ID;
    String countryName;
    String Continent;
    String Capital;
    int Population; // in millions
    int GDP; // in Billions
    String Currency_Type;
    int Size; // in square miles
    int Phone_Code;

    // let's leave these blank for the time being
    int Flag;
    int Currency_Symbol;


    public CountryItems(String countryName, String capital, int flag) {
        this.countryName = countryName;
        Capital = capital;
        Flag = flag;
    }

    public CountryItems(String continent_Continent, String population_Continent) {
        Continent_Continent = continent_Continent;
        Population_Continent = population_Continent;
    }

    public CountryItems(int ID_Continent, String continent_Continent, String density_People_Per_Km_Continent,
                        String population_Continent, String density_People_Per_Mile_Continent, String most_Populas_city_Continent) {
        this.ID_Continent = ID_Continent;
        Continent_Continent = continent_Continent;
        Density_People_Per_Km_Continent = density_People_Per_Km_Continent;
        Population_Continent = population_Continent;
        Density_People_Per_Mile_Continent = density_People_Per_Mile_Continent;
        Most_Populas_city_Continent = most_Populas_city_Continent;
    }

    public CountryItems(int ID, String countryName, String continent,String capital, int population,
                        int GDP, String currency_Type, int size, int phone_Code, int flag, int currency_Symbol) {
        this.ID = ID;
        this.countryName = countryName;
        Continent = continent;
        Capital = capital;
        Population = population;
        this.GDP = GDP;
        Currency_Type = currency_Type;
        Size = size;
        Phone_Code = phone_Code;
        Flag = flag;
        Currency_Symbol = currency_Symbol;
    }
    public CountryItems(int ID, String countryName, String continent, int population,
                        int GDP, String currency_Type, int size, int phone_Code, int flag) {
        this.ID = ID;
        this.countryName = countryName;
        Continent = continent;
        Population = population;
        this.GDP = GDP;
        Currency_Type = currency_Type;
        Size = size;
        Phone_Code = phone_Code;
        Flag = flag;
    }


    public String getCountryName() {
        return countryName;
    }
}
