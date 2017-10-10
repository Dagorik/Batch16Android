package batch16.android.devf.com.autocompletemaps;

import android.*;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final int REQUEST_CODE_AUTOCOMPLETE = 1;
    private GoogleMap mMap;
    private static final int REQUEST_LOCATION = 1;
    private Place place;
    private TextView mPlaceDetailsText;
    private boolean skipMethod = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button openButton = (Button) findViewById(R.id.open_button);
        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAutocompleteActivity();
            }
        });

        mPlaceDetailsText = (TextView) findViewById(R.id.place_details);
        skipMethod = true;
    }

    private void openAutocompleteActivity() {
        AutocompleteFilter typeFilter = new AutocompleteFilter.Builder().
                setTypeFilter(Place.TYPE_COUNTRY).setCountry("MX").build();

        try {
            Intent intent = new PlaceAutocomplete
                    .IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                    .setFilter(typeFilter)
                    .build(this);

            startActivityForResult(intent, REQUEST_CODE_AUTOCOMPLETE);

        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_AUTOCOMPLETE) {

            if (resultCode == RESULT_OK) {
                place = PlaceAutocomplete.getPlace(this, data);

                mPlaceDetailsText.setText("Place id: " + place.getId() + "\nAddress: " + place.getAddress() +
                        "\nLatitude Longitud: " + place.getLatLng() + "\nName: " + place.getName());

                Log.e("MyPlace", place.getName() + "");
            }
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!skipMethod) {
            onMapReady(mMap);
        }
        skipMethod = false;

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        googleMap.clear();

        if (place != null) {
            LatLng marker = new LatLng(place.getLatLng().latitude, place.getLatLng().longitude);
            googleMap.addMarker(new MarkerOptions().position(marker).title(place.getName() + ""));

            //Zoom marker
            CameraPosition camaraPosition = new CameraPosition.Builder()
                    .target(marker)
                    .zoom(17)
                    .build();

            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(camaraPosition));

        } else {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        REQUEST_LOCATION);
            }

        }
    }
}
