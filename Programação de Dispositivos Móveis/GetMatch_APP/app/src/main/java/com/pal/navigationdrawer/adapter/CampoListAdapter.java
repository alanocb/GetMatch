package com.pal.navigationdrawer.adapter;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.pal.navigationdrawer.MapsFragment;
import com.pal.navigationdrawer.R;
import com.pal.navigationdrawer.dto.response.CampoResponse;

import java.util.ArrayList;

public class CampoListAdapter extends BaseAdapter {

    Context context;
    private ArrayList<CampoResponse> items;

    public CampoListAdapter(Context context, ArrayList<CampoResponse> items)
    {
        this.context = context;
        this.items = items;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int id) {
        return id;
    }



    @Override
    public View getView(int position, View convertView,
                        ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.campo_list_item, parent, false);
            viewHolder.txtTitle = convertView.findViewById(R.id.campoTitle);
            viewHolder.txtTipo = convertView.findViewById(R.id.campoType);

            convertView.setTag(viewHolder);

            // Click nos item da listview
            viewHolder.txtTitle.setOnClickListener(view -> {
                try {
                    Bundle args = new Bundle();
                    args.putDouble("latitude", items.get(position).getLatitude());
                    args.putDouble("longitude", items.get(position).getLongitude());
                    args.putString("location", items.get(position).getEndereco());

                    MapsFragment fragment = new MapsFragment();
                    fragment.setArguments(args);

                    FragmentManager fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.navHostFragment, fragment)
                            .addToBackStack(null)
                            .commit();
                } catch (ClassCastException e) {
                    Log.e("TAG", "Can't get fragment manager");
                }
            });


        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.txtTitle.setText(items.get(position).getName());
        viewHolder.txtTipo.setText(items.get(position).getLocalizacao());

        return convertView;
    }

    private static class ViewHolder {

        TextView txtTitle;
        TextView txtTipo;

    }
}


