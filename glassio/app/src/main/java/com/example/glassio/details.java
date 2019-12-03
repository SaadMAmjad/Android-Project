package com.example.glassio;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * @author Yonis Sheekh
 * @date 2019/12/01
 */
public class details extends Fragment {
    private Button button;

    // toast info


    public static  ArrayList<ListViewData> dataWish = new ArrayList<>();


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
        View view = inflater.inflate(R.layout.fragment_details, container, false);


        if(getArguments() != null) {

              final ListViewData data = (ListViewData) getArguments().getSerializable("data");
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
            button = view.findViewById(R.id.buttonDetail);

            button.setOnClickListener(new View.OnClickListener() {
                /**
                 *
                 * @param view
                 */
                @Override
                public void onClick(View view) {
                    dataWish.add(new ListViewData(data.getName(),data.getImage(),data.getPrice(),data.getFrame(),data.getColorr(),data.getType()));
                    Context context = getContext();
                    CharSequence text = "this Item has been added to your wish list";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            });
        }
            return view;
    }



}
