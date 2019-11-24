package com.example.glassio;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPagerAdapter extends Fragment {

    private static final String Param = "param";
    private static final String Param2 = "param2";


    private int mParam;
    private String mParam2;


    public ViewPagerAdapter() {
        // Required empty public constructor
    }

    public static ViewPagerAdapter newInstance(String placeHolder, int img) {
        ViewPagerAdapter fragment = new ViewPagerAdapter();
        Bundle args = new Bundle();
        args.putString(Param2, placeHolder);
        args.putInt(Param, img);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pager_adapter, container, false);

        ImageView imgV = view.findViewById(R.id.image);
        if (mParam2 != null) {
            imgV.setImageResource(mParam);
        }

        return view;
    }

}
