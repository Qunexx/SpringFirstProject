package com.springwebapp.springwebapp.services;

import com.springwebapp.springwebapp.dto.ClubDto;
import com.springwebapp.springwebapp.models.Club;

import java.util.List;

public interface ClubService {
    List<ClubDto> findAllClubs();
    Club saveClub(ClubDto clubDto);

    ClubDto findClubById(Integer id);

    void updateClub(ClubDto club);

    void delete(Integer id);
    List<ClubDto> searchClubs(String query);
}
