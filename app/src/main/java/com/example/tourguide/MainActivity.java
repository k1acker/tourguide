package com.example.tourguide;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements CityListFragment.OnCitySelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CityListFragment cityListFragment = new CityListFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.list_fragment_container, cityListFragment)
                .commit();
    }

    @Override
    public void onCitySelectedWithDescription(String cityName, String description) {
        DescriptionFragment descriptionFragment = DescriptionFragment.newInstance(cityName, description);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.description_fragment_container, descriptionFragment)
                .addToBackStack(null) // So back button works as expected
                .commit();
    }

}
