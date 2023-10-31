package com.example.instagram;

public class UserProfile {
    private String name;
    private int imageResourceId;
    private boolean followStatus;
    private boolean isFollowing;
    private String userId; // Add a unique user identifier

    public void setName(String name) {
        this.name = name;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public boolean isFollowStatus() {
        return followStatus;
    }

    public void setFollowStatus(boolean followStatus) {
        this.followStatus = followStatus;
    }

    public UserProfile(String userId, String name, int imageResourceId) {
        this.userId = userId;
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.followStatus = false;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isFollowing() {
        return isFollowing;
    }



    public String getName() {

        return name;
    }

    public int getImageResourceId() {

        return imageResourceId;
    }


    public void toggleFollowStatus() {
        followStatus = !followStatus;
    }
    public void toggleFollowing() {
        isFollowing = !isFollowing;
    }


    public boolean getFollowStatus() {
        return followStatus;
    }



}
