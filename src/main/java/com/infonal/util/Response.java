package com.infonal.util;

/**
 * Created by hikuley on 21.08.2015.
 */
public class Response {

    private ResponseStatus status;
    private String description;

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
