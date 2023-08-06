package com.springwebapp.springwebapp.mappers;

import com.springwebapp.springwebapp.dto.ClubDto;
import com.springwebapp.springwebapp.models.Club;

import java.util.stream.Collectors;

import static com.springwebapp.springwebapp.mappers.EventMapper.mapToEventDto;

public class ClubMapper {

    public static Club mapToClub(ClubDto club)
    {
        return Club.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .build();
    }

    public static ClubDto mapToClubDto(Club club){
        return ClubDto.builder()
                .id(club.getId())
                .title(club.getTitle())
                .photoUrl(club.getPhotoUrl())
                .content(club.getContent())
                .createdOn(club.getCreatedOn())
                .updatedOn(club.getUpdatedOn())
                .events(club.getEvents().stream().map((event) -> mapToEventDto(event)).collect(Collectors.toList()))
                        .build();

    }
}
