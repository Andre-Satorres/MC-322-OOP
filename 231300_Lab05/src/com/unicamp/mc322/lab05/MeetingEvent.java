package com.unicamp.mc322.lab05;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MeetingEvent extends Event {
    protected List<Participant> participants;

    public MeetingEvent(String description, LocalDateTime date, List<Participant> participants) {
        super(description, date);

        if (participants == null) {
            throw new IllegalArgumentException("Participants list must not be null!");
        }

        this.participants = new ArrayList<>(participants);
    }
}
