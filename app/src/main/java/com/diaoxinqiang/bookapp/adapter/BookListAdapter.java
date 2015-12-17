package com.diaoxinqiang.bookapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.diaoxinqiang.bookapp.R;
import com.diaoxinqiang.bookapp.bean.Book;
import com.diaoxinqiang.bookapp.utils.DisplayUtils;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;

import java.util.List;

/**
 * Created by Administrator on 2015/12/12.
 */
public class BookListAdapter extends BaseAdapter {
    private  List<Book> bookList;
    private  Context context;
    private LayoutInflater inflater;
    private DisplayImageOptions options;
    private ImageSize imageSize;

    public BookListAdapter(Context context,List<Book> bookList) {
        this.bookList = bookList;
        this.context = context;
        inflater = LayoutInflater.from(context);
        // 使用DisplayImageOptions.Builder()创建DisplayImageOptions
        options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.loading)          // 设置图片下载期间显示的图片
                .showImageForEmptyUri(R.drawable.error)  // 设置图片Uri为空或是错误的时候显示的图片
                .showImageOnFail(R.drawable.error)       // 设置图片加载或解码过程中发生错误显示的图片
                .cacheInMemory(true)                        // 设置下载的图片是否缓存在内存中
                .cacheOnDisk(true)                          // 设置下载的图片是否缓存在SD卡中
                // 设置成圆角图片

                .build();                                   // 创建配置过得DisplayImageOption对象
        imageSize = new ImageSize(DisplayUtils.dp2px(context,50),DisplayUtils.dp2px(context,100));
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

            holder.tv = (TextView) convertView.findViewById(R.id.tv_book_name);
            holder.tv_desc = (TextView) convertView.findViewById(R.id.tv_book_desc);
            holder.iv_book = (ImageView) convertView.findViewById(R.id.iv_book_img);

            convertView.setTag(holder);

        }else {
            holder = (Holder) convertView.getTag();
        }
        holder.tv.setText("《" + bookList.get(position).getTitle() + "》");
        holder.tv_desc.setText(bookList.get(position).getSub2());
        String url = bookList.get(position).getImg();
        Log.i("adapter", url);

//        ImageLoader.getInstance().displayImage(url, holder.iv_book, options, animateFirstListener);

        ImageLoader.getInstance().loadImage(url, imageSize, options,new loadImageListener(holder.iv_book));
        return convertView;
    }
    class Holder{
        TextView tv;
        TextView tv_desc;
        ImageView iv_book;
    }
    class  loadImageListener extends  SimpleImageLoadingListener{
        private ImageView iv;

        public loadImageListener(ImageView iv) {
            this.iv = iv;
        }

        @Override
        public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
            iv.setImageBitmap(loadedImage);
        }

        @Override
        public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

            iv.setImageResource(R.drawable.error);
        }
    }

}
