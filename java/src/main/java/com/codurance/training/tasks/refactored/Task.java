package com.codurance.training.tasks.refactored;

import com.codurance.training.tasks.refactored.util.Util;

import java.util.Date;

public final class Task {
    private final String id;
    private final String description;
    private boolean done;

    private String deadLineDate;

    private String createdDate;

    public Task(String id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
        this.createdDate = Util.dateToString(new Date());
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getDeadLineDate() {
        return deadLineDate;
    }

    public void setDeadLineDate(String deadLineDate) {
        this.deadLineDate = deadLineDate;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
