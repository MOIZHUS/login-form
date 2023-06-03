package com.example.project_android.Entity;



import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class UserEntity{

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
        public String first_name;
        @SerializedName("last_name")
        public String last_name;
        @SerializedName("avatar")
        public String avatar;

        public String getfstname(){
            return this.first_name;
        }
        public String getlstname(){
            return this.last_name;
        }
        public int getuser_id(){
            return this.id;
        }

        public String getImageUrl() {
            return this.avatar;
        }

    }
    public List<UserEntity.Datum> getData() {
        return data;
    }

}
