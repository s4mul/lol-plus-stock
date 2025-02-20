package com.example.lol_project.home;

import com.example.lol_project.domain.SummonerDTO;
import com.example.lol_project.service.RiotApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/summoner")
public class SummonerController {

    private final RiotApiService riotApiService;

    public SummonerController(RiotApiService riotApiService) {
        this.riotApiService = riotApiService;
    }

    @GetMapping("/{gameName}/{tagLine}")
    public String getSummoner(@PathVariable String gameName, @PathVariable String tagLine, Model model){
        SummonerDTO summonerDTO = riotApiService.getSummonerByName(gameName, tagLine);
        model.addAttribute("summoner", summonerDTO);
        return "summoner.html"; //summoner.html 템플릿을 반환
    }
}
