package com.example.citysights;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginToken {
    @SerializedName("metadata")
    @Expose
    private String metadata;
    @SerializedName("data")
    @Expose
    private Data data;

    public String getMetadata() {
        return metadata;
    }

    public void setMetadata(String metadata) {
        this.metadata = metadata;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
