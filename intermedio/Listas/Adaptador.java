package com.example.trabajo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.ImageView;

public class Adaptador extends BaseAdapter {
    Context contexto;
    String listadeporte[];
    String listacomentar[];
    int listaimagenes[];
    LayoutInflater inflater;

    public Adaptador(Context contexto, String[] listadeporte,
                     String[] listacomentar, int []listaimagenes
                     ) {
        this.contexto = contexto;
        this.listadeporte = listadeporte;
        this.listacomentar = listacomentar;
        this.listaimagenes = listaimagenes;
        this.inflater = LayoutInflater.from(contexto);

    }

    @Override
    public int getCount() {
        return listacomentar.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.basurita,null);

        TextView textView = convertView.findViewById(R.id.textview);
        TextView textView2 = convertView.findViewById(R.id.textview2);
        ImageView deporteimg =convertView.findViewById(R.id.imageicon);
        textView.setText(listadeporte[position]);
        textView2.setText(listacomentar[position]);
        deporteimg.setImageResource(listaimagenes[position]);
        return convertView;
    }

}
