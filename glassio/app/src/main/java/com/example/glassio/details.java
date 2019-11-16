package com.example.glassio;


import android.os.Bundle;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
        ListViewData item = new ListViewData();

//        Integer image = item.getImage();
//        String nameDetail = item.getName();
//        String frameDetail = item.getFrame();
//        String colorDetail = item.getColorr();
//        String typeDetail = item.getType();
//        Double priceDetail = item.getPrice();
//
//        ImageView imag = view.findViewById(R.id.imageDetail);
//        imag.setImageResource(image);
//        TextView name = view.findViewById(R.id.nameDetail);
//        name.setText(nameDetail);
//        TextView frame = view.findViewById(R.id.frameDetail);
//        frame.setText(frameDetail);
//        TextView color = view.findViewById(R.id.color);
//        color.setText(colorDetail);
//        TextView type = view.findViewById(R.id.typeDetail);
//        type.setText(typeDetail);
//        TextView price = view.findViewById(R.id.priceDetail);
//        price.setText(String.valueOf(priceDetail));
        {







            return view;

        }
    }
}
