package de.lenur.realtime;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @MessageMapping("/send")
    @SendTo("/topic/notifications")
    public NotificationMessage sendNotification(NotificationMessage message) {
        log.debug("Incoming message {}", message);
        return new NotificationMessage("New notification: " + message.getText());
    }

    @PostMapping("/messages")
    public void sendNotification() {
        notificationService.sendNotification("AAAAAAA");
    }
}
