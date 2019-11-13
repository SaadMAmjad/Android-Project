package com.example.glassio;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class topSells extends Fragment {


    ListView listView;
    public topSells() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_sells, container, false);

        listView = view.findViewById(R.id.list);


        // A LIST OF THE GLASSES NEEDED FOR PRICE FRAGMENT
        final ArrayList<ListViewData> data = new ArrayList<>();
        data.add(new ListViewData("Pinkus Perfection", R.drawable.glassesseven, 100.99));
        data.add(new ListViewData("Shades IV", R.drawable.glassesone, 70.99));

        //CONNECTING  THE LIST VIEW TO THE CUSTOM VIEW ADAPTER THAT WILL BE MADE BELLOW
        CustomAdapter adapter =
                new CustomAdapter(getContext(), data);
        listView.setAdapter(adapter);


        return view;
    }

    //CREATING A CUSTOM VIEW ADAPTER FOR THE LIST OF GLASSES

    public class CustomAdapter extends ArrayAdapter<ListViewData> {
        public CustomAdapter(@NonNull Context context, ArrayList<ListViewData> items) {
            super(context, 0, items);

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ListViewData item = getItem(position);

            if (convertView == null){
                convertView = LayoutInflater.
                        from(getContext()).inflate(R.layout.list_item, parent, false);
            }
            TextView name = convertView.findViewById(R.id.name);
            TextView price = convertView.findViewById(R.id.price);
            ImageView image = convertView.findViewById(R.id.image);
            name.setText(item.getName());
            price.setText(item.getPrice().toString());
            image.setImageResource(item.getImage());
            return  convertView;
        }
    }

}
