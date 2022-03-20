package com.wikitude.wikitudestudioandroidapptemplate;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class RuntimePermissionRequestActivity extends Activity {

    private static final int WIKITUDE_PERMISSIONS_REQUEST_CAMERA = 1;


    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, WIKITUDE_PERMISSIONS_REQUEST_CAMERA);
        } else {
            startCamActivity();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case WIKITUDE_PERMISSIONS_REQUEST_CAMERA: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    startCamActivity();
                } else {
                    Toast.makeText(this, "Sorry, augmented reality doesn't work without reality.\n\nPlease grant camera permission.", Toast.LENGTH_LONG).show();
                }
            }
        }
    }

    public void startCamActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }
}
