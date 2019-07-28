package id.pu.argps.infojalan.view;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import id.pu.argps.infojalan.R;

public class SplashscreenActivity extends AppCompatActivity {

    Thread mThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        mThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1200);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(new Intent(SplashscreenActivity.this,FrontViewActivity.class));
                    finish();
                }

            }
        });
        mThread.start();

    }
}

