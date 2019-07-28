package id.pu.argps.infojalan.view;

import android.location.Address;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;


import id.pu.argps.infojalan.R;
import id.pu.argps.infojalan.helper.LocationService;
import id.pu.argps.infojalan.helper.LocationServiceImpl;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class CeckLocationActivity extends AppCompatActivity {

    LocationService locationService;
    TextView locationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ceck_location);

        locationService = new LocationServiceImpl(getApplicationContext());

        locationView = findViewById(R.id.location_view);
        Button button = findViewById(R.id.ceck_location_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGetLocation();
            }
        });

        initLocation();
    }

    private void startGetLocation(){
        locationService.requestSingleUpdate(this);
    }

    private void initLocation(){
        locationService.geChangeLocationStream()
                .concatMap(S->locationService.getAddressStream(S))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(S -> receiveAddress(S));
    }

    private void receiveAddress(List<Address> addresses){
        if(addresses != null && addresses.size() > 0 ){
            Address address = addresses.get(0);
            // Thoroughfare seems to be the street name without numbers
            String street = address.getThoroughfare();
            locationView.setText(street);
        }
    }

}
