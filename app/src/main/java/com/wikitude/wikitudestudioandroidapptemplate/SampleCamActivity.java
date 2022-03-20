package com.wikitude.wikitudestudioandroidapptemplate;

import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;

public class SampleCamActivity extends AbstractArchitectCamActivity {

    /**
     * path to the World index.html. Relative paths: Relative to assets-root folder, Absolute paths: Web-Url (http://...) or file-path
     */
    private static final String WORLD_PATH = "index.html";

    @Override
    public String getARchitectWorldPath() {
        return WORLD_PATH;
    }

    @Override
    public String getActivityTitle() {
        return getString(R.string.app_name);
    }

    @Override
    public int getContentViewId() {
        return R.layout.sample_cam;
    }

    @Override
    public int getArchitectViewId() {
        return R.id.architectView;
    }

    @Override
    public String getWikitudeSDKLicenseKey() {
        return WikitudeSDKConstants.WIKITUDE_SDK_KEY;
    }

    @Override
    public float getInitialCullingDistanceMeters() {
        // you need to adjust this in case your POIs are more than 50km away from user here while loading or in JS code (compare 'AR.context.scene.cullingDistance')
        return ArchitectViewHolderInterface.CULLING_DISTANCE_DEFAULT_METERS;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        //Controlar la pulsación hacia atrás
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

}
