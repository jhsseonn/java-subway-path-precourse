package subway.controller;

import subway.domain.Line;
import subway.repository.LineRepository;

public class LineConroller {
    public void setLineList() {
        Line secondLine = new Line("2호선");
        Line thirdLine = new Line("3호선");
        Line shinbundangLine = new Line("신분당선");
        LineRepository.addLine(secondLine);
        LineRepository.addLine(thirdLine);
        LineRepository.addLine(shinbundangLine);
    }
}
