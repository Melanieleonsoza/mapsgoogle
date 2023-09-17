package com.example.mapsgoogle;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMap();
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        setupMapFeatures();
    }

    @Override
    public void onMapClick(@NonNull LatLng point) {
    }

    private void initMap() {
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    private void setupMapFeatures() {
        LatLng location = new LatLng(-1.012728980447174, -79.46948814732474);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 15));
        mMap.getUiSettings().setZoomControlsEnabled(true);
//paseo shooping
        addMapMarker(new LatLng(-1.009763669659165, -79.46912348520597),
                "PASEO SHOPPING QUEVEDO", "CENTRO COMERCIAL", R.mipmap.ic_shopping);
        //unidad educativa quevedo
        addMapMarker(new LatLng(-1.010810448866629, -79.46844084056048),
                "UNIDAD EDUCATIVA QUEVEDO", "UNIDAD EDUCATIVA", R.mipmap.ic_schooll);
        //uvc
        addMapMarker(new LatLng(-1.0101990428305823, -79.46496479116361),
                "UVC", "DEPARTAMENTO POLICIAL", R.mipmap.ic_uvc);
        //gasolinera
        addMapMarker(new LatLng(-1.0153695338458328, -79.46752898291426),
                "LA CHIQUITA","GASOLINERA", R.mipmap.ic_gasolinera);
        //casa judicial
        addMapMarker(new LatLng(-1.0138140965502465, -79.4673465927074),
                "CASA JUDICIAL","DEPARTAMENTO POLICIAL", R.mipmap.ic_casajudicial);
        //toque marinero
        addMapMarker(new LatLng(-1.013095376978602, -79.46683160857508),
                "TOQUE MARINERO","RESTAURANTE", R.mipmap.ence);
        mMap.setInfoWindowAdapter(new MyInfoWindowAdapter(this));

    }

    private void addMapMarker(LatLng pos, String titleText, String detailText, int resourceIcon) {
        MarkerOptions marker = new MarkerOptions()
                .position(pos)
                .title(titleText)
                .snippet(detailText)
                .icon(BitmapDescriptorFactory.fromResource(resourceIcon));
        mMap.addMarker(marker);
    }
}
