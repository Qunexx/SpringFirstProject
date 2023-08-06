package com.springwebapp.springwebapp.services.impl;

import com.springwebapp.springwebapp.dto.ClubDto;
import com.springwebapp.springwebapp.dto.EventDto;
import com.springwebapp.springwebapp.models.Club;
import com.springwebapp.springwebapp.models.Event;
import com.springwebapp.springwebapp.repository.ClubRepository;
import com.springwebapp.springwebapp.repository.EventRepository;
import com.springwebapp.springwebapp.services.EventService;
import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.springwebapp.springwebapp.mappers.ClubMapper.mapToClub;
import static com.springwebapp.springwebapp.mappers.EventMapper.mapToEvent;
import static com.springwebapp.springwebapp.mappers.EventMapper.mapToEventDto;

@Service
public class EventServiceImpl implements EventService {
    private EventRepository eventRepository;
    private ClubRepository clubRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository, ClubRepository clubRepository) {
        this.eventRepository = eventRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void createEvent(Integer id, EventDto eventDto) {
        Club club = clubRepository.findById(id).get();
        Event event = mapToEvent(eventDto);
        event.setClub(club);
        eventRepository.save(event);
    }

    @Override
    public List<EventDto> findAllEvents() {
        List<Event> events = eventRepository.findAll();
        return events.stream().map((event) -> mapToEventDto(event)).collect(Collectors.toList());
    }

    @Override
    public EventDto FindByEventId(Integer eventId) {
        Event event = eventRepository.findById(eventId).get();
        return mapToEventDto(event);
    }

    @Override
    public void updateEvent(EventDto eventDto) {

            Event event = mapToEvent(eventDto);
            event.setClub(eventDto.getClub());
            eventRepository.save(event);
    }
}
