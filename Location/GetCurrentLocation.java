package com.rovitracker.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.os.Looper;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;

public class GetCurrentLocation {

    private Context context;
    private FusedLocationProviderClient fusedLocationClient;
    private LocationRequest locationRequest;
    private LocationCallback locationCallback;
    String TAG = getClass().getSimpleName();
    LocationInterface locationInterface;

    public GetCurrentLocation(Context context) {
        this.context = context;
        locationInterface = (LocationInterface) context;
        initLocation();
    }

    @SuppressLint("MissingPermission")
    private void initLocation() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context);
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                Location location = locationResult.getLastLocation();
                if (location != null) {
                    locationInterface.updateCurrentLocation(location);
                    fusedLocationClient.removeLocationUpdates(locationCallback);
                }
            }
        };
        locationRequest = new LocationRequest();
        locationRequest.setFastestInterval(1000l);
        locationRequest.setInterval(1000l);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(locationRequest);

        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.getMainLooper());
    }

}
