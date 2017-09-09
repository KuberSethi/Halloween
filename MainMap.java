package michael.com.halloween;

import android.graphics.Camera;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    //Code that runs once the map is completely ready
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;


        /*Listener for clicking a marker
          Shows a dialog that will show


         */
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                EventInfoFragment dialog = new EventInfoFragment();

                dialog.show(getFragmentManager(),"");

                return false;
            }
        });



        /*Listener for clicking on the map
          Creates a dialog/form that allows user to submit
          data to firebase
        */
        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                CreateEventFragment dialog = new CreateEventFragment();
                Bundle bundle = new Bundle();
                bundle.putDouble("latitude",latLng.latitude);
                bundle.putDouble("longitude",latLng.longitude);
                dialog.setArguments(bundle);
                dialog.show(getFragmentManager(),"");
                map.addMarker(new MarkerOptions().position(latLng));
            }
        });



    }
}
