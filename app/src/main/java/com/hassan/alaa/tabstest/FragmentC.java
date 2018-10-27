package com.hassan.alaa.tabstest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentC extends Fragment {

    ArrayList<Item> items;
    ListView listView;
    ItemAdaptar itemAdaptar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        items = new ArrayList<Item>();
        items.add(new Item("Item 1", "There is some information about item 1", R.drawable.shoppingbag));
        items.add(new Item("Item 2", "There is some information about item 2", R.drawable.shoppingbag));
        items.add(new Item("Item 3", "There is some information about item 3", R.drawable.shoppingbag));
        items.add(new Item("Item 4", "There is some information about item 4", R.drawable.shoppingbag));
        items.add(new Item("Item 5", "There is some information about item 5", R.drawable.shoppingbag));
        items.add(new Item("Item 6", "There is some information about item 6", R.drawable.shoppingbag));
        items.add(new Item("Item 7", "There is some information about item 7", R.drawable.shoppingbag));

        View v = inflater.inflate(R.layout.fragment_c,container,false);
        listView = (ListView) v.findViewById(R.id.listC);
        itemAdaptar = new ItemAdaptar(getActivity(),items);
        listView.setAdapter(itemAdaptar);

        return v;
    }
}
