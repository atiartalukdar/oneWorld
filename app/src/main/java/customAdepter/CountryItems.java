package customAdepter;

/**
 * Created by Talukdar on 12/22/2015.
 */


public class CountryItems {
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
}
