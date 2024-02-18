package com.example.pullrequestboot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PullRequestControllerTest {

    @Mock
    private GitHubService gitHubService;

    @InjectMocks
    private PullRequestController pullRequestController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetOnePullRequest() {
        // Configurar o comportamento esperado do GitHubService mockado
        String owner = "fidelisfelipe";
        String repo = "pullrequest-boot";
        int pullRequestNumber = 123;
        Object expectedResponse = new Object(); // Suponha que o objeto de resposta esperado seja um Object qualquer

        when(gitHubService.getOnePullRequest(owner, repo, pullRequestNumber)).thenReturn(expectedResponse);

        // Chamar o método do controlador e verificar se o resultado é o esperado
        Object actualResponse = pullRequestController.getOnePullRequest(owner, repo, pullRequestNumber);
        assertEquals(expectedResponse, actualResponse);

        // Verificar se o método do serviço foi chamado com os parâmetros corretos
        verify(gitHubService).getOnePullRequest(owner, repo, pullRequestNumber);
    }

    @Test
    public void testGetAllPullRequest() {
        // Configurar o comportamento esperado do GitHubService mockado
        String owner = "fidelisfelipe";
        String repo = "pullrequest-boot";

        Object expectedResponse = new Object(); // Suponha que o objeto de resposta esperado seja um Object qualquer

        when(gitHubService.getAllPullRequest(owner, repo)).thenReturn(expectedResponse);

        // Chamar o método do controlador e verificar se o resultado é o esperado
        Object actualResponse = pullRequestController.getAllPullRequest(owner, repo);
        assertEquals(expectedResponse, actualResponse);

        // Verificar se o método do serviço foi chamado com os parâmetros corretos
        verify(gitHubService).getAllPullRequest(owner, repo);
    }
}