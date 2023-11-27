package com.pal.navigationdrawer.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.pal.navigationdrawer.R;
import com.pal.navigationdrawer.dto.response.JogoResponse;

import java.util.ArrayList;

public class JogoListAdapter extends BaseAdapter {

    Context context;
    private ArrayList<JogoResponse> items;

    public JogoListAdapter(Context context, ArrayList<JogoResponse> jogos)
    {
        this.context = context;
        this.items = jogos;
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
            convertView = inflater.inflate(R.layout.jogo_list_item, parent, false);
            viewHolder.txtName = convertView.findViewById(R.id.jogoTitle);
            viewHolder.txtTipo = convertView.findViewById(R.id.jogoType);

            convertView.setTag(viewHolder);

            // Click nos item da listview
            viewHolder.txtName.setOnClickListener(view -> Log.i("LISTVIEW", "TextView click"));


        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.txtName.setText(items.get(position).getModalidade().getName());
        viewHolder.txtTipo.setText(items.get(position).getModalidade().getTipo());

        return convertView;
    }

    private static class ViewHolder {

        TextView txtName;
        TextView txtTipo;

    }
}


