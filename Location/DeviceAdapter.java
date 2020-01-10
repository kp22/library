package com.skptech.adapter;

import android.app.Activity;
import android.content.Context;
import android.provider.Telephony;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.skptech.common.Utils;
import com.skptech.finderble.R;
import com.skptech.finderble.databinding.ItemDeviceBinding;
import com.skptech.model.ScanDataModel;

import java.util.ArrayList;
import java.util.List;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.ViewHolder> {

    public String TAG = getClass().getSimpleName();
    private Context context;
    ItemDeviceBinding binding;
    private List<ScanDataModel> list;
    private ScanDataModel.AddressComparator comparator = new ScanDataModel.AddressComparator();
    private RecyclerView recycleView;

    public DeviceAdapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_device, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (list != null) {
            holder.binding.tvDeviceName.setText(list.get(position).getDeviceName());
            holder.binding.tvMacAddress.setText(list.get(position).getDeviceMacaddress());
            holder.binding.tvRssi.setText("" + list.get(position).getDeviceRssi());
        }
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void addDevice(ScanDataModel model) {
        list.add(model);
        notifyDataSetChanged();
    }

    public void updateDevice(final ScanDataModel model) {

        ((Activity) context).runOnUiThread(new Runnable() {
            @Override
            public void run() {
                comparator.macAddress = model.getDeviceMacaddress();
                int index = list.indexOf(comparator);
                if (index >= 0) {
                    View view = recycleView.getChildAt(index);
                    if (view != null) {
                        TextView tvRssi = view.findViewById(R.id.tvRssi);
                        tvRssi.setText(model.getDeviceRssi() + "");
                        Utils.log(TAG, "view index = " + index + " | Rssi:" + model.getDeviceRssi());
                    } else {
                        Utils.log(TAG, "view null = " + index);
                    }
                } else {
                    Utils.log(TAG, "index = " + index);
                }
            }
        });
    }

    public List<ScanDataModel> getAllDevices() {
        return list;
    }

    public void setRecyclerView(RecyclerView recycleView) {
        this.recycleView = recycleView;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemDeviceBinding binding;

        public ViewHolder(@NonNull ItemDeviceBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }

}