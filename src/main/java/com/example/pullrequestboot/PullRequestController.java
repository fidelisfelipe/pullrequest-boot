package com.example.pullrequestboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PullRequestController {

    private final GitHubService gitHubService;

    public PullRequestController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping("/pull-request/{owner}/{repo}/{pullRequestNumber}")
    public Object getOnePullRequest(@PathVariable String owner,
                                     @PathVariable String repo,
                                     @PathVariable int pullRequestNumber) {
        return gitHubService.getOnePullRequest(owner, repo, pullRequestNumber);
    }

    @GetMapping("/pull-request/{owner}/{repo}")
    public Object getAllPullRequest(@PathVariable String owner,
                                     @PathVariable String repo) {
        return gitHubService.getAllPullRequest(owner, repo);
    }
}
