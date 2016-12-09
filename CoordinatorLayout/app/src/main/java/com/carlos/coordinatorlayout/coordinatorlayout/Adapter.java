package com.carlos.coordinatorlayout.coordinatorlayout;

import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carlos on 22/11/2016.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    List<Person> list = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
          holder.nombre.setText(list.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void swapData(List<Person> lista) {
        list= lista;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
       TextView nombre;
        ViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.tvNombre);

        }
    }

}