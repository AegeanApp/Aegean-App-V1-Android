package com.example.george.test_aegean_app;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Spinner dropdown;
    private String val_list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        dropdown = (Spinner) findViewById(R.id.list1);
        String[] items = new String[]{"Κτίριο Εμπορικής Σχολής", "Γραμματεία Τμήματος Μαθηματικών", "Βιβλιοθήκη","Εργαστήριο Πολυμέσων","Κτίριο Λυμπέρη - Γραμματεία Τμήματος ΜΠΕΣ","Φοιτητική Λέσχη","Γραμματεία Τμήματος Στατιστικής","Κτίριο Προβατάρη","Αίθουσα Δήμου","Νέο Σχολικό","Μεσαίο Σχολικό Συγκρότημα","Κτήριο Παπανικολάου","Κτήριο Ψαθά"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        dropdown.setAdapter(adapter);

        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                loadClick();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                loadClick();
            }
        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        // mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Dialog("Η χρήση της τοποθεσίας σας δεν είναι ενεργή");
        }
        mMap.setMyLocationEnabled(true);//user's location

    }
    public void loadClick()//method for loading markers
    {
        val_list1 = (String) dropdown.getSelectedItem();
        mMap.clear();

        if(val_list1.equals("Κτίριο Εμπορικής Σχολής"))
        {
            LatLng sydney = new LatLng(37.794894, 26.706629);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Κτίριο Εμπορικής Σχολής"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        else if(val_list1.equals("Γραμματεία Τμήματος Μαθηματικών"))
        {
            LatLng sydney = new LatLng(37.790362, 26.705464);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Γραμματεία Τμήματος Μαθηματικών"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        else if(val_list1.equals("Βιβλιοθήκη"))
        {
            LatLng sydney = new LatLng(37.792066, 26.703158);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Βιβλιοθήκη"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        else if(val_list1.equals("Εργαστήριο Πολυμέσων"))
        {
            LatLng sydney = new LatLng(37.795572, 26.707423);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Εργαστήριο Πολυμέσων"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        else if(val_list1.equals("Κτίριο Λυμπέρη - Γραμματεία Τμήματος ΜΠΕΣ"))
        {
            LatLng sydney = new LatLng(37.796000, 26.704939);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Κτίριο Λυμπέρη - Γραμματεία Τμήματος ΜΠΕΣ"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        else if(val_list1.equals("Φοιτητική Λέσχη"))
        {
            LatLng sydney = new LatLng(37.790837, 26.697662);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Φοιτητική Λέσχη"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        else if(val_list1.equals("Γραμματεία Τμήματος Στατιστικής"))
        {
            LatLng sydney = new LatLng(37.794979, 26.707900);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Γραμματεία Τμήματος Στατιστικής"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        else if(val_list1.equals("Κτίριο Προβατάρη"))
        {
            LatLng sydney = new LatLng(37.794423, 26.684276);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Κτίριο Προβατάρη"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        else if(val_list1.equals("Αίθουσα Δήμου"))
        {
            LatLng sydney = new LatLng(37.791244, 26.704945);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Αίθουσα Δήμου"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        else if(val_list1.equals("Νέο Σχολικό"))
        {
            LatLng sydney = new LatLng(37.795555, 26.706495);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Νέο Σχολικό"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        else if(val_list1.equals("Μεσαίο Σχολικό Συγκρότημα"))
        {
            LatLng sydney = new LatLng(37.793974, 26.698884);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Μεσαίο Σχολικό Συγκρότημα"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        else if(val_list1.equals("Κτήριο Παπανικολάου"))
        {
            LatLng sydney = new LatLng(37.797204, 26.702308);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Κτήριο Παπανικολάου"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        else if(val_list1.equals("Κτήριο Ψαθά"))
        {
            LatLng sydney = new LatLng(37.797518, 26.702684);
            mMap.addMarker(new MarkerOptions().position(sydney).title("Κτήριο Ψαθά"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        }
        //View v=null;
        //locateClick(v);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
        {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            Dialog("Η χρήση της τοποθεσίας σας δεν είναι ενεργή");

        }
        mMap.setMyLocationEnabled(true);//relocates because previous marker was cleared
    }
    public void Dialog(String msg)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(msg)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    //exits the application
                    public void onClick(DialogInterface dialog, int id)
                    {
                       return;
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
