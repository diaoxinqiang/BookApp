package com.diaoxinqiang.bookapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.diaoxinqiang.bookapp.R;
import com.diaoxinqiang.bookapp.bean.CategoryItem;

import java.util.List;

/**
 * Created by Administrator on 2015/12/11.
 */
public class SideListAdapter extends BaseAdapter{
    private  List<CategoryItem> categoryItems;
    private Context context;
    private LayoutInflater inflater;
    public SideListAdapter(List<CategoryItem> categoryItems, Context context) {
        this.categoryItems = categoryItems;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return categoryItems.size();
    }

    @Override
    public Object getItem(int position) {
        return categoryItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder =null;
        if(convertView==null) {
            holder = new Holder();
         convertView = View.inflate(context, R.layout.side_list_item, null);

            holder.tv = (TextView) convertView.findViewById(R.id.tv_side_item);
            convertView.setTag(holder);

        }else {
            holder = (Holder) convertView.getTag();
        }
        holder.tv.setText(categoryItems.get(position).getCatalog());
        return convertView;
    }
    class Holder{
        TextView tv;
    }
}
