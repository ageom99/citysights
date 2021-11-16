package com.example.citysights;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps_fragment);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng location = new LatLng(42.320671,-83.027206);
        MarkerOptions options = new MarkerOptions();
        options.position(location);
        options.title("University of Windsor");
        options.snippet("This is a snippet");

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 18f));
        googleMap.addMarker(options);


    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}