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
    public void testGetPullRequestInfo() {
        // Configurar o comportamento esperado do GitHubService mockado
        String owner = "fidelisfelipe";
        String repo = "pullrequest-boot";
        int pullRequestNumber = 123;
        Object expectedResponse = new Object(); // Suponha que o objeto de resposta esperado seja um Object qualquer

        when(gitHubService.getPullRequestInfo(owner, repo, pullRequestNumber)).thenReturn(expectedResponse);

        // Chamar o método do controlador e verificar se o resultado é o esperado
        Object actualResponse = pullRequestController.getPullRequestInfo(owner, repo, pullRequestNumber);
        assertEquals(expectedResponse, actualResponse);

        // Verificar se o método do serviço foi chamado com os parâmetros corretos
        verify(gitHubService).getPullRequestInfo(owner, repo, pullRequestNumber);
    }
}