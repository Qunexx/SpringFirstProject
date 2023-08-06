package com.springwebapp.springwebapp.controllers;

import com.springwebapp.springwebapp.dto.ClubDto;
import com.springwebapp.springwebapp.dto.EventDto;
import com.springwebapp.springwebapp.models.Event;
import com.springwebapp.springwebapp.services.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EventController {

    private EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events/{id}/new")
    public String createEventForm(@PathVariable("id") Integer id, Model model){
        Event event = new Event();
        model.addAttribute("id",id);
        model.addAttribute("event",event);
        return "events-create";

    }
    @GetMapping("/events")
    public String eventList(Model model){
        List<EventDto> events = eventService.findAllEvents();
        model.addAttribute("events", events);
        return "events-list";

    }

    @GetMapping("/events/{eventId}")
    public String viewEvent(@PathVariable("eventId") Integer eventId, Model model){
        EventDto eventDto = eventService.FindByEventId(eventId);
        model.addAttribute("event",eventDto);
        return "events-detail";
            }

    @GetMapping("/events/{eventId}/edit")
    public String editEventForm(@PathVariable ("eventId") Integer eventId, Model model){
        EventDto eventDto = eventService.FindByEventId(eventId);
        model.addAttribute("event", eventDto);
        return "events-edit";
    }

    @PostMapping("/events/{id}")
    public String createEvent(@PathVariable("id") Integer id, @ModelAttribute("event") EventDto eventDto,
            BindingResult result
            ,Model model) {
        if(result.hasErrors()) {
            model.addAttribute("event",eventDto);
            return "events-edit";
        }
        eventService.createEvent(id, eventDto);
        return "redirect:/clubs/" + id;
    }

      @PostMapping("/events/{eventId}/edit")
    public String updateEvent(@PathVariable("eventId") Integer eventId,
                @Valid @ModelAttribute("event") EventDto event,
                //BindingResult result,
      Model model)
    {
       // if(result.hasErrors()) {
        //    model.addAttribute("event",event);
      //      return "events-edit";
       // }
        EventDto eventDto = eventService.FindByEventId(eventId);
        event.setEventId(eventId);
        event.setClub(eventDto.getClub());
        eventService.updateEvent(event);
        return "redirect:/events";
    }


}
