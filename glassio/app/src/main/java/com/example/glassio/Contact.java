package com.example.glassio;


import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Contact extends Fragment {


    private String [] email = {"yonis.sheekh01@stclairconnect.ca"};
    public static final int PERMISSION_LOCATION = 1;
    public Contact() {
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
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        Button emailButton = view.findViewById(R.id.email);

        emailButton.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param view
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(intent.EXTRA_EMAIL,email);
                startActivity(intent);
            }
        });


        Button phoneButton = view.findViewById(R.id.phone);
        phoneButton.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param view
             */
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:5190000000"));
                startActivity(intent);

            }
        });


        Button websiteButton = view.findViewById(R.id.twitter);
        websiteButton.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param view
             */
            @Override
            public void onClick(View view) {

                Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/yonisSheekh"));

                startActivity(appIntent);

            }
        });



        Button locationButton = view.findViewById(R.id.location);
        locationButton.setOnClickListener(new View.OnClickListener() {
            /**
             *
             * @param view
             */
            @Override
            public void onClick(View view) {

                if(ContextCompat.checkSelfPermission(getContext(),
                        Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {

                    if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                            Manifest.permission.ACCESS_FINE_LOCATION)) {

                        final AlertDialog alertDialog =
                                new AlertDialog.Builder(getContext())
                                        .setTitle("ACCESS LOCATION")
                                        .setMessage("we need to access your location" +
                                                " to provide accurate directions")
                                        .create();
                        alertDialog.setButton(
                                AlertDialog.BUTTON_NEUTRAL,
                                "OK",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        alertDialog.dismiss();
                                        ActivityCompat.requestPermissions(getActivity(),
                                                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                                PERMISSION_LOCATION);
                                    }
                                });
                        alertDialog.show();

                    } else {
                        ActivityCompat.requestPermissions(getActivity(),
                                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                PERMISSION_LOCATION);
                    }
                }else{
                    Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=42.295877,-83.073227"));

                    if(intent.resolveActivity(getActivity().getPackageManager()) != null){
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(getContext(), "No software installed to complete task", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        return view;
    }

}