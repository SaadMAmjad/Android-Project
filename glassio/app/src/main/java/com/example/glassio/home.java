package com.example.glassio;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class home extends Fragment {


    public home() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ArrayList<ListViewData> items = new ArrayList<>();
        items.add(new ListViewData("On the Range", R.drawable.glassesseven, 29.99,"Plastic","Pink","Safety/Utility"));
        items.add(new ListViewData("Magnifier", R.drawable.glasseseight, 199.99,"Metal","Clear","Prescription"));
        items.add(new ListViewData("The Aviator", R.drawable.glassesone, 119.99,"Metal","Black","Sunglasses"));
        items.add(new ListViewData("Down the Mountain", R.drawable.glassestwelve, 59.99,"Plastic","Light Black","Ski Goggles"));
        items.add(new ListViewData("The Adapter", R.drawable.glassesten, 239.99,"Metal","Light Green","Transformer Prescription"));


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

        return view;
    }

}
