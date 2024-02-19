package com.example.pullrequestboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PullRequest {
    private String body;
    private String title;
    private String state;
    private String authorAssociation;
    private int commits;
    private int additions;
    private int deletions;
    private int changedFiles;
}
