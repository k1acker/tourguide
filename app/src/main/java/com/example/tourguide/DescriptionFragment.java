package com.example.tourguide;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class DescriptionFragment extends Fragment {

    private static final String ARG_CITY_NAME = "cityName";
    private static final String ARG_DESCRIPTION = "description";
    private String cityName;
    private String description;


    public DescriptionFragment() {
        // Required empty public constructor
    }

    public static DescriptionFragment newInstance(String cityName, String description) {
        DescriptionFragment fragment = new DescriptionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CITY_NAME, cityName);
        args.putString(ARG_DESCRIPTION, description);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            cityName = getArguments().getString(ARG_CITY_NAME);
            description = getArguments().getString(ARG_DESCRIPTION);
        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_description, container, false);
        TextView cityDescriptionTextView = view.findViewById(R.id.cityDescriptionTextView);
        if (description != null) {
            cityDescriptionTextView.setText(description);
        }
        return view;
    }

}

