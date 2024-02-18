package com.example.pullrequestboot;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLDecoder;

@RestController
public class WebhookController {

    @PostMapping("/webhook/github")
    public void handleWebhook(@RequestBody String payload) {
        // Lógica para lidar com a notificação do webhook
        String decodedPayload = URLDecoder.decode(payload, "UTF-8");
        System.out.println("Recebida notificação do webhook do GitHub: " + decodedPayload);

    }

}
