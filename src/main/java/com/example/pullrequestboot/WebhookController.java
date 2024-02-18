package com.example.pullrequestboot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebhookController {

    @PostMapping("/webhook/github")
    public void handleWebhook(@RequestBody String payload) {
        // Lógica para lidar com a notificação do webhook
        System.out.println("Recebida notificação do webhook do GitHub: " + payload);

    }

}
