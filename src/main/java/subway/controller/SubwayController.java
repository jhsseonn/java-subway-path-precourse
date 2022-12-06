package subway.controller;

import subway.repository.SubwayRepository;

import java.util.ArrayList;
import java.util.List;

public class SubwayController {
    public void saveEdgeList() {
        String[] gyodae_gangnam={"교대역", "강남역", "2km / 3분"};
        String[] gangnam_yeoksam={"강남역", "역삼역", "2km / 3분"};
        String[] gyodae_nambu={"교대역", "남부터미널역", "3km / 2분"};
        String[] nambu_yangjae={"남부터미널역", "양재역", "6km / 5분"};
        String[] yangjae_maebong={"양재역", "매봉역", "1km / 1분"};
        String[] gangnam_yangjae={"강남역", "양재역", "2km / 8분"};
        String[] yangjae_yangjaeCitizen={"양재역", "양재시민의숲역", "10km / 3분"};

        SubwayRepository.addEdge(gyodae_gangnam);
        SubwayRepository.addEdge(gangnam_yeoksam);
        SubwayRepository.addEdge(gyodae_nambu);
        SubwayRepository.addEdge(nambu_yangjae);
        SubwayRepository.addEdge(yangjae_maebong);
        SubwayRepository.addEdge(gangnam_yangjae);
        SubwayRepository.addEdge(yangjae_yangjaeCitizen);
    }
}
