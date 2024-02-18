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

    public Object getPullRequestInfo(String owner, String repo, int pullRequestNumber) {
        return gitHubApiClient.getPullRequestInfo(owner, repo, pullRequestNumber);
    }
}
