package com.example.project_android;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project_android.Entity.UserEntity;
import com.example.project_android.placeholder.PlaceholderContent.PlaceholderItem;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MylistuserRecyclerViewAdapter extends RecyclerView.Adapter<MylistuserRecyclerViewAdapter.ViewHolder> {

    private  List<UserEntity.Datum> userList;
    public MylistuserRecyclerViewAdapter(List<UserEntity.Datum> userList) {
        this.userList = userList;
    }

//    public MylistuserRecyclerViewAdapter(List<PlaceholderItem> items) {
//        mValues = items;
//    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardlayout, parent, false);
        return new ViewHolder(view);

    }
    public void setUserList(List<UserEntity.Datum> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        UserEntity.Datum user = userList.get(position);
        holder.fstname.setText(user.getFirstName());
        holder.lstname.setText(user.getLastName());
        holder.user_id.setText(user.getId());
        // Load user image into the ImageView using a library like Picasso or Glide
//        Picasso.get.load(user.getImageUrl()).into(holder.imgs);
//        holder.mItem = mValues.get(position);
//        holder.mIdView.setText(mValues.get(position).id);
//        holder.mContentView.setText(mValues.get(position).content);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgs;
        TextView fstname,lstname,email,user_id;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgs=itemView.findViewById(R.id.imgs);
            fstname=itemView.findViewById(R.id.fstname);
            lstname=itemView.findViewById(R.id.lstname);
            user_id=itemView.findViewById(R.id.user_id);
            email=itemView.findViewById(R.id.email);
        }

//        @Override
//        public String toString() {
//            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
