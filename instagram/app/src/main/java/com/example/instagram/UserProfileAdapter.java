package com.example.instagram;

import static com.example.instagram.SharedPreferencesUtil.saveFollowingCount;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UserProfileAdapter extends RecyclerView.Adapter<UserProfileAdapter.ViewHolder> {

    private List<UserProfile> userProfiles;
    private Context context;
    private TextView followingCountTextView;

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
            userProfile.setFollowStatus(userProfile.isFollowing()); // Save the follow status

            // Update the "Follow" button text and appearance based on the new follow status
            if (userProfile.isFollowing()) {
                holder.followButton.setText("Following");
            } else {
                holder.followButton.setText("Follow");
            }

            // Update the following count based on the follow status
            int followingCount = calculateFollowingCount();
            followingCountTextView.setText(String.valueOf(followingCount) + " Following");

            // Save the following count and follow status in SharedPreferences
            SharedPreferencesUtil.saveFollowingCount(context, followingCount);
            SharedPreferencesUtil.saveFollowStatus(context, userProfile.getName(), userProfile.getFollowStatus());
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
    private int calculateFollowingCount() {
        int count = 0;
        for (UserProfile userProfile : userProfiles) {
            if (userProfile.isFollowing()) {
                count++;
            }
        }
        return count;
    }
}
