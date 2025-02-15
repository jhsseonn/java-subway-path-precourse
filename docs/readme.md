## 기능 구현 목록
### Domain
- 각 호선별로 객체 생성해 LineRepository의 lines list에 저장
- 각 역별로 객체 생성해 StationRepository의 stations list에 저장
- 각 역 사이 거리 및 소요시간 정보 StationRepository에 리스트로 저장하기(구조: [["정점1", "정점2", "간선1 거리 / 간선1 소요시간"]])

### 입출력 View
- 경로조회 or 종료 입력받기
- 기능 입력받기
  - 최단거리
  - 최소시간
  - 돌아가기
- 출발역 입력받기
- 도착역 입력받기
- 결과 출력하기
  - 총 거리 및 총 소요시간 함수 파라미터로 받기
  - 경로 리스트 함수 파라미터로 받아 역 이름 모두 출력

### Controller
- 프로그램 시작 함수 생성
- 다익스트라 알고리즘 그래프 객체 생성하기(역, 노선, 구간 정보 초기 설정)
  - 각 호선별 역 이름 목록으로 해시맵 구성하기
  - 해시맵의 키 순서대로 그래프 생성하기
  - 최단거리 그래프 생성하기
    - 지하철역들을 다익스트라 알고리즘의 정점으로 저장(2호선부터 차례대로 저장)
    - 역 사이의 간선 정보 리스트 가져와 해당 정점들의 간선 가중치 정보 갱신
  - 최소시간 그래프 생성하기
    - 지하철역들을 다익스트라 알고리즘의 정점으로 저장(2호선부터 차례대로 저장)
    - 역 사이의 간선 정보 리스트 가져와 해당 정점들의 간전 사중치 정보 갱신

- 경로 조회하기
  - 최단거리
    - 출발역과 도착역으로 다익스트라 알고리즘 최단거리 그래프에 대입해 경로 리스트로 저장
    - 저장된 경로 리스트와 간선 정보 리스트와 비교해 최종 거리 및 시간 계산 후 변수 저장
    - 결과 출력([INFO]를 붙여 출력)
      - outputView의 GraphReadOutput 함수를 이용
  - 최소시간
    - 출발역과 도착역으로 다익스트라 알고리즘 최소시간 그래프에 대입해 경로 리스트로 저장
    - 저장된 경로 리스트와 간선 정보 리스트와 비교해 최종 거리 및 시간 계산 후 변수 저장
    - 결과 출력([INFO]를 붙여 출력)
      - outputView의 GraphReadOutput 함수를 이용

- 종료 또는 돌아가기 선택시
  - 종료
    - 아무것도 하지 않음
  - 돌아가기
    - 프로그램 시작 함수 호출

### Service
- 출발역과 도착역이 같을 시 에러 출력
- 출발역과 도착역이 연결되어 있지 않으면 에러 출력
- 기능 입력 시 사용자의 입력값이 범위에서 벗어났을 경우 에러 출력
- ...