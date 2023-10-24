package com.minhvo.CustomListViewNationFlag;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryArrayAdapter extends BaseAdapter {

    //Layout's attributes
    List<Country> lstdataSource;
    private LayoutInflater inflater;
    private Context context;

    public CountryArrayAdapter(List<Country> lstdataSource, Context context) {
        this.lstdataSource = lstdataSource;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    class countryViewHolder { //Mappingg from customize XML layout
        ImageView flagView;
        TextView countryNameView;
        TextView populationView;
    }
    @Override
    public int getCount() {
        return lstdataSource.size();
    }

    @Override
    public Object getItem(int i) {
        return lstdataSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        countryViewHolder itemViewHolder;
        if(view == null){
            //XML->
            view = inflater.inflate(R.layout.country_list_view_item, null);
            itemViewHolder = new countryViewHolder();

            itemViewHolder.flagView = view.findViewById(R.id.imageView);
            itemViewHolder.countryNameView = view.findViewById(R.id.textViewCountryName);
            itemViewHolder.populationView = view.findViewById(R.id.textViewNationPopulation);

            view.setTag(itemViewHolder);
        }
        else{
            itemViewHolder = (countryViewHolder)view.getTag();
        }

        //Set item's data
        Country countryItem = lstdataSource.get(i);
        itemViewHolder.countryNameView.setText(countryItem.getCountryName());
        itemViewHolder.populationView.setText("Population: "+countryItem.getPopulation());

        //image data,  need your own function
        int flagID = getImgIDbyResName(countryItem.getCountryFlag());
        itemViewHolder.flagView.setImageResource(flagID);
        return view;
    } //end of getView

    //My own function for reading image ID
    public int getImgIDbyResName(String resName)
    {
        String packageName = context.getPackageName();
        int imgID = context.getResources().getIdentifier(resName, "mipmap", packageName );
        return imgID;
    }

}
