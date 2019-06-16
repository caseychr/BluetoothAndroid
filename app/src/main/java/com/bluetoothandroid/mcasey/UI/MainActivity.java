package com.bluetoothandroid.mcasey.UI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.bluetoothandroid.mcasey.R;

public class MainActivity extends AppCompatActivity {

    public static final String DEVICE_NAME = "device_name";

    public FragmentManager fm;
    Fragment mFragment;

    private TextView mConnectDevice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        mFragment = fm.findFragmentById(R.id.fragment_container);
        mConnectDevice = findViewById(R.id.connect_tv);
        mConnectDevice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mConnectDevice.setVisibility(View.GONE);
                mFragment = new ConnectedDeviceFragment();
                fm.beginTransaction().add(R.id.fragment_container, mFragment).commit();
            }
        });
    }
}
