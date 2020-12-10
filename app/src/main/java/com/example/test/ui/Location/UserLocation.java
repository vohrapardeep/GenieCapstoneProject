package com.example.test.ui.Location;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.test.Login;
import com.example.test.R;
import com.google.android.gms.common.FirstPartyScopes;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserLocation extends AppCompatActivity implements LocationListener {

    Button btnLocation,btnSpinner;
    TextView tv_Address;
    Spinner spinner_location;
    LocationManager locationManager;

    FirebaseDatabase fd;
    DatabaseReference dr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_location);
        btnLocation = findViewById(R.id.btn_location);
        btnSpinner = findViewById(R.id.btnSpinner);
        tv_Address = findViewById(R.id.tv_address);
        spinner_location = findViewById(R.id.spinner_location);

        List<String> cityList = new ArrayList<String>();
        cityList.add("Choose You City");
        cityList.add("Kitchener");
        cityList.add("Cambridge");
        cityList.add("Waterloo");
        cityList.add("Guelph");
        cityList.add("Brantford");


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, cityList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_location.setAdapter(adapter);

        if (ContextCompat.checkSelfPermission(UserLocation.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(UserLocation.this, new String[]{
                    Manifest.permission.ACCESS_FINE_LOCATION
            }, 100);
        }

        // button listener for gps location selection
        btnLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getUserLocation();
                Intent intent= new Intent(getApplicationContext(), Login.class);
                startActivity(intent);

            }
        });

        //button listener for spinner city selection
        btnSpinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fd = FirebaseDatabase.getInstance();
                dr= fd.getReference("Location");
                String citySelected = spinner_location.getSelectedItem().toString();
                UserLocationHelperClass userLocationHelperClass = new UserLocationHelperClass(citySelected);



                if(spinner_location.getSelectedItemPosition()==0){
                    Toast.makeText(UserLocation.this, "Please choose a city to proceed!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(getApplicationContext(), Login.class);
                    startActivity(intent);
                    dr.setValue(userLocationHelperClass);
                }

            }
        });



    }


    private void getUserLocation() {
        try {
            locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 5, UserLocation.this);
        }catch (Exception e){
            e.printStackTrace();
        }

       }

    @Override
    public void onLocationChanged(Location location) {
        Toast.makeText(this, "" + location.getLatitude()+"," + location.getLongitude(), Toast.LENGTH_SHORT).show();


            fd = FirebaseDatabase.getInstance();
            dr= fd.getReference("Location");

            try {
                Geocoder geocoder = new Geocoder(UserLocation.this, Locale.getDefault());


                List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);

                String ad = addresses.get(0).getAddressLine(0);
                String city = addresses.get(0).getLocality();
                tv_Address.setText(ad);

                UserLocationHelperClass userLocationHelperClass = new UserLocationHelperClass(city);

                dr.setValue(userLocationHelperClass)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(UserLocation.this, "Location saved", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(UserLocation.this, "Location not saved", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }catch (Exception e){ e.printStackTrace();}
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