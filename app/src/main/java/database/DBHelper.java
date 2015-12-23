package database;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Talukdar on 12/23/2015.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "Country_Details";
    private static final String TABLE_NAME = "Asia";
    private static final int VERSION_CODE = 3;
    private static final String UID = "_id";
    private  static final String NAME = "Name";
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+" ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255));";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS  "+TABLE_NAME;
    private Context context;
    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_CODE);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //CREATE TABLE ASIA (_id INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR(255);
        try {
            Message.message(context,"onCreate is Called");
            db.execSQL(CREATE_TABLE);
        } catch (SQLException e) {
            Message.message(context,""+e);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            Message.message(context,"onUpgrade is Called");
            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (SQLException e) {
            Message.message(context, "" + e);
        }
    }
}
