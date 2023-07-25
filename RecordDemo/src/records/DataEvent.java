package records;

import java.time.LocalDateTime;
import java.util.UUID;

public record DataEvent<T>(String eventId, LocalDateTime timestamp, T payload) {

    public DataEvent(final T payload) {
        this(UUID.randomUUID().toString(), LocalDateTime.now(), payload);
    }
}
