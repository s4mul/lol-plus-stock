package com.example.lol_project.service;

import com.example.lol_project.domain.SummonerDTO;
import com.example.lol_project.repository.SummonerRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class RiotApiService {

    private final RestTemplate restTemplate;
    private final SummonerRepository summonerRepository;

    @Value("${riot.api.key}")
    private String apiKey;

    @Value("${riot.api.account-url")
    private String accountUrl;

    @Value("${riot.api.summoner-url}")
    private String summonerUrl;

    public RiotApiService(SummonerRepository summonerRepository){
        this.restTemplate = new RestTemplate();
        this.summonerRepository = summonerRepository;
    }

    //RIOT ID로 PUUID 가져오기
    public String getPuuidByRiotId(String gameName, String tagLine){
        String url=accountUrl+"/"+gameName+tagLine+"?api_key="+apiKey;

        Map response = restTemplate.getForObject(url, Map.class);
        if(response==null || !response.containsKey("puuid")){
            throw new RuntimeException("PUUID를 불러올수없습니다.");
        }

        return response.get("puuid").toString();
    }

    // 🔹 2️⃣ PUUID로 소환사 정보 가져오기
    public SummonerDTO getSummonerByPuuid(String puuid) {
        String url = summonerUrl + "/" + puuid + "?api_key=" + apiKey;

        Map response = restTemplate.getForObject(url, Map.class);
        if (response == null || !response.containsKey("id")) {
            throw new RuntimeException("소환사 정보를 불러올 수 없습니다.");
        }

        SummonerDTO summoner = new SummonerDTO();
        summoner.setId(response.get("id").toString());
        summoner.setPuuid(response.get("puuid").toString());
        summoner.setName(response.get("name").toString());
        summoner.setProfileIconId((int) response.get("profileIconId"));
        summoner.setSummonerLevel((int) response.get("summonerLevel"));

        return summonerRepository.save(summoner);
    }

    //  최종적으로 닉네임으로 소환사 정보 가져오기
    public SummonerDTO getSummonerByName(String gameName, String tagLine) {
        String puuid = getPuuidByRiotId(gameName, tagLine);
        return getSummonerByPuuid(puuid);
    }
}
