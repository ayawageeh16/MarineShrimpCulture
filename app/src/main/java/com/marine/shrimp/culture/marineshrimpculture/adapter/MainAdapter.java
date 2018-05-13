package com.marine.shrimp.culture.marineshrimpculture.adapter;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.marine.shrimp.culture.marineshrimpculture.R;
import com.marine.shrimp.culture.marineshrimpculture.data.IconModel;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    List<IconModel> iconModelList;
    OnItemClickedListener listener;

    public interface OnItemClickedListener {
        void OnItemClicked(IconModel iconModel);
    }

    public MainAdapter(List<IconModel> iconModelList, OnItemClickedListener listener) {
        this.iconModelList = iconModelList;
        this.listener = listener;
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_rv, parent, false);
        MainViewHolder holder = new MainViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        holder.bind(iconModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return iconModelList.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        Bitmap bitmap;
        byte[] img;

        public MainViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.icon_image);
            title = itemView.findViewById(R.id.title_tv);
        }

        void bind(final IconModel iconModel) {
            bitmap = iconModel.getImage();
            imageView.setImageBitmap(bitmap);
            title.setText(iconModel.getTitle());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.OnItemClicked(iconModel);
                }
            });
        }
    }
}