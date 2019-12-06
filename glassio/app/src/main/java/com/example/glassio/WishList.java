package com.example.glassio;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * @author Yonis Sheekh
 * @date 2019/12/01
 */
public class WishList extends Fragment {

    private CustomAdapter adapter;
    public WishList() {
        // Required empty public constructor
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
        View view = inflater.inflate(R.layout.fragment_wish_list, container, false);
        ListView listView = view.findViewById(R.id.wishList);

        adapter = new CustomAdapter(getContext(), Details.dataWish);


        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(final AdapterView<?> adapterView, View view, int position, long id) {
                final int deletedItem = position;
                        new AlertDialog.Builder(getContext())
                                .setTitle("DELETE ITEM")
                                .setMessage("Do you want to delete this item " +
                                        "from the list")
                                .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        Details.dataWish.remove(deletedItem);
                                        adapter.notifyDataSetChanged();
                                    }
                                })
                                .setNegativeButton("No",null)
                                .show();
                        return true;
            }
        });

        return view;
        }

    public static class CustomAdapter extends ArrayAdapter<ListViewData> {
        private CustomAdapter(@NonNull Context context, ArrayList<ListViewData> items) {
            super(context, 0, items);

        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ListViewData item = getItem(position);
            if (convertView == null){
                convertView = LayoutInflater.
                        from(getContext()).inflate(R.layout.list_item, parent, false);
            }
            TextView name = convertView.findViewById(R.id.name);
            TextView price = convertView.findViewById(R.id.price);
            TextView frameMat = convertView.findViewById(R.id.frame);
            TextView type = convertView.findViewById(R.id.type);
            TextView color = convertView.findViewById(R.id.color);
            frameMat.setText(item.getFrame());
            color.setText(item.getColorr());
            type.setText(item.getType());
            ImageView image = convertView.findViewById(R.id.image);
            name.setText(item.getName());
            price.setText(item.getPrice().toString());
            image.setImageResource(item.getImage());
            return  convertView;
        }
    }
}
