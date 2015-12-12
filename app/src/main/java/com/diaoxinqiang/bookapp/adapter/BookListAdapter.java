package com.diaoxinqiang.bookapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.cengalabs.flatui.views.FlatAutoCompleteTextView;
import com.diaoxinqiang.bookapp.R;
import com.diaoxinqiang.bookapp.bean.Book;

import java.util.List;

/**
 * Created by Administrator on 2015/12/12.
 */
public class BookListAdapter extends BaseAdapter {
    private  List<Book> bookList;
    private  Context context;
    private LayoutInflater inflater;
    public BookListAdapter(Context context,List<Book> bookList) {
        this.bookList = bookList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return bookList.size();
    }

    @Override
    public Object getItem(int position) {
        return bookList.get(position);
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
            convertView = View.inflate(context, R.layout.lv_books_item, null);

            holder.tv = (FlatAutoCompleteTextView) convertView.findViewById(R.id.tv_book_name);
            convertView.setTag(holder);

        }else {
            holder = (Holder) convertView.getTag();
        }
        holder.tv.setText(bookList.get(position).getTitle());
        return convertView;
    }
    class Holder{
        FlatAutoCompleteTextView tv;
    }

}
