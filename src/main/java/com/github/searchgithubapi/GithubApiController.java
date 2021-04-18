package com.github.searchgithubapi;

import com.github.searchgithubapi.domain.Commits;
import com.github.searchgithubapi.domain.ProjectRepo;
import com.github.searchgithubapi.domain.ResultRepo;
import com.github.searchgithubapi.domain.User;
import com.github.searchgithubapi.service.ParsingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
public class GithubApiController {
    private static final String JSON_GITHUB_SEARCH_REPOSITORIES = "https://api.github.com/search/repositories?q=";
    private static final String JSON_GITHUB_REPOS = "https://api.github.com/repos/";


    @Autowired
    private ParsingService parsingService;

    /**
     * This is used to search public repositories using the input data given by the user.
     * @param projName
     * @return Collection data of public repositories in JSON format
     */
    @GetMapping("/search/{proj}/repositories")
    public Collection<ResultRepo> searchRepositories(@PathVariable(name="proj") String projName){
        System.out.println("Enter searchRepositories");
        StringBuilder sb = new StringBuilder();
        sb.append(JSON_GITHUB_SEARCH_REPOSITORIES).append(projName);
        LinkedHashMap<ResultRepo, ResultRepo> repositories = (LinkedHashMap<ResultRepo, ResultRepo>) parsingService.parse(sb.toString());
        Collection<ResultRepo> repos = repositories.values();
        System.out.println("End searchRepositories");
        return repos;
    }

    /**
     * This is used to get the List of Contributors of the selected repository.
     * @param ownerName
     * @param projectName
     * @return List of Contributors in JSON format
     */
    @GetMapping("/search/committers/{owner}/{project}")
    public List<User> getCommitters(@PathVariable(name="owner") String ownerName, @PathVariable(name="project") String projectName){
        System.out.println("Enter getCommitters");
        StringBuilder sb = new StringBuilder();
        sb.append(JSON_GITHUB_REPOS).append(ownerName).append("/").append(projectName).append("/contributors");
        List<User> users = (List<User>) parsingService.parse(sb.toString());
        System.out.println("End getCommitters");
        return users;
    }

    /**
     * This is used to get the data of the latest 100 commits in the selected repository
     * @param ownerName
     * @param projectName
     * @return List of latest 100 commits in JSON format
     */
    @GetMapping("/search/commits/{owner}/{project}")
    public List<Commits> getCommits(@PathVariable(name="owner") String ownerName, @PathVariable(name="project") String projectName){
        System.out.println("Enter getCommits");
        StringBuilder sb = new StringBuilder();
        sb.append(JSON_GITHUB_REPOS).append(ownerName).append("/").append(projectName).append("/commits?per_page=100");
        List<Commits> commits = (List<Commits>) parsingService.parse(sb.toString());
        System.out.println("End getCommits");
        return commits;
    }


}
