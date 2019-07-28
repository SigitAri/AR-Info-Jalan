package id.pu.argps.infojalan.view;
import android.content.Intent;
import android.location.Address;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.HitTestResult;
import com.google.ar.sceneform.Node;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

import java.util.List;

import id.pu.argps.infojalan.R;
import id.pu.argps.infojalan.helper.LocationService;
import id.pu.argps.infojalan.helper.LocationServiceImpl;
import id.pu.argps.infojalan.model.InfoLocation;
import id.pu.argps.infojalan.model.MockInfoLocations;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class CameraArActivity extends AppCompatActivity {

    private ArFragment arFragment;
    private LocationService locationService;
    private HitResult hitResult;
    private MockInfoLocations mockInfoLocations;
    private AnchorNode anchorNode;
    private ProgressBar loading;
    private boolean oneClick = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_ar);
        loading = findViewById(R.id.progress_get_location);
        locationService = new LocationServiceImpl(getApplicationContext());
        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.ux_fragment);
        mockInfoLocations = MockInfoLocations.getInstance(getApplicationContext());

        arFragment.setOnTapArPlaneListener(
                (HitResult hitResult, Plane plane, MotionEvent motionEvent) -> {
                    if(loading.getVisibility() == View.INVISIBLE) {
                        this.hitResult = hitResult;
//                    renderObject("jalan tegal melati");
                        loading.setVisibility(View.VISIBLE);
                        startGetLocation();
                    }
                });

        initLocation();
    }

    private void initLocation(){
        locationService.geChangeLocationStream()
                .concatMap(S->locationService.getAddressStream(S))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(S -> receiveAddress(S));
    }

    private void startGetLocation(){
        locationService.requestSingleUpdate(this);
    }

    private void receiveAddress(List<Address> addresses){
        if(addresses != null && addresses.size() > 0 ){
            Address address = addresses.get(0);
            String street = address.getThoroughfare();
            renderObject(street);
        }
    }

    private void renderObject(String street){
        loading.setVisibility(View.INVISIBLE);
        InfoLocation infoLocation = mockInfoLocations.getInfoLocations(street);
        if(infoLocation != null && infoLocation.getModelRenderable() != null){

            if(anchorNode!=null){
                removeAnchorNode(anchorNode);
            }

            Anchor anchor = hitResult.createAnchor();
            anchorNode = new AnchorNode(anchor);
            anchorNode.setParent(arFragment.getArSceneView().getScene());

            TransformableNode transformableNode = new TransformableNode(arFragment.getTransformationSystem());
            transformableNode.setParent(anchorNode);
            transformableNode.setRenderable(infoLocation.getModelRenderable());
            transformableNode.setOnTapListener(new Node.OnTapListener() {
                @Override
                public void onTap(HitTestResult hitTestResult, MotionEvent motionEvent) {
                    Intent intent = new Intent(getApplicationContext(), InformationDetailActivity.class);
                    intent.putExtra(InformationDetailActivity.KEY_TITLE, infoLocation.getTitle());
                    startActivity(intent);
                }
            });
            transformableNode.select();

        } else {
            Toast toast = Toast.makeText(this, street+" tidak ada info", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    private void removeAnchorNode(AnchorNode nodeToremove) {
        //Remove an anchor node
        if (nodeToremove != null) {
            arFragment.getArSceneView().getScene().removeChild(nodeToremove);
            nodeToremove.getAnchor().detach();
            nodeToremove.setParent(null);
            nodeToremove = null;
        }
    }
}
