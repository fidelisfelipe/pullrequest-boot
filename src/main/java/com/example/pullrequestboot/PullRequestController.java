package com.example.pullrequestboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PullRequestController {

    private final GitHubService gitHubService;

    public PullRequestController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    @GetMapping("/pull-request/{owner}/{repo}/{pullRequestNumber}")
    public PullRequest getOnePullRequest(@PathVariable String owner,
                                     @PathVariable String repo,
                                     @PathVariable int pullRequestNumber) {
        PullRequest  pullRequestInfo = (PullRequest) gitHubService.getOnePullRequest(owner, repo, pullRequestNumber);

        return pullRequestInfo;
    }

    @GetMapping("/pull-request/{owner}/{repo}")
    public Object getAllPullRequest(@PathVariable String owner,
                                     @PathVariable String repo) {
        return gitHubService.getAllPullRequest(owner, repo);
    }

    //obter o diff do pull request
    @GetMapping("/pull-request/{owner}/{repo}/{pullRequestNumber}/diff")
    public Object getDiffPullRequest(@PathVariable String owner,
                                     @PathVariable String repo,
                                     @PathVariable int pullRequestNumber) {
        return gitHubService.getDiffPullRequest(owner, repo, pullRequestNumber);
    }
    @GetMapping("/pull-request/{owner}/{repo}/{pullRequestNumber}/patch")
    public Object getPatchPullRequest(@PathVariable String owner,
                                     @PathVariable String repo,
                                     @PathVariable int pullRequestNumber) {
        return gitHubService.getPatchPullRequest(owner, repo, pullRequestNumber);
    }

}
