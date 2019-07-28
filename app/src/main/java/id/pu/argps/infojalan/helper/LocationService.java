package id.pu.argps.infojalan.helper;

import android.app.Activity;
import android.location.Address;
import android.location.Location;

import java.util.List;

import io.reactivex.Observable;

public interface LocationService {
    void requestSingleUpdate(Activity activity);
    Observable<Location> geChangeLocationStream();
    Observable<List<Address>> getAddressStream(Location location);
}
