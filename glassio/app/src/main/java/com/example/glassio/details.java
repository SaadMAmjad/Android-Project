package com.example.glassio;


import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Debug;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.ls.LSException;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class details extends Fragment {


    private ArrayList<topSells> data;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
//        ListViewData item = new ListViewData();



        if(getArguments() != null) {
            ListViewData data = (ListViewData) getArguments().getSerializable("data");

            Integer image = data.getImage();
            String nameDetail = data.getName();
            String frameDetail = data.getFrame();
            String colorDetail = data.getColorr();
            String typeDetail = data.getType();
            Double priceDetail = data.getPrice();

            ImageView imag = view.findViewById(R.id.imageDetail);
            imag.setImageResource(image);
            TextView name = view.findViewById(R.id.nameDetail);
            name.setText(nameDetail);
            TextView frame = view.findViewById(R.id.frameDetail);
            frame.setText(frameDetail);
            TextView color = view.findViewById(R.id.colorDetail);
            color.setText(colorDetail);
            TextView type = view.findViewById(R.id.typeDetail);
            type.setText(typeDetail);
            TextView price = view.findViewById(R.id.priceDetail);
            price.setText(String.valueOf(priceDetail));
        }
            return view;
    }
}
