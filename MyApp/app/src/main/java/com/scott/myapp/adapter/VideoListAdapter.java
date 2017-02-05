package com.scott.myapp.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.text.format.Formatter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.scott.myapp.R;
import com.scott.myapp.bean.VideoItem;
import com.scott.myapp.util.StringUtils;

/**
 * Created by Administrator on 2017/2/5.
 */
public class VideoListAdapter extends CursorAdapter {


    public VideoListAdapter(Context context, Cursor c) {
        super(context, c);
    }

    public VideoListAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    public VideoListAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        // 生成新的 view
        View view = View.inflate(context, R.layout.media_video_list_item, null);
        ViewHoder hoder = new ViewHoder(view);
        view.setTag(hoder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // 填充 view
        ViewHoder hoder = (ViewHoder) view.getTag();

        VideoItem videoItem = VideoItem.instanceFromCursor(cursor);

        hoder.tv_title.setText(videoItem.getTitle());
        hoder.tv_duration.setText(StringUtils.formatDuration(videoItem.getDuration()));
        hoder.tv_size.setText(Formatter.formatFileSize(context, videoItem.getSize()));
    }

    private class ViewHoder {
        TextView tv_title, tv_duration, tv_size;

        public ViewHoder(View root) {
            tv_title = (TextView) root.findViewById(R.id.media_video_item_tv_title);
            tv_duration = (TextView) root.findViewById(R.id.media_video_item_tv_duration);
            tv_size = (TextView) root.findViewById(R.id.media_video_item_tv_size);
        }
    }
}
