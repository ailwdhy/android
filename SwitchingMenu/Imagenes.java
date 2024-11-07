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
    // funciona como un for por cada elemento i
    public View getView(int i, View view, ViewGroup viewGroup) {
        // infla la lista
        view = inflater.inflate(R.layout.lista, null);
        // objeto para imagenes
        ImageView imageView = view.findViewById(R.id.imagen);
        // trae las imagenes
        imageView.setImageResource(imagenes[i]);

        // objetito para los textos
        TextView texto1 = view.findViewById(R.id.texto1);
        // trae los textos
        texto1.setText(textos1[i]);


        // objeto para el subtexto
        TextView texto2 = view.findViewById(R.id.texto2);
        // trae los subtextos
        texto2.setText(textos2[i]);
        // manda la vista
        return view;
    }
}
