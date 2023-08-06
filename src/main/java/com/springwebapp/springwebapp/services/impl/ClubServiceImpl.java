package com.springwebapp.springwebapp.services.impl;

import com.springwebapp.springwebapp.dto.ClubDto;
import com.springwebapp.springwebapp.models.Club;
import com.springwebapp.springwebapp.repository.ClubRepository;
import com.springwebapp.springwebapp.services.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.springwebapp.springwebapp.mappers.ClubMapper.mapToClub;
import static com.springwebapp.springwebapp.mappers.ClubMapper.mapToClubDto;


@Service
public class ClubServiceImpl implements ClubService {
    final private ClubRepository clubRepository;



    @Autowired
    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public List<ClubDto> findAllClubs() {
        List<Club> clubs = clubRepository.findAll();
        return clubs.stream().map((club) -> mapToClubDto(club)).collect(Collectors.toList());
    }

    @Override
    public Club saveClub(ClubDto clubDto) {
        Club club =mapToClub(clubDto);
        return clubRepository.save(club);
    }

    @Override
    public ClubDto findClubById(Integer id) {
         Club club = clubRepository.findById(id).get();
         return mapToClubDto(club);
    }

    @Override
    public void updateClub(ClubDto clubDto) {
        Club club = mapToClub(clubDto);
        clubRepository.save(club);
    }

    @Override
    public void delete(Integer id) {
        clubRepository.deleteById(id);
    }

    @Override
    public List<ClubDto> searchClubs(String query) {
        List<Club> clubs = clubRepository.searchClubs(query);
        return clubs.stream().map(club -> mapToClubDto(club)).collect(Collectors.toList());
    }


}
