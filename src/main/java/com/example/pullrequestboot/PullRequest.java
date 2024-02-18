package com.example.pullrequestboot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PullRequest {
    private String body;
    private int changedFiles;
}
