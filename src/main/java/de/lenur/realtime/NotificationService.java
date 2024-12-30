package de.lenur.realtime;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final SimpMessagingTemplate template;

    public void sendNotification(String message) {
        template.convertAndSend("/topic/notifications", new NotificationMessage(
                "New notification: " + message));
    }

}
