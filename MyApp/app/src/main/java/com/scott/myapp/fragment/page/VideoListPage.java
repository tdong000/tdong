package com.scott.myapp.fragment.page;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.MediaStore.Video.Media;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.scott.myapp.R;
import com.scott.myapp.activity.BaseActivity;
import com.scott.myapp.activity.MainActivity;
import com.scott.myapp.adapter.VideoListAdapter;
import com.scott.myapp.bean.VideoItem;
import com.scott.myapp.db.MobileAsyncQueryHandler;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/2/5.
 */

public class VideoListPage extends BasePage implements AdapterView.OnItemClickListener {

    private ListView mListView;
    private VideoListAdapter mAdapter;
    private MainActivity mActivity;

    public VideoListPage(BaseActivity activity) {
        super();
        this.mActivity = (MainActivity)activity;
    }

    @Override
    public int setLayoutRes() {
        return R.layout.page_video_list;
    }

    @Override
    protected void onViewCreated(View view) {
        initView(view);
        initData();
    }

    private void initData() {
        // 从MediaProvider里查询视频信息
        ContentResolver resolver =mActivity.getContentResolver();
        //        Cursor cursor = resolver.query(Media.EXTERNAL_CONTENT_URI, new String[]{Media._ID, Media.DATA, Media.TITLE, Media.SIZE, Media.DURATION}, null, null, null);

        //        CursorUtils.printCursor(cursor);
        //        mAdapter.swapCursor(cursor);

        // 使用子线程执行查询操作
        AsyncQueryHandler asyncQueryHandler = new MobileAsyncQueryHandler(resolver);
        asyncQueryHandler.startQuery(0, mAdapter, Media.EXTERNAL_CONTENT_URI, new String[]{Media._ID, Media.DATA, Media.TITLE, Media.SIZE, Media.DURATION}, null, null, null);
    }

    private void initView(View view) {
        mListView = (ListView) view.findViewById(R.id.simple_listview);
        mAdapter = new VideoListAdapter(mActivity, null);
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // 获取被点击数据
        Cursor cursor = (Cursor) parent.getItemAtPosition(position);
        //            VideoItem videoItem = VideoItem.instanceFromCursor(cursor);
        ArrayList<VideoItem> videoItems = VideoItem.instanceListFromCursor(cursor);

        // 跳转到播放界面
//        Intent intent = new Intent(, VideoPlayerActivity.class);
        //            Intent intent = new Intent(getActivity(), VitamioPlayerActivity.class);
        //            intent.putExtra("videoItem",videoItem);
//        intent.putExtra("videoItems",videoItems);
//        intent.putExtra("position",position);
//        startActivity(intent);
    }
}
