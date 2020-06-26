package com.example.retrofitdemoapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersAdapterVH> {

    private List<UserResponse> userResponseList = new ArrayList<>();
    private Context context;
    private ClickedItem clickedItem;

    public UsersAdapter(ClickedItem clickedItem) {
        this.clickedItem = clickedItem;
    }

    public void setData(List<UserResponse> userResponseList) {
        this.userResponseList = userResponseList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UsersAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new UsersAdapter.UsersAdapterVH(LayoutInflater.from(context).inflate(R.layout.row_users, parent, false));

    }

    @Override
    public void onBindViewHolder(@NonNull UsersAdapterVH holder, int position) {

        UserResponse userResponse = userResponseList.get(position);
        String username = userResponse.getUsername();
        String prefix;
        if (userResponse.isIs_active() && username.length() > 1) {
            prefix = username.substring(0,2).toUpperCase();
        } else {
            prefix = username.substring(0,1).toUpperCase();
        }

        holder.prefix.setText(prefix);
        holder.username.setText(username.toUpperCase());
        holder.imageMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedItem.ClickedUser(userResponse);
            }
        });

    }

    public interface ClickedItem {
        public void ClickedUser(UserResponse userResponse);
    }

    @Override
    public int getItemCount() {
        return userResponseList.size();
    }

    public class UsersAdapterVH extends RecyclerView.ViewHolder {

        TextView username;
        TextView prefix;
        ImageView imageMore;

        public UsersAdapterVH(@NonNull View itemView) {
            super(itemView);
            username = itemView.findViewById(R.id.username);
            prefix = itemView.findViewById(R.id.prefix);
            imageMore = itemView.findViewById(R.id.imageMore);
        }
    }
}
