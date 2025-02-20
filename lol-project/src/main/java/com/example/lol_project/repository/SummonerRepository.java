package com.example.lol_project.repository;

import com.example.lol_project.domain.SummonerDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SummonerRepository extends JpaRepository<SummonerDTO, String> {
    SummonerDTO findByName(String name);

    //JPA를 이용하여 소환사 정보를 저장하고 조회
    //findByName(String name)을 이용해 소환사 이름으로 검색 가능
}
