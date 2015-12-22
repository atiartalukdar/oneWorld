package database;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Talukdar on 12/23/2015.
 */
public class Message {
    public static void Message(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
