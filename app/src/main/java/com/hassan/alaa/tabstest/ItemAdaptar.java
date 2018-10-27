package com.hassan.alaa.tabstest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ItemAdaptar extends ArrayAdapter<Item> {

    public ItemAdaptar(@NonNull Context context, ArrayList<Item> items) {
        super(context, 0, items);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_row, parent,false);
        TextView title = convertView.findViewById(R.id.titleTxt);
        TextView desc = convertView.findViewById(R.id.descTxt);
        ImageView imgId = convertView.findViewById(R.id.imageview);
        Item item = getItem(position);
        title.setText(item.getTitle());
        desc.setText(item.getDesc());
        imgId.setImageResource(item.getImgId());
        return convertView;
    }
}
