package com.example.midtermtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<ProgrammeView> {
    // invoke the suitable constructor of the ArrayAdapter class
    public ListViewAdapter(@NonNull Context context, ArrayList<ProgrammeView> arrayList) {

        // pass the context and arrayList for the super
        // constructor of the ArrayAdapter class
        super(context, 0, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // convertView which is recyclable view
        View currentItemView = convertView;

        // of the recyclable view is null then inflate the custom layout for the same
        if (currentItemView == null) {
            currentItemView = LayoutInflater.from(getContext()).inflate(R.layout.fragment_programme, parent, false);
        }

        // get the position of the view from the ArrayAdapter
        ProgrammeView currentNumberPosition = getItem(position);

        // then according to the position of the view assign the desired TextView 1 for the same
        TextView tvId = currentItemView.findViewById(R.id.tvPId);
        tvId.setText(currentNumberPosition.getId());
        TextView tvName = currentItemView.findViewById(R.id.tvPCName);
        tvName.setText(currentNumberPosition.getName());
        TextView tvHours = currentItemView.findViewById(R.id.tvPCHours);
        tvHours.setText(currentNumberPosition.getHours());

        // then return the recyclable view
        return currentItemView;
    }
}
