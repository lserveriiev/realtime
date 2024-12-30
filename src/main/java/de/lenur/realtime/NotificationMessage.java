package de.lenur.realtime;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class NotificationMessage {

    String text;

}
