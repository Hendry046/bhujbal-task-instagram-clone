package com.example.instagram;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UserProfileAdapter extends RecyclerView.Adapter<UserProfileAdapter.ViewHolder>{

    private List<UserProfile> userProfiles;
    private Context context;
    private TextView followingCountTextView;
    private int followingCount = 0; // Initialize the following count

    public UserProfileAdapter(Context context, List<UserProfile> userProfiles, TextView followingCountTextView) {
        this.context = context;
        this.userProfiles = userProfiles;
        this.followingCountTextView = followingCountTextView; // Initialize followingCountTextView
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserProfile userProfile = userProfiles.get(position);

        // Set the name
        holder.nameTextView.setText(userProfile.getName());

        // Set the image
        holder.circleImageView.setImageResource(userProfile.getImageResourceId());

        // Set the "Follow" button text and appearance based on isFollowing
        if (userProfile.isFollowing()) {
            // User is following, set the button to "Following" state
            holder.followButton.setText("Following");
            holder.followButton.setTextColor(Color.WHITE);
            holder.followButton.setBackgroundResource(R.drawable.button_background);
        } else {
            // User is not following, set the button to "Follow" state
            holder.followButton.setText("Follow");
            holder.followButton.setTextColor(Color.WHITE);
            holder.followButton.setBackgroundResource(R.drawable.button_background);
        }

        // Handle the "Follow" button click
        holder.followButton.setOnClickListener(v -> {
            // Toggle the following status
            userProfile.toggleFollowing();

            // Update the "Follow" button text and appearance based on the new follow status
            if (userProfile.isFollowing()) {
                holder.followButton.setText("Following");
            } else {
                holder.followButton.setText("Follow");
            }

            // Update the following count based on the follow status
            if (userProfile.isFollowing()) {
                // User started following, so increment the count
                followingCount++;
            } else {
                // User stopped following, so decrement the count
                followingCount--;
            }

            // Update the following count display
            followingCountTextView.setText(followingCount + " Following");
        });
    }



    @Override
    public int getItemCount() {
        return userProfiles.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView circleImageView;
        TextView nameTextView;
        Button followButton;

        ViewHolder(View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.circleImageView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            followButton = itemView.findViewById(R.id.followButton);
        }
    }
}
