package id.pu.argps.infojalan.helper;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class LocationServiceImpl implements LocationService {
    private Context context;
    private PublishSubject<Location> locationSubject;
    private Geocoder geocoder;
    private FusedLocationProviderClient fusedLocationClient;

    public LocationServiceImpl(Context context) {
        this.context = context;
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(context);
        geocoder = new Geocoder(context);
        locationSubject = PublishSubject.create();
    }

    public boolean isPermissionsLocation() {


        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //Permission
            return false;
        }

        return true;
    }

    @SuppressLint("MissingPermission")
    @Override
    public void requestSingleUpdate(Activity activity) {
        if(isPermissionsLocation()){
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(activity, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            // Got last known location. In some rare situations this can be null.
                            if (location != null) {
                                locationSubject.onNext(location);
                                // Logic to handle location object
                            }
                        }
                    });
        }
    }



    @Override
    public Observable<List<Address>> getAddressStream(Location location)  {
        return Observable.just(location)
                .map(S->geocoder.getFromLocation(S.getLatitude(),S.getLongitude(),1))
                .onErrorResumeNext(Observable.empty())
                .subscribeOn(Schedulers.io());
    }


    @Override
    public Observable<Location> geChangeLocationStream() {
        return locationSubject;
    }
}
