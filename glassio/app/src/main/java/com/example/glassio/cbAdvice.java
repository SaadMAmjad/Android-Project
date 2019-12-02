package com.example.glassio;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * @author Saad Amjad
 * @description simple destination with button to link to EnChroma website
 * @param Button link
 * @return view
 * @date 2019/12/01
 */
public class cbAdvice extends Fragment {

    private Button link;


    public cbAdvice() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cb_advice, container, false);

        link = view.findViewById(R.id.cbAdvice_link);
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://enchroma.com/"));
                startActivity(browserIntent);
            }
        });

        return view;
    }

}
