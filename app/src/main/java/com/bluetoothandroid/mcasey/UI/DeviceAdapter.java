package com.bluetoothandroid.mcasey.UI;

import android.bluetooth.BluetoothDevice;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bluetoothandroid.mcasey.R;

import java.util.List;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.ViewHolder> {

    interface OnItemClickListener{
        void onClick();
    }

    List<BluetoothDevice> mDevices;
    OnItemClickListener mOnItemClickListener;
    public int adapterPosition;

    public DeviceAdapter(List<BluetoothDevice> devices) {
        mDevices = devices;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.device_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        BluetoothDevice bluetoothDevice = mDevices.get(i);
        viewHolder.mDeviceName.setText(bluetoothDevice.getName());
        viewHolder.mMacAddress.setText(bluetoothDevice.getAddress());
    }

    @Override
    public int getItemCount() {
        return mDevices.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView mDeviceName;
        TextView mMacAddress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mDeviceName = itemView.findViewById(R.id.list_device_name);
            mMacAddress = itemView.findViewById(R.id.list_mac_address);
        }


        @Override
        public void onClick(View view) {
            adapterPosition = getAdapterPosition();
            mOnItemClickListener.onClick();
        }
    }
}
