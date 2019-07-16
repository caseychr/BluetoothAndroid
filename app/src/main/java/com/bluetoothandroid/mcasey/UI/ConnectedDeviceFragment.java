package com.bluetoothandroid.mcasey.UI;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.bluetoothandroid.mcasey.R;
import com.driverapp.bluetoothandroidlibrary.BluetoothDeviceController;
import com.driverapp.bluetoothandroidlibrary.BluetoothService;

public class ConnectedDeviceFragment extends Fragment implements BluetoothDeviceView {

    /**
     * BluetoothService Service requires 2 things for the developer to implement:
     * 1) Implement BluetoothDeviceView onto whatever view that will display readings.
     *
     * 2) Create BluetoothDeviceController object and invoke init() method to connect the
     *    BluetoothService socket and begin reading info.
     */

    BluetoothDeviceController mConnectedDeviceController;

    TextView mDeviceName;
    TextView mEngineRPM;
    TextView mVehicleSpeed;
    TextView mCoolantTemp;
    TextView mAirFlow;
    TextView mDistance;

    @Override
    public void onResume() {
        super.onResume();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_connected_device, container, false);

        mDeviceName = view.findViewById(R.id.device_name);
        mEngineRPM = view.findViewById(R.id.input_rpm);
        mVehicleSpeed = view.findViewById(R.id.input_speed);
        mCoolantTemp = view.findViewById(R.id.input_coolant);
        mAirFlow = view.findViewById(R.id.input_air);
        mDistance = view.findViewById(R.id.input_distance);

        mConnectedDeviceController = new BluetoothDeviceController(BluetoothService.POLLING);
        mConnectedDeviceController.init();

        return view;
    }

    @Override
    public void updateRPM() {
        mEngineRPM.setText(BluetoothDeviceController.getmEngineRPM());
    }

    @Override
    public void updateSpeed() {
        mVehicleSpeed.setText(BluetoothDeviceController.getmVehicleSpeed());
    }

    @Override
    public void updateAirFlow() {
        mAirFlow.setText(BluetoothDeviceController.getmAirFlow());
    }

    @Override
    public void updateCoolant() {
        mCoolantTemp.setText(BluetoothDeviceController.getmCoolantTemp());
    }

    @Override
    public void updateDistance() {
        mDistance.setText(BluetoothDeviceController.getmDistance());
    }

    @Override
    public void updateErrorMessage() {
        Toast.makeText(getActivity(), BluetoothDeviceController.getmErrorMessage(), Toast.LENGTH_SHORT).show();
    }
}
