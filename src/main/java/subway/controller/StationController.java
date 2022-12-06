package subway.controller;

import subway.domain.Station;
import subway.repository.StationRepository;

public class StationController {
    public void saveStationList() {
        Station gyodae = new Station("교대역");
        Station gangnam = new Station("강남역");
        Station yeoksam = new Station("역삼역");
        Station nambu = new Station("남부터미널역");
        Station yangjae = new Station("양재역");
        Station yangjaeCitizen = new Station("양재시민의숲역");
        Station maebong = new Station("매봉역");
        StationRepository.addStation(gyodae);
        StationRepository.addStation(gangnam);
        StationRepository.addStation(yeoksam);
        StationRepository.addStation(nambu);
        StationRepository.addStation(yangjae);
        StationRepository.addStation(yangjaeCitizen);
        StationRepository.addStation(maebong);
    }
}
