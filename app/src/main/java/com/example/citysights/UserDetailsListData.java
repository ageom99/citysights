package com.example.citysights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UserDetailsListData {

    @SerializedName("metadata")
    @Expose
    private Object metadata;
    @SerializedName("data")
    @Expose
    private List<UserDetailsPOJO> UserDetailsPOJO = null;

    public Object getMetadata() {
        return metadata;
    }

    public void setMetadata(Object metadata) {
        this.metadata = metadata;
    }

    public List<UserDetailsPOJO> getData() {
        return UserDetailsPOJO;
    }

    public void setData(List<UserDetailsPOJO> data) {
        this.UserDetailsPOJO = UserDetailsPOJO;
    }
}

