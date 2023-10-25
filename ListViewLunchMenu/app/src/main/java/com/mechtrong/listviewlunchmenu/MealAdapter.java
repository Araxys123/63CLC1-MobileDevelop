package com.minhvo.listviewlunchmenu;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MealAdapter extends BaseAdapter {
    private ArrayList<Meal> lstMeal;
    private LayoutInflater layoutInflater;
    private Context context;

    public MealAdapter( Context _context,ArrayList<Meal> lstMeal) {
        this.lstMeal = lstMeal;
        this.context = _context;
        this.layoutInflater = LayoutInflater.from(_context);
    }

    @Override
    public int getCount() {
        return lstMeal.size();
    }

    @Override
    public Object getItem(int i) {
        return lstMeal.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    ///
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //View item hien hanh
        View viewHienHanh = view;

        if(viewHienHanh == null)
            viewHienHanh = layoutInflater.inflate(R.layout.activity_meal,null);

        Meal currentMeal = lstMeal.get(i);


        //
        TextView textView_foodName = (TextView)viewHienHanh.findViewById(R.id.tvName);
        TextView textView_foodPrice = (TextView)viewHienHanh.findViewById(R.id.tvPrice);
        TextView textView_foodDes = (TextView)viewHienHanh.findViewById(R.id.tvDes);
        ImageView imageView_foodImg = (ImageView)viewHienHanh.findViewById(R.id.img);


        //
        textView_foodName.setText(currentMeal.getTenFood());
        textView_foodPrice.setText(String.valueOf(currentMeal.getPriceFood()));
        textView_foodDes.setText(currentMeal.getDesFood());
        imageView_foodImg.setImageResource(currentMeal.getImgFood());

        return viewHienHanh;


    }
}
