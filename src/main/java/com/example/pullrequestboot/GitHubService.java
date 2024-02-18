package com.example.pullrequestboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Serviço para usar o Feign Client e obter informações do pull request
 */

@Service
public class GitHubService {

    private final GitHubApiClient gitHubApiClient;

    public GitHubService(GitHubApiClient gitHubApiClient) {
        this.gitHubApiClient = gitHubApiClient;
    }

    public Object getOnePullRequest(String owner, String repo, int pullRequestNumber) {
        return gitHubApiClient.getOnePullRequest(owner, repo, pullRequestNumber);
    }
    public Object getAllPullRequest(String owner, String repo) {
        return gitHubApiClient.getAllPullRequest(owner, repo);
    }
}
