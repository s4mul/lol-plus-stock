package com.example.lol_project.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

//소환사 정보에 대한 DTO
public class SummonerDTO {

    @Id
    private String id;

    private String accountId; //계정 id
    private String puuid;
    private String name;
    private int profileIconId;
    private int summonerLevel;

    
}
