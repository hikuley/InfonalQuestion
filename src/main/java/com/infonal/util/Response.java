package com.infonal.util;

import java.util.List;

/**
 * Created by hikuley on 21.08.2015.
 */
public class Response {

    private boolean status;
    private String description;
    private List<Object> data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
