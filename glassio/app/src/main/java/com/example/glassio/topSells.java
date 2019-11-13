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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class topSells extends Fragment {

    private Button priceBtn;
    private CustomAdapter adapter;
    private ArrayList<ListViewData> data;



    private ArrayList<ListViewData> listoItems;
    public topSells() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_sells, container, false);

        ListView listView = view.findViewById(R.id.list);
        listView.hasExplicitFocusable();
        // A LIST OF THE GLASSES NEEDED
       data = new ArrayList<>();

        data.add(new ListViewData("Pinkus Stylush", R.drawable.glassesone, 70.99));
        data.add(new ListViewData("Shades IV", R.drawable.glasseseight, 60.99));
        data.add(new ListViewData("name 3 ", R.drawable.glassesseven, 200.69));
        data.add(new ListViewData("name 4 ", R.drawable.glassesfive, 420.69));
        data.add(new ListViewData("name 5", R.drawable.glassesfour, 25.99));
        data.add(new ListViewData("name 6", R.drawable.glassesten, 40.99));
        data.add(new ListViewData("name 7", R.drawable.glasseseleven, 100.99));
        data.add(new ListViewData("name 8", R.drawable.glassestwo, 55.99));
        data.add(new ListViewData("name 9", R.drawable.glassesthree, 100.99));
        data.add(new ListViewData("name 10", R.drawable.glassestwelve, 40.75));
        data.add(new ListViewData("name 11", R.drawable.glassesnine, 55.99));


        priceBtn = view.findViewById(R.id.sort);
        priceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortArrayList();
            }
        });


        //CONNECTING  THE LIST VIEW TO THE CUSTOM VIEW ADAPTER THAT WILL BE MADE BELLOW
         adapter = new CustomAdapter(getContext(), data);
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


    public void sortArrayList(){
        Collections.sort(data, new Comparator<ListViewData>() {
            @Override
            public int compare(ListViewData o1, ListViewData t1) {
                return o1.getPrice().compareTo(t1.getPrice());
            }

        });


        adapter.notifyDataSetChanged();
    }



}
