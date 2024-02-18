package com.example.pullrequestboot;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Interface para definir a chamada ao serviço da API do GitHub usando Feign
 */
@FeignClient(name = "github-api", url = "https://api.github.com")
public interface GitHubApiClient {

    @GetMapping("/repos/{owner}/{repo}/pulls")
    Object getAllPullRequest(@PathVariable("owner") String owner,
                              @PathVariable("repo") String repo);

    @GetMapping("/repos/{owner}/{repo}/pulls/{pullRequestNumber}")
    Object getOnePullRequest(@PathVariable("owner") String owner,
                              @PathVariable("repo") String repo,
                              @PathVariable("pullRequestNumber") int pullRequestNumber);
}
