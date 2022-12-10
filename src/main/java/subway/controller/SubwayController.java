package subway.controller;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.Application;
import subway.config.InputView;
import subway.config.OutputView;
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

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void saveEdgeList() {
        String[] gyodae_gangnam={"교대역", "강남역", "2/3"};
        String[] gangnam_yeoksam={"강남역", "역삼역", "2/3"};
        String[] gyodae_nambu={"교대역", "남부터미널역", "3/2"};
        String[] nambu_yangjae={"남부터미널역", "양재역", "6/5"};
        String[] yangjae_maebong={"양재역", "매봉역", "1/1"};
        String[] gangnam_yangjae={"강남역", "양재역", "2/8"};
        String[] yangjae_yangjaeCitizen={"양재역", "양재시민의숲역", "10/3"};

        SubwayRepository.addEdge(gyodae_gangnam);
        SubwayRepository.addEdge(gangnam_yeoksam);
        SubwayRepository.addEdge(gyodae_nambu);
        SubwayRepository.addEdge(nambu_yangjae);
        SubwayRepository.addEdge(yangjae_maebong);
        SubwayRepository.addEdge(gangnam_yangjae);
        SubwayRepository.addEdge(yangjae_yangjaeCitizen);
    }

    public void getFeatMainNumber() {
        outputView.printMain();
        outputView.printInputChoice();
    }

    public void setFeatMainNumber(String feat) {
        if (feat.equals("1")) {
            getPathStandard();
        }
        if (feat.equals("Q")) {
            System.exit(1);
        }
    }

    public void getPathStandard() {
        outputView.printGraphStandard();
        outputView.printInputChoice();
    }

    public void setPathStandard(String pathStandard) {
        if(pathStandard.equals("1")) {

        }
        if(pathStandard.equals("2")) {

        }
        if(pathStandard.equals("B")) {

        }
    }

    public void getShortestPath(String start, String destination, String pathStandard) {

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(setSubwayGraph(pathStandard));
        List<String> shortestPath = dijkstraShortestPath.getPath("v3", "v1").getVertexList();
    }

    public WeightedMultigraph<String, DefaultWeightedEdge> setSubwayGraph(String pathStandard) {
        lineController.saveLineList();
        stationController.saveStationList();
        saveEdgeList();
        List<String> lineNames = getLinesName(LineRepository.lines());
        List<String> stationNames = getStationName(StationRepository.stations());
        List<String[]> subwayEdges = SubwayRepository.edges();

        WeightedMultigraph<String, DefaultWeightedEdge> subwayGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
        addVertexSubway(stationNames, subwayGraph);
        setEdgeWeightSubway(subwayEdges, subwayGraph, pathStandard);

        return subwayGraph;
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

    public void setEdgeWeightSubway(List<String[]> subwayEdges, WeightedMultigraph<String, DefaultWeightedEdge> subwayGraph, String graphStandard) {
        for (String[] edge: subwayEdges) {
            String[] distance = edge[2].split("/");
            if (graphStandard.equals("1")) {
                subwayGraph.setEdgeWeight(subwayGraph.addEdge(edge[0], edge[1]), Integer.parseInt(distance[0]));
            }
            if (graphStandard.equals("2")) {
                subwayGraph.setEdgeWeight(subwayGraph.addEdge(edge[0], edge[1]), Integer.parseInt(distance[1]));
            }
        }
    }




}
