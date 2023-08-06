package com.springwebapp.springwebapp.mappers;

import com.springwebapp.springwebapp.dto.EventDto;
import com.springwebapp.springwebapp.models.Event;

public class EventMapper {

    public static Event mapToEvent(EventDto eventDto)
    {
        return Event.builder()
                .eventId(eventDto.getEventId())
                .name(eventDto.getName())
                .startTime(eventDto.getStartTime())
                .endTime(eventDto.getEndTime())
                .type(eventDto.getType())
                .photoUrl(eventDto.getPhotoUrl())
                .createdOn(eventDto.getCreatedOn())
                .updatedOn(eventDto.getUpdatedOn())
                .build();
    }

    public static EventDto mapToEventDto(Event event)
    {
        return EventDto.builder()
                .eventId(event.getEventId())
                .name(event.getName())
                .startTime(event.getStartTime())
                .endTime(event.getEndTime())
                .type(event.getType())
                .photoUrl(event.getPhotoUrl())
                .createdOn(event.getCreatedOn())
                .updatedOn(event.getUpdatedOn())
                .club(event.getClub())
                .build();
    }
}
