package com.minglaihan.tools;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

public class SpecialAdapter extends SimpleAdapter {
        private int[] colors = new int[] { 
        		Color.rgb(249, 249, 248), 
        		Color.rgb(222, 239, 247) };

        public SpecialAdapter(Context context, int type,ArrayList<HashMap<String, String>> listUsers, int resource, String[] from, int[] to) {
                super(context,listUsers, resource, from, to);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
          View view = super.getView(position, convertView, parent);
          int colorPos = position % colors.length;
          view.setBackgroundColor(colors[colorPos]);
          return view;
        }
}
