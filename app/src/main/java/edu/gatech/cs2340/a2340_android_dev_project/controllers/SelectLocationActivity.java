package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;

/**
 * Activity that opens a GoogleMap and listens for a tap, then registers a new report
 * with that location saved as a LatLng.
 */
public class SelectLocationActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private static LatLng location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_location);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng point) {
                location = point;
                onBackPressed();
            }
        });
    }

    /**
     * Returns the location attribute of the class,
     * typically the location just selected by the
     * user within the map.
     *
     * @return the last tapped LatLng on the map
     */
    public static LatLng getLocation() {
        return location;
    }

}
