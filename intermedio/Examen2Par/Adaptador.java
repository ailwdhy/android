package com.example.examen2par;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adaptador extends BaseAdapter {

    private Context context;
    private String[] titles;
    private String[] descriptions;
    private int[] images;

    public Adaptador(Context context, String[] titles, String[] descriptions, int[] images) {
        this.context = context;
        this.titles = titles;
        this.descriptions = descriptions;
        this.images = images;
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.basurita, null);
        }

        TextView textView1 = view.findViewById(R.id.textview);
        TextView textView2 = view.findViewById(R.id.textview2);
        ImageView imageView = view.findViewById(R.id.imageicon);


        textView1.setText(titles[position]);
        textView2.setText(descriptions[position]);
        imageView.setImageResource(images[position]);

        return view;
    }
}
