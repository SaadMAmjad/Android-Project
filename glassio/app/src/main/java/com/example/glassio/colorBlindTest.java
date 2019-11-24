package com.example.glassio;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class colorBlindTest extends Fragment {


    public colorBlindTest() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_color_blind_test, container, false);
        ViewPager pager = view.findViewById(R.id.vp);
        CustomViewPagerAdapter adapter =
                new CustomViewPagerAdapter(getChildFragmentManager());
        pager.setAdapter(adapter);
        return view;
    }

    public class CustomViewPagerAdapter extends FragmentPagerAdapter {

        public CustomViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            //Case 0: First Screen (First Fact)
            switch (position){
                case 0: return com.example.glassio.ViewPagerAdapter.newInstance("testing", R.drawable.cbfourtytwo);
                case 1: return com.example.glassio.ViewPagerAdapter.newInstance("testing", R.drawable.cbseventyfour);
                case 2: return com.example.glassio.ViewPagerAdapter.newInstance("testing", R.drawable.cbsix);
                case 3: return com.example.glassio.ViewPagerAdapter.newInstance("testing", R.drawable.cbtwelve);
                case 4: return com.example.glassio.ViewPagerAdapter.newInstance("testing", R.drawable.cbtwo);
                case 5: return com.example.glassio.ViewPagerAdapter.newInstance("testing", R.drawable.cbw);
                default: return com.example.glassio.ViewPagerAdapter.newInstance("testing", 0);
            }
        }

        @Override
        public int getCount() {
            return 6;
        }
    }
}
