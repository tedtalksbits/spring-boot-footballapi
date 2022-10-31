package com.tedaneblake.footballapi.Model;

import java.time.Instant;
import java.util.List;

public class Response {

    private String status;
    private String message;
    private List<Team> data;
    private String path;
    // timestamp field

    private Instant timestamp;

    public Response() {
    }

    public Response(String status, String message, List<Team> data, String path, Instant timestamp) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.path = path;
        this.timestamp = timestamp;
    }

    public Response(String status, String message, List<Team> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Response(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Team> getData() {
        return this.data;
    }

    public void setData(List<Team> data) {
        this.data = data;
    }

    public String getPath() {
        return this.path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Instant getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }
}
