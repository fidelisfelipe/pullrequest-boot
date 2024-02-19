package com.example.pullrequestboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Serviço para usar o Feign Client e obter informações do pull request
 */

@Service
public class GitHubService {

    private final GitHubApiClient gitHubApiClient;
    private final GitHubClient gitHubClient;

    public GitHubService(GitHubApiClient gitHubApiClient, GitHubClient gitHubClient) {
        this.gitHubApiClient = gitHubApiClient;
        this.gitHubClient = gitHubClient;
    }

    public Object getOnePullRequest(String owner, String repo, int pullRequestNumber) {
        return gitHubApiClient.getOnePullRequest(owner, repo, pullRequestNumber);
    }
    public Object getAllPullRequest(String owner, String repo) {
        return gitHubApiClient.getAllPullRequest(owner, repo);
    }

    public Object getDiffPullRequest(String owner, String repo, int pullRequestNumber) {
        var diffPullRequest = gitHubClient.getDiffPullRequest(owner, repo, pullRequestNumber);

        var list = getChangedFilesFromPatches(diffPullRequest);
        //print
        list.forEach(System.out::println);

        return diffPullRequest;
    }
    public Object getPatchPullRequest(String owner, String repo, int pullRequestNumber) {
        String patchPullRequest = gitHubClient.getPatchPullRequest(owner, repo, pullRequestNumber);
        var list = getChangedFilesFromPatches(patchPullRequest);
        //print
        list.forEach(System.out::println);

        return patchPullRequest;
    }

    public static List<String> getChangedFilesFromPatches(String patches) {
        List<String> changedFiles = new ArrayList<>();

        // Expressão regular para encontrar os nomes dos arquivos alterados nos cabeçalhos de diff
        Pattern pattern = Pattern.compile("^diff --git a/(.*) b/.*$", Pattern.MULTILINE);

        // Dividir o texto dos patches em patches individuais
        String[] individualPatches = patches.split("(?m)^From .*?^$");

        // Iterar sobre cada patch e extrair os nomes dos arquivos alterados
        for (String patch : individualPatches) {
            pattern.matcher(patch).results()
                    .map(match -> match.group(1))
                    .forEach(changedFiles::add);
        }

        return changedFiles;
    }
}
