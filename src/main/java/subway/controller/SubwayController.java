package subway.controller;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;
import subway.repository.StationRepository;
import subway.repository.SubwayRepository;

import java.util.ArrayList;
import java.util.List;

public class SubwayController {

    LineController lineController = new LineController();
    StationController stationController = new StationController();

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

    public void setSubwayGraph() {
        lineController.saveLineList();
        stationController.saveStationList();
        saveEdgeList();
        List<String> lineNames = getLinesName(LineRepository.lines());
        List<String> stationNames = getStationName(StationRepository.stations());

        WeightedMultigraph<String, DefaultWeightedEdge> subwayGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
        addVertexSubway(stationNames, subwayGraph);

    }

    public List<String> getLinesName(List<Line> lines) {
        List<String> lineNames = new ArrayList<>();
        for (Line line: lines) {
            String name = line.getName();
            lineNames.add(name);
        }

        return lineNames;
    }

    public List<String> getStationName(List<Station> stations) {
        List<String> stationNames = new ArrayList<>();
        for (Station station: stations) {
            String name = station.getName();
            stationNames.add(name);
        }
        return stationNames;
    }


    public void addVertexSubway(List<String> stationNames, WeightedMultigraph<String, DefaultWeightedEdge> subwayGraph) {
        for (String stationName: stationNames) {
            subwayGraph.addVertex(stationName);
        }
    }


}
