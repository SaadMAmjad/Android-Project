package com.example.glassio;


import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * A simple {@link Fragment} subclass.
 */
public class topSells extends Fragment {

    private Button priceBtn;
    private Button priceBtn2;
    private CustomAdapter adapter;
    private ArrayList<ListViewData> data;




    public topSells() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_sells, container, false);

         final ListView listView = view.findViewById(R.id.list);
        // A LIST OF THE GLASSES NEEDED

       data = new ArrayList<>();
        data.add(new ListViewData("Pinkus Stylush", R.drawable.glassesone, 70.99,"asdasas","color1","type1"));
        data.add(new ListViewData("Shades IV", R.drawable.glasseseight, 60.99,"q","color2","type2"));
        data.add(new ListViewData("name 3 ", R.drawable.glassesseven, 200.69,"wqqwer","color3","type3"));
        data.add(new ListViewData("name 4 ", R.drawable.glassesfive, 420.69,"qwe","color4","type4"));
        data.add(new ListViewData("name 5", R.drawable.glassesfour, 25.99,"qwewe","color5","type5"));
        data.add(new ListViewData("name 6", R.drawable.glassesten, 40.99,"asdasdasd","color6","type6"));
        data.add(new ListViewData("name 7", R.drawable.glasseseleven, 100.99,"asdasqwesdq","color7","type7"));
        data.add(new ListViewData("name 8", R.drawable.glassestwo, 55.99,"qweqsdq","color8","type8"));
        data.add(new ListViewData("name 9", R.drawable.glassesthree, 100.99,"Plasqweqwetic","color9","type9"));
        data.add(new ListViewData("name 10", R.drawable.glassestwelve, 40.75,"a","color10","type10"));
        data.add(new ListViewData("name 11", R.drawable.glassesnine, 55.99,"asdqw","color11","type11"));


        priceBtn = view.findViewById(R.id.sort);
        priceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sortArrayList();
            }
        });


        priceBtn2 = view.findViewById(R.id.sort2);
        priceBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reversed();
            }
        });



        //CONNECTING  THE LIST VIEW TO THE CUSTOM VIEW ADAPTER THAT WILL BE MADE BELLOW
         adapter = new CustomAdapter(getContext(), data);
        listView.setAdapter(adapter);





               listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Navigation.findNavController(view).navigate(R.id.action_nav_topSells_to_details);
           }
       });


        return view;
    }

    //CREATING A CUSTOM VIEW ADAPTER FOR THE LIST OF GLASSES

    public class CustomAdapter extends ArrayAdapter<ListViewData> {
        private CustomAdapter(@NonNull Context context, ArrayList<ListViewData> items) {
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
            TextView frameMat = convertView.findViewById(R.id.frame);
            TextView type = convertView.findViewById(R.id.type);
            TextView color = convertView.findViewById(R.id.color);
            frameMat.setText(item.getFrame());
            color.setText(item.getColorr());
            type.setText(item.getType());
            ImageView image = convertView.findViewById(R.id.image);
            name.setText(item.getName());
            price.setText(item.getPrice().toString());
            image.setImageResource(item.getImage());
            return  convertView;
        }
    }





    //THIS FUNCTION COMPARES THE ITEMS IN THE LIST AND SORTS THEM ACCORDING TO THE PRICE FROM LOWEST TO HIGHEST
    private void sortArrayList(){
            Collections.sort(data, new Comparator<ListViewData>() {
                @Override
                public int compare(ListViewData o1, ListViewData t1) {
                        return o1.getPrice().compareTo(t1.getPrice());
                }
            });
        adapter.notifyDataSetChanged();
    }


    //AFTER HOURS OF BEING AWAKE LAST NIGHT WE FINALLY GOT THE COLLECTION TO REVERSE FROM HIGHEST TO LOWEST
    //PS ANDROID DOCS READ MORE OF THEM
    private void reversed(){
        Collections.reverse(data);
        adapter.notifyDataSetChanged();
    }



}
