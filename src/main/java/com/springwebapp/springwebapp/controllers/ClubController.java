package com.springwebapp.springwebapp.controllers;

import com.springwebapp.springwebapp.dto.ClubDto;
import com.springwebapp.springwebapp.models.Club;
import com.springwebapp.springwebapp.services.ClubService;
import jakarta.validation.Path;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ClubController {

    private ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String listClubs(Model model){
        List<ClubDto> clubs = clubService.findAllClubs();
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }


    @GetMapping("/clubs/new")
    public String createClubForm(Model model){
        Club club = new Club();
        model.addAttribute("club",club);
        return "clubs-create";

    }

    @GetMapping("/clubs/{id}/delete")
    public String deleteClub(@PathVariable("id") Integer id)
    {
        clubService.delete(id);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/{id}")
    public String clubDetail(@PathVariable ("id") Integer id, Model model)
    {
        ClubDto clubDto = clubService.findClubById(id);
        model.addAttribute("club",clubDto);
        return "clubs-detail";

    }

    @PostMapping("/clubs/new")
    public String saveClub(@Valid @ModelAttribute("club") ClubDto clubDto,
                           BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("club",clubDto);
            return "clubs-create";
        }
        clubService.saveClub(clubDto);
        return "redirect:/clubs";
    }

     @GetMapping("/clubs/{id}/edit")
    public String editClubForm(@PathVariable ("id") Integer id, Model model){
        ClubDto club = clubService.findClubById(id);
        model.addAttribute("club",club);
        return "clubs-edit";
    }

    @PostMapping("/clubs/{id}/edit")
    public String updateClub(@PathVariable ("id") Integer id,
                             @Valid @ModelAttribute("club") ClubDto club,
                                BindingResult result, Model model)
    {
        if(result.hasErrors()) {
            model.addAttribute("club", club);
            return "clubs-edit";
        }
        club.setId(id);
        clubService.updateClub(club);
        return "redirect:/clubs";
    }

    @GetMapping("/clubs/search")
    public String searchClub(@RequestParam(value = "query") String query, Model model){
        List<ClubDto> clubs = clubService.searchClubs(query);
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }


}
