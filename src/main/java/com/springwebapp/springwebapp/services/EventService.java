package com.springwebapp.springwebapp.services;

import com.springwebapp.springwebapp.dto.EventDto;

import java.util.List;

public interface EventService   {
    void createEvent(Integer id, EventDto eventDto);

    List<EventDto> findAllEvents();

    EventDto FindByEventId(Integer eventId);
    void updateEvent(EventDto eventDto);


}
