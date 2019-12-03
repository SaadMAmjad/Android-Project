package com.example.glassio;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * @author Saad Amjad
 * @description viewpager adapter class, contains an image (the colorblind tests) and text (to ask if you can see it)
 * @date 2019/12/01
 */
public class ViewPagerAdapter extends Fragment {



    private static final String Param = "img";
    private static final String Param2 = "placeholderText";


    private int mParam;
    private String mParam2;


    public ViewPagerAdapter() {
        // Required empty public constructor
    }

    /**
     *
     * @param placeHolder
     * @param img
     * @return fragment
     */
    public static ViewPagerAdapter newInstance(String placeHolder, int img) {
        ViewPagerAdapter fragment = new ViewPagerAdapter();
        Bundle args = new Bundle();
        args.putString(Param2, placeHolder);
        args.putInt(Param, img);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam = getArguments().getInt(Param);
            mParam2 = getArguments().getString(Param2);
        }
    }

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return view
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_view_pager_adapter, container, false);

        ImageView imgV = view.findViewById(R.id.stuff);
        TextView textV = view.findViewById(R.id.answer);
        if (mParam2 != null) {
            imgV.setImageResource(mParam);
            textV.setText(mParam2);
        }

        return view;
    }

}
