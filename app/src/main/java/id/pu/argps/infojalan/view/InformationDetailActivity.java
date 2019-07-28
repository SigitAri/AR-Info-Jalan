package id.pu.argps.infojalan.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import id.pu.argps.infojalan.R;
import id.pu.argps.infojalan.model.InfoLocation;
import id.pu.argps.infojalan.model.MockInfoLocations;

public class InformationDetailActivity extends AppCompatActivity {
    public static String KEY_TITLE = "key_title";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_detail);
        ImageView projectImg = findViewById(R.id.project_image);
        TextView projectName = findViewById(R.id.project_name);
        TextView projectDate = findViewById(R.id.project_date);
        TextView projectCost = findViewById(R.id.project_cost);
        TextView peresmi = findViewById(R.id.peresmi);
        TextView paylod = findViewById(R.id.payload);

        String titleProject = "";
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle!=null) {
            titleProject =(String) bundle.get(KEY_TITLE);
        }

        MockInfoLocations mockInfoLocations = MockInfoLocations.getInstance(getApplicationContext());
        InfoLocation infoLocation = mockInfoLocations.getInfoLocations(titleProject);
        if(infoLocation!=null){
            projectImg.setImageResource(infoLocation.getIdImage());
            projectName.setHint(infoLocation.getTitle());
            projectDate.setHint(infoLocation.getDate());
            projectCost.setHint(infoLocation.getBiaya());
            peresmi.setHint(infoLocation.getPeresmi());
            paylod.setText(infoLocation.getPayload());
        }


    }
}
