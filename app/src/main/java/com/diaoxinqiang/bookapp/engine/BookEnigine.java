package com.diaoxinqiang.bookapp.engine;

import android.content.Context;

import com.diaoxinqiang.bookapp.utils.ConnectUtil;
import com.diaoxinqiang.bookapp.utils.Constant;
import com.diaoxinqiang.bookapp.utils.UrlUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2015/12/11.
 */
public class BookEnigine {
    private Context context;

    public BookEnigine(Context context) {
        this.context = context;
    }
    public void getBook(String catalog_id,int start,int count){
        String result =null;
        String url = Constant.BOOKURL;//请求接口地址
        Map<String, Object> params = new HashMap<String, Object>();//请求参数
        params.put("key",Constant.KEY);//应用APPKEY(应用详细页查询)
        params.put("catalog_id",catalog_id);//目录编号
        params.put("pn",start+"");//数据返回起始
        params.put("rn",count+"");//数据返回条数，最大30
        url=url+"?"+ UrlUtil.urlencode(params);
        ConnectUtil.getInstance(context).connectToGetBooks(url);
    }
}
