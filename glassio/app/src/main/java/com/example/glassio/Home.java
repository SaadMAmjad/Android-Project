package com.example.glassio;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * @author Saad Amjad
 * @description app start/Home screen, contains a randomized recycler view showing a random selection of glasses
 * @param ArrayList<ListViewData> items
 * @return view
 * @date 2019/12/01
 */
public class Home extends Fragment {

    private ArrayList<ListViewData> items;

    public Home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final   View view = inflater.inflate(R.layout.fragment_home, container, false);

        items = new ArrayList<>();

        items.add(new ListViewData("On the Range", R.drawable.glassesseven, 29.99,"Plastic","Pink","Safety/Utility"));
        items.add(new ListViewData("Magnifier", R.drawable.glasseseight, 199.99,"Metal","Clear","Prescription"));
        items.add(new ListViewData("The Aviator", R.drawable.glassesone, 119.99,"Metal","Black","Sunglasses"));
        items.add(new ListViewData("The Mountain", R.drawable.glassestwelve, 59.99,"Plastic","Light Black","Ski Goggles"));
        items.add(new ListViewData("The Adapter", R.drawable.glassesten, 239.99,"Metal","Light Green","Transformer"));
        items.add(new ListViewData("Shades V", R.drawable.glasseseleven, 49.99,"Plastic","Light Black","Sunglasses"));
        items.add(new ListViewData("Average Joe's", R.drawable.glassesfive, 79.99,"Plastic","Clear","Prescription"));
        items.add(new ListViewData("Blue Steel", R.drawable.glassesfour, 179.99,"Metal","Clear","Prescription"));
        items.add(new ListViewData("Angular", R.drawable.glassesnine, 149.99,"Metal","Clear","Prescription"));
        items.add(new ListViewData("Minimalist", R.drawable.glassesthree, 99.99,"Plastic","Clear","Prescription"));
        items.add(new ListViewData("The Illusion", R.drawable.glassestwo, 89.99,"Plastic","Clear","Prescription"));

        Collections.shuffle(items, new Random());

        for (int i = 0; i <= 11; i++) {
            if (i > 5) {
                items.remove(items.size()-1);
            }
        }
        RecyclerView recyclerView = view.findViewById(R.id.recycle);

         LinearLayoutManager manager = new LinearLayoutManager(getContext());
         manager.setOrientation(RecyclerView.HORIZONTAL);
         recyclerView.setLayoutManager(manager);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),
                1));
          recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1,
                 LinearLayoutManager.HORIZONTAL));
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CustomRecyclerViewAdapter adapter = new CustomRecyclerViewAdapter(items);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new CustomRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Bundle args = new Bundle();
                args.putSerializable("data", items.get(position));
                Navigation.findNavController(view).navigate(R.id.action_nav_home_to_details, args);
            }
        });
        
        return view;
    }

}
