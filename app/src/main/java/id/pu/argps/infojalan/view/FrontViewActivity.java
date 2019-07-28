package id.pu.argps.infojalan.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jakewharton.rxbinding.view.RxView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import id.pu.argps.infojalan.R;
import id.pu.argps.infojalan.model.MockInfoLocations;
import rx.Subscriber;
import rx.functions.Func1;

public class FrontViewActivity extends AppCompatActivity {

    private static final int EVENT_COUNT = 7;
    private static final int EVENT_TIME = 5;
    public static final int MULTIPLE_PERMISSIONS = 10;

    String[] permissions= new String[]{
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.CAMERA};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_view);
        View puLogo = findViewById(R.id.puLogo);

        Button goBtn = findViewById(R.id.go_btn);
        goBtn.setOnClickListener(goBtnListener);
        MockInfoLocations.getInstance(getApplicationContext()).mock();

        getHeaderTitleClickEventStream(puLogo);
    }

    View.OnClickListener goBtnListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (checkPermissions()){
                Intent intent = new Intent(getApplicationContext(), CameraArActivity.class);
                startActivity(intent);
            }
        }
    };

    public void getHeaderTitleClickEventStream(View puLogo) {
        RxView.clicks(puLogo)
                .buffer(EVENT_TIME, TimeUnit.SECONDS, EVENT_COUNT)
                .filter(new Func1<List, Boolean>() {
                    @Override
                    public Boolean call(List eventList) {
                        return !eventList.isEmpty() && eventList.size() >= EVENT_COUNT;
                    }
                })
                .subscribe(new Subscriber<List<Object>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Object> objects) {
                        if (checkPermissions()) {
                            startActivity(new Intent(FrontViewActivity.this, CeckLocationActivity.class));
                        }
                    }
                });
    }


    private  boolean checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p:permissions) {
            result = ContextCompat.checkSelfPermission(this,p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]),MULTIPLE_PERMISSIONS );
            return false;
        }
        return true;
    }
}
