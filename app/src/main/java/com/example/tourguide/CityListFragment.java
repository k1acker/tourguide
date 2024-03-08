package com.example.tourguide;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class CityListFragment extends Fragment {

    private OnCitySelectedListener listener;
    private TextView welcomeMessageTextView;


    public interface OnCitySelectedListener {
        void onCitySelectedWithDescription(String cityName, String description);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_city_list, container, false);
        ListView cityListView = view.findViewById(R.id.cityListView);
        String[] cityNames = getResources().getStringArray(R.array.city_names);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, cityNames);
        cityListView.setAdapter(adapter);

        cityListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCity = cityNames[position];
                String[] cityDescriptions = getResources().getStringArray(R.array.city_descriptions);
                String selectedDescription = cityDescriptions[position];
                listener.onCitySelectedWithDescription(selectedCity, selectedDescription);
                // Hide the welcome message
                welcomeMessageTextView.setVisibility(View.GONE);
            }
        });


        // Initialize the welcome message TextView
        welcomeMessageTextView = getActivity().findViewById(R.id.welcomeMessageTextView);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCitySelectedListener) {
            listener = (OnCitySelectedListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnCitySelectedListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}

