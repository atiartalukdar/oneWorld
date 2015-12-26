package customAdepter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.oneworld.talukdar.oneworld.R;

import java.util.List;

/**
 * Created by Talukdar on 12/22/2015.
 */
public class CountryAdepter extends ArrayAdapter<CountryItems> {
    public CountryAdepter(Context context, List<CountryItems> objects) {
        super(context, 0, objects);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        final Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_list, null, false);

        TextView nameTextView = (TextView)view.findViewById(R.id.item_name);
        TextView nickTextView = (TextView)view.findViewById(R.id.item_nick);
       // ImageView imageView = (ImageView)view.findViewById(R.id.item_image);

        CountryItems countryItems = getItem(position);

        nameTextView.setText(countryItems.countryName);
        nickTextView.setText(countryItems.Capital);
        //imageView.setImageResource(countryItems.Flag);
        return view;
    }

}
