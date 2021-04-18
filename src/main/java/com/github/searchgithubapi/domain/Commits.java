package com.github.searchgithubapi.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties
public class Commits {

    private List<Commit> commit;
    private List<User> author;

    public List<Commit> getCommit() {
        return commit;
    }

    public void setCommit(List<Commit> commit) {
        this.commit = commit;
    }

    public List<User> getAuthor() {
        return author;
    }

    public void setAuthor(List<User> author) {
        this.author = author;
    }
}
