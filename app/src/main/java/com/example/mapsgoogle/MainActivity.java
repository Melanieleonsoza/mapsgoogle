package com.example.mapsgoogle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback,GoogleMap.OnMapClickListener {
    GoogleMap mapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment) //referencia del mapa
                getSupportFragmentManager()
                        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);//con esta referencia se conecta a google
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mapa =googleMap;
        //Personalizacion del mapa
        mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);//vista satelital
        mapa.getUiSettings().setZoomControlsEnabled(true);//-1.0125144372407424, -79.46947741875589
        CameraUpdate camUpd1 =
               CameraUpdateFactory
                        .newLatLngZoom(new LatLng(-1.0125144372407424, -79.46947741875589), 15);
        mapa.moveCamera(camUpd1);

        //VISION 3D de arriba
        /*LatLng madrid = new LatLng(40.417325, -3.683081);

        CameraPosition camPos = new CameraPosition.Builder()
                .target(madrid)
                .zoom(19)
                .bearing(90) //noreste arriba
                .tilt(70) //punto de vista de la cámara 70 grados
                .build();
        CameraUpdate camUpd3 =
                CameraUpdateFactory.newCameraPosition(camPos);
        mapa.animateCamera(camUpd3);*/
        mapa.setOnMapClickListener(this);
        PolylineOptions lineas = new
                PolylineOptions()
                .add(new LatLng(-1.0126002545247679, -79.46707415952389))
                .add(new LatLng(-1.0120960779486459, -79.47114038831374))
                .add(new LatLng(-1.012686071806516, -79.47185922031616))
                .add(new LatLng(-1.012964977956486, -79.47086143858145))
                .add(new LatLng(-1.0134047914518987, -79.46916628251603))
                .add(new LatLng(-1.0134155186095728, -79.46718144788245))
                .add(new LatLng(-1.0126002545247679, -79.46707415952389));
        lineas.width(8);
        lineas.color(Color.RED);
        mapa.addPolyline(lineas);

    }
//este captura el marcador es decir donde se selecciona
    @Override
    public void onMapClick(@NonNull LatLng latLng) {
       // LatLng punto = new LatLng(latLng.latitude,
               // latLng.longitude);
                mapa.addMarker(new MarkerOptions().position(latLng).title("Punto"));
    }
}