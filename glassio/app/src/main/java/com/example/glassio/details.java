package com.example.glassio;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class details extends Fragment {
    private Button button;
    public static  ArrayList<ListViewData> dataWish;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        if(getArguments() != null) {
            dataWish = new ArrayList<>();
              final ListViewData data = (ListViewData) getArguments().getSerializable("data");
               final Integer image = data.getImage();
               final String nameDetail = data.getName();
               final String frameDetail = data.getFrame();
               final String colorDetail = data.getColorr();
               final String typeDetail = data.getType();
               final Double priceDetail = data.getPrice();

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

            button = view.findViewById(R.id.buttonDetail);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle args = new Bundle();
                    args.putSerializable("info", dataWish);
                    dataWish.add(new ListViewData(nameDetail,image,priceDetail,frameDetail,colorDetail,typeDetail));
                }
            });
        }

            return view;
    }



}
