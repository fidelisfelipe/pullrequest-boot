package com.example.pullrequestboot;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Interface para definir a chamada ao serviço do GitHub usando Feign
 */
@FeignClient(name = "github", url = "https://github.com")
public interface GitHubClient {

    @GetMapping("/{owner}/{repo}/pull/{pullRequestNumber}.diff")
    String getDiffPullRequest(@PathVariable("owner") String owner,
                              @PathVariable("repo") String repo,
                              @PathVariable("pullRequestNumber") int pullRequestNumber);
    @GetMapping("/{owner}/{repo}/pull/{pullRequestNumber}.patch")
    String getPatchPullRequest(@PathVariable("owner") String owner,
                              @PathVariable("repo") String repo,
                              @PathVariable("pullRequestNumber") int pullRequestNumber);

}
