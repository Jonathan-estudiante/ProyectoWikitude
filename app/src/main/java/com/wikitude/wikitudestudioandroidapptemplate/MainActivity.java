package com.wikitude.wikitudestudioandroidapptemplate;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;

public class MainActivity extends Activity {

    Button btnCamera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCamera = findViewById(R.id.btnCamara);

        btnCamera.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SampleCamActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            ActivityCompat.finishAfterTransition(MainActivity.this);
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        //Controlar la pulsación hacia atrás
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("¿Desea salir de la app?")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Intent.ACTION_MAIN);
                            intent.addCategory(Intent.CATEGORY_HOME);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            startActivity(intent);
                        }

                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            builder.show();
        }
        return super.onKeyDown(keyCode, event);
    }
}