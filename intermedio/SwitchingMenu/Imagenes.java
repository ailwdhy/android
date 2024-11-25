package com.example.switchingmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Imagenes extends BaseAdapter {
    public int[] imagenes;
    public String[] textos1;
    public String[] textos2;
    public LayoutInflater inflater;
    public Context context;

    public Imagenes(int[] imagenes, String[] textos1, String[] textos2, Context context) {
        this.imagenes = imagenes;
        this.textos1 = textos1;
        this.textos2 = textos2;
        this.inflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return imagenes.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.lista, null);
        ImageView imageView = view.findViewById(R.id.imagen);
        imageView.setImageResource(imagenes[i]);

        TextView texto1 = view.findViewById(R.id.texto1);
        texto1.setText(textos1[i]);


        TextView texto2 = view.findViewById(R.id.texto2);
        texto2.setText(textos2[i]);
        return view;
    }
}
