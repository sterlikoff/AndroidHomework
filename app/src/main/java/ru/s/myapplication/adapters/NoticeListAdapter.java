package ru.s.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import ru.s.myapplication.R;
import ru.s.myapplication.model.Notice;

public class NoticeListAdapter extends BaseAdapter {

    private List<Notice> noticeList;
    private LayoutInflater inflater;
    private Context context;
    private File file;

    private void saveData() {

        FileWriter writer = null;
        try {

            writer = new FileWriter(file);

            for (int i = 0; i < noticeList.size(); i++) {
                writer.append(noticeList.get(i).toLine());
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public NoticeListAdapter(List<Notice> noticeList, Context context) {

        this.noticeList = noticeList;
        this.context = context;
        this.inflater = LayoutInflater.from(this.context);
        this.file = new File(context.getExternalFilesDir(""), "notices.txt");

    }

    @Override
    public int getCount() {
        return this.noticeList != null ? this.noticeList.size() : 0;
    }

    @Override
    public Notice getItem(int position) {
        return this.noticeList != null ? this.noticeList.get(position) : null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View currentView;
        final int currentPosition = position;
        final NoticeListAdapter adapter = this;

        if (convertView != null) {
            currentView = convertView;
        } else {
            currentView = this.inflater.inflate(R.layout.notice_list_item, parent, false);
        }

        final TextView titleView = currentView.findViewById(R.id.title_view);
        TextView addressView = currentView.findViewById(R.id.address_view);
        TextView priceView = currentView.findViewById(R.id.price_view);
        TextView descriptionView = currentView.findViewById(R.id.description_view);
        ImageView imageView = currentView.findViewById(R.id.image_view);
        Button deleteButton = currentView.findViewById(R.id.delete_button);

        deleteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                noticeList.remove(currentPosition);
                adapter.notifyDataSetChanged();
                saveData();

            }

        });

        Notice notice = getItem(position);

        if (notice != null) {

            titleView.setText(notice.getTitle());
            addressView.setText(notice.getAddress());
            priceView.setText(notice.getPrice().toString());
            descriptionView.setText(notice.getDescription());
            imageView.setBackgroundResource(R.drawable.ic_launcher_background);

        }

        currentView.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {

                Toast.makeText(context, titleView.getText(), Toast.LENGTH_LONG).show();

                return false;
            }

        });

        return currentView;

    }

}
