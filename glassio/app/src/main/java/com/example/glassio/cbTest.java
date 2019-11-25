package com.example.glassio;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class cbTest extends Fragment {

    private Button failed;

    public cbTest() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cb_test
                , container, false);
        ViewPager pager = view.findViewById(R.id.vp);
        CustomViewPagerAdapter adapter =
                new CustomViewPagerAdapter(getChildFragmentManager());
        pager.setAdapter(adapter);

        failed = view.findViewById(R.id.cantSee);
        failed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code to switch screens here
            }
        });

        return view;
    }

    public class CustomViewPagerAdapter extends FragmentPagerAdapter {

        public CustomViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0: return com.example.glassio.ViewPagerAdapter.newInstance("Do you see it?", R.drawable.cbfourtytwo);
                case 1: return com.example.glassio.ViewPagerAdapter.newInstance("It is the number 42", R.drawable.cbfourtytwo);
                case 2: return com.example.glassio.ViewPagerAdapter.newInstance("Do you see it?", R.drawable.cbseventyfour);
                case 3: return com.example.glassio.ViewPagerAdapter.newInstance("It is the number 74", R.drawable.cbseventyfour);
                case 4: return com.example.glassio.ViewPagerAdapter.newInstance("Do you see it?", R.drawable.cbsix);
                case 5: return com.example.glassio.ViewPagerAdapter.newInstance("It is the number 6", R.drawable.cbsix);
                case 6: return com.example.glassio.ViewPagerAdapter.newInstance("Do you see it?", R.drawable.cbtwelve);
                case 7: return com.example.glassio.ViewPagerAdapter.newInstance("It is the number 12", R.drawable.cbtwelve);
                case 8: return com.example.glassio.ViewPagerAdapter.newInstance("Do you see it?", R.drawable.cbtwo);
                case 9: return com.example.glassio.ViewPagerAdapter.newInstance("It is the number 2", R.drawable.cbtwo);
                case 10: return com.example.glassio.ViewPagerAdapter.newInstance("Do you see it?", R.drawable.cbw);
                case 11: return com.example.glassio.ViewPagerAdapter.newInstance("It is the letter W", R.drawable.cbw);
                default: return com.example.glassio.ViewPagerAdapter.newInstance("testing", 0);
            }
        }

        @Override
        public int getCount() {
            return 12;
        }
    }

}
