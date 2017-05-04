package androidlab.epam.com.task2;

import android.Manifest;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.security.AccessController;

import static android.os.Binder.getCallingUid;

public class MainActivity extends AppCompatActivity {
    Button btnStart;
    private static String START_ACTIVITY = "androidlab.epam.com.task2module.permission.START_ACTIVITY";
    Intent intent = new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (ContextCompat.checkSelfPermission(this, START_ACTIVITY) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{START_ACTIVITY}, 777);
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case 777: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    intent.setComponent(new ComponentName("androidlab.epam.com", "androidlab.epam.com.task2module"));
                    startActivity(intent);

                } else {
                    shouldShowRequestPermissionRationale(START_ACTIVITY);
                    ActivityCompat.requestPermissions(this, new String[]{START_ACTIVITY}, 777);
                }

                    return;

            }
        }
    }
}