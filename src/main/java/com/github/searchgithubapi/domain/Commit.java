package com.github.searchgithubapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties
public class Commit {

    private List<CommitAuthor> author;
    private String message;

    public List<CommitAuthor> getAuthor() {
        return author;
    }

    public void setAuthor(List<CommitAuthor> author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
