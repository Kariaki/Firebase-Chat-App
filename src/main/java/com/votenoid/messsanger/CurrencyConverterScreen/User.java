package com.votenoid.messsanger.CurrencyConverterScreen;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    private int userId;
    @SerializedName("name")
    private String name;
    private String email;
    private String username;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
