package com.blankj.listviewskill;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView mListView;
    ViewHolderAdapter mAdapter;
    ArrayList<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);
        mData = new ArrayList<>();
        for (int i = 0; i < 20; ++i) {
            mData.add(i + "");
        }
        mAdapter = new ViewHolderAdapter(this, mData);
        mListView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
        mListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        // 触摸时操作
                        break;
                    case MotionEvent.ACTION_MOVE:
                        // 移动时操作
                        break;
                    case MotionEvent.ACTION_UP:
                        // 离开时操作
                        break;
                }
                return false;
            }
        });
        mListView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                switch (scrollState) {
                    case SCROLL_STATE_IDLE:
                        // 滑动停止时
                        Log.d("Test", "SCROLL_STATE_IDLE");
                        break;
                    case SCROLL_STATE_TOUCH_SCROLL:
                        // 正在滚动
                        Log.d("Test", "SCROLL_STATE_TOUCH_SCROLL");
                        break;
                    case SCROLL_STATE_FLING:
                        // 手指抛动时，即手指用力滑动
                        // 在离开后ListView由于惯性继续滑动
                        Log.d("Test", "SCROLL_STATE_FLING");
                        break;
                }
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                // 滚动时一直调用
                Log.d("Test", "onScroll");
                if (firstVisibleItem + visibleItemCount == totalItemCount && totalItemCount > 0) {
                    Log.d("Test", "滚动到最后一行");
                }
                if(firstVisibleItem > lastVisibleItem){
                    // 上滑
                }else if(firstVisibleItem < lastVisibleItem){
                    // 下滑
                }
                lastVisibleItem = firstVisibleItem;
            }
        });
        // 获取可视区域内最后一个Item的id
        mListView.getLastVisiblePosition();
        // 获取可视区域内第一个Item的id
        mListView.getFirstVisiblePosition();
    }

    int lastVisibleItem;

    public void btnAdd(View view) {
        mData.add("new");
        mAdapter.notifyDataSetChanged();
        mListView.setSelection(mData.size() - 1);
    }
}
