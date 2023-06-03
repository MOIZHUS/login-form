package com.example.project_android.Entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserEntity {

    @SerializedName("page")
    public Integer page;
    @SerializedName("per_page")
    public Integer perPage;
    @SerializedName("total")
    public Integer total;
    @SerializedName("total_pages")
    public Integer totalPages;
    @SerializedName("data")
    public List<Datum> data = new ArrayList<>();

    public static class Datum {

        @SerializedName("id")
        public Integer id;
        @SerializedName("first_name")
        public String firstName;
        @SerializedName("last_name")
        public String lastName;
        @SerializedName("avatar")
        public String avatar;

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public Integer getId() {
            return id;
        }

        public String getAvatar() {
            return avatar;
        }
    }

    public List<Datum> getData() {
        return data;
    }
}
