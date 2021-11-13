package com.example.citysights;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener, GoogleMap.OnMarkerDragListener {

    private static final String TAG = "MyActivity";
    private EditText mSearchText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps_fragment);
        mapFragment.getMapAsync(this);
        mSearchText = (EditText) findViewById(R.id.input_search);
    }

    private void init(){
        Log.d(TAG, "initializing");
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        LatLng location = new LatLng(42.320671,-83.027206);
        MarkerOptions options = new MarkerOptions();
        options.position(location);
        options.title("University of Windsor");
        options.snippet("This is University of Windsor");
        options.draggable(true);


        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 18f));
        googleMap.addMarker(options);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public boolean onMarkerClick(@NonNull Marker marker) {
        Log.d("MapsActivity", marker.getTitle());
        return true;
    }

    @Override
    public void onMarkerDrag(@NonNull Marker marker) {
        Log.d("MapsActivity", marker.getPosition().toString());
    }

    @Override
    public void onMarkerDragStart(@NonNull Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(@NonNull Marker marker) {

    }

}