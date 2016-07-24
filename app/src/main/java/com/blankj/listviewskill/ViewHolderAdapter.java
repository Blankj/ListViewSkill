package com.blankj.listviewskill;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/*********************************************
 * author: Blankj on 2016/7/23 15:39
 * blog:   http://blankj.com
 * e-mail: blankj@qq.com
 *********************************************/
public class ViewHolderAdapter extends BaseAdapter {

    private List<String> mData;
    private LayoutInflater mInflater;

    public ViewHolderAdapter(Context context, List<String> data) {
        this.mData = data;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        // 判断是否缓存
        if (convertView == null) {
            viewHolder = new ViewHolder();
            // 通过LayoutInflater实例化布局
            convertView = mInflater.inflate(R.layout.viewholder_item, null);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.imageView);
            viewHolder.title = (TextView) convertView.findViewById(R.id.textView);
            convertView.setTag(viewHolder);
        }else {
            // 通过tag找到缓存的布局
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // 设置布局中控件要显示的视图
        viewHolder.img.setBackgroundResource(R.mipmap.ic_launcher);
        viewHolder.title.setText(mData.get(position));
        return convertView;
    }

    public final class ViewHolder {
        public ImageView img;
        public TextView title;
    }
}

