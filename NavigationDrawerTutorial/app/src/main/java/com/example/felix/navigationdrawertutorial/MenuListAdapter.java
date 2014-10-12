package com.example.felix.navigationdrawertutorial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuListAdapter extends BaseAdapter
{
    private Context context;
    private String[] title;
    private String[] subTitle;
    private int[] icon;
    private LayoutInflater inflater;

    public MenuListAdapter(Context context, String[] title, String[] subtitle, int[] icon)
    {
        this.context = context;
        this.title = title;
        this.subTitle = subtitle;
        this.icon = icon;
    }

    @Override
    public int getCount()
    {
        return title.length;
    }

    @Override
    public Object getItem(int i)
    {
        return title[i];
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.drawer_list_item, viewGroup, false);
        TextView txtTitle = (TextView) itemView.findViewById(R.id.title);
        TextView txtSubTitle = (TextView) itemView.findViewById(R.id.subtitle);
        ImageView imgIcon = (ImageView) itemView.findViewById(R.id.icon);
        txtTitle.setText(title[i]);
        txtSubTitle.setText(title[i]);
        imgIcon.setImageResource(icon[i]);
        return itemView;
    }
}

