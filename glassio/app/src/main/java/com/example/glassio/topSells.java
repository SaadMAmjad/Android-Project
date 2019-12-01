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


public class topSells extends Fragment {

    private Button priceBtn;
    private Button priceBtn2;
    private CustomAdapter adapter;
    private ArrayList<ListViewData> data;


    public topSells() {
    }

    /**
     * @author yonis sheekh
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return view
     *@date   2019/11/13
     * this class is for the sales class
     * will show a collection of glasses
     * has two methods at the bottom
     * will sort the glasses in ascending and descending order
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_sells, container, false);

          ListView listView = view.findViewById(R.id.list);
        // A LIST OF THE GLASSES NEEDED

        data = new ArrayList<>();
        data.add(new ListViewData("The Aviator", R.drawable.glassesone, 119.99,"Metal","Black","Sunglasses"));
        data.add(new ListViewData("Magnifier", R.drawable.glasseseight, 199.99,"Metal","Clear","Prescription"));
        data.add(new ListViewData("On the Range", R.drawable.glassesseven, 29.99,"Plastic","Pink","Safety/Utility"));
        data.add(new ListViewData("Average Joe's", R.drawable.glassesfive, 79.99,"Plastic","Clear","Prescription"));
        data.add(new ListViewData("Blue Steel", R.drawable.glassesfour, 179.99,"Metal","Clear","Prescription"));
        data.add(new ListViewData("The Adapter", R.drawable.glassesten, 239.99,"Metal","Light Green","Transformer"));
        data.add(new ListViewData("Shades V", R.drawable.glasseseleven, 49.99,"Plastic","Light Black","Sunglasses"));
        data.add(new ListViewData("The Illusion", R.drawable.glassestwo, 89.99,"Plastic","Clear","Prescription"));
        data.add(new ListViewData("Minimalist", R.drawable.glassesthree, 99.99,"Plastic","Clear","Prescription"));
        data.add(new ListViewData("The Mountain", R.drawable.glassestwelve, 59.99,"Plastic","Light Black","Ski Goggles"));
        data.add(new ListViewData("Angular", R.drawable.glassesnine, 149.99,"Metal","Clear","Prescription"));

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

         adapter = new CustomAdapter(getContext(), data);
        listView.setAdapter(adapter);
               listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                   /**
                    *
                    * @param parent
                    * @param view
                    * @param position
                    * @param id
                    */
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Bundle args = new Bundle();
               args.putSerializable("data", data.get(position));
               Navigation.findNavController(view).navigate(R.id.action_nav_topSells_to_details, args);
           }
       });

        return view;
    }
    //CREATING A CUSTOM VIEW ADAPTER FOR THE LIST OF GLASSES

    public static class CustomAdapter extends ArrayAdapter<ListViewData> {
        protected CustomAdapter(@NonNull Context context, ArrayList<ListViewData> items) {
            super(context, 0, items);

        }
        /**
         * @return convertView
         * class for Custom listView Adapter adapter
         */
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

    /**
     * method to sort items
     */
    private void sortArrayList(){
            Collections.sort(data, new Comparator<ListViewData>() {
                @Override
                public int compare(ListViewData o1, ListViewData t1) {
                        return o1.getPrice().compareTo(t1.getPrice());
                }
            });
        adapter.notifyDataSetChanged();
    }

    /**
     * reverse the sorted items
     */
    //AFTER HOURS OF BEING AWAKE LAST NIGHT WE FINALLY GOT THE COLLECTION TO REVERSE
    //PS ANDROID DOCS READ MORE OF THEM
    private void reversed(){
        Collections.reverse(data);
        adapter.notifyDataSetChanged();
    }


}
