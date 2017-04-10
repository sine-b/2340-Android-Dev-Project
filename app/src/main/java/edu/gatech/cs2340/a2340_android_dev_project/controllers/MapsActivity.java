package edu.gatech.cs2340.a2340_android_dev_project.controllers;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import edu.gatech.cs2340.a2340_android_dev_project.model.Report;

/**
 * Activity that displays a GoogleMap, with markers placed automatically at all
 * reports in the reportList.
 */
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // populate map with nearby water reports
        for (Report report : MainActivity.getReportList().getReportList()) {
            LatLng latLng = new LatLng(report.getLocation().getLatitude(),
                    report.getLocation().getLongitude());
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latLng);
            markerOptions.title("" + report.getId());
            mMap.addMarker(markerOptions);
        }

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (marker == null) {
                    return false;
                }

                ReportDetailsActivity.setReport(MainActivity.getReportList().getReportList()
                        .get(Integer.parseInt(marker.getTitle())));
                onMarkerPressed();

                return true;
            }
        });
    }

    /**
     * Function for a map marker's onClick method.
     * Opens the ReportDetailsActivity which details
     * the report associated with the marker.
     */
    public void onMarkerPressed() {
        Intent intent = new Intent(this, ReportDetailsActivity.class);
        startActivity(intent);
    }
}
