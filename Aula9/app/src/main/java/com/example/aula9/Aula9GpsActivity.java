package com.example.aula9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Aula9GpsActivity extends AppCompatActivity implements LocationListener {

    LocationManager locationManager;
    private TextView txtLat, txtLong, txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aula9_gps);
        txtLat = findViewById(R.id.txtLat);
        txtLong = findViewById(R.id.txtLong);
        txtStatus = findViewById(R.id.txtStatus);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        long tempo = 0;
        float distancia = 0;

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this,"Permita uso da localização nas configurações do dispositivo",Toast.LENGTH_LONG).show();
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, tempo, distancia, this);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,tempo,distancia,this);
    }

    @Override
    public void onLocationChanged(Location location) {
        txtLat.setText("Latitude ="+ location.getLatitude());
        txtLong.setText("Longitude ="+ location.getLongitude());
        txtStatus.setText("Provider ="+ location.getProvider());
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
