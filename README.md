# Progress Report
POSTECH CSED332 project - Distributed Sorting

---

## Week 1

### 프로젝트 목표 인식

#

### 프로젝트 진행 계획

**1. Overall Plan**

프로젝트 수행 단계는 크게 Planning, Coding, Component test, System test로 나눌 수 있으며 Mythical Man-Month에서 
저자의 조언에 따르면 1/3, 1/6, 1/4, 1/4의 시간 분배를 추천하고 있다. 기간이 3일뿐이었던 첫 주(Week 1)와 프레젠테이션 준비 및 예상치
못한 문제 해결 등을 위해 남겨둘 마지막 주(Week 8)를 제외한 기간은 총 6주로, 각각의 단계 수행에 2주, 1주, 1.5주, 1.5주를 
생각하고 있다.

>####
>Week 1: 프로젝트 이해, Git repo 생성 및 팀원과의 일정 조율  
Week 2, 3: 전반적인 프로그램 구조 디자인, 구현 방법 구체화, 핵심 내용은 비워둔 채 전체적인 틀 형성  
Week 4: 각각의 세부 코딩 영역 역할 분배 후 코드 작성  
Week 5: 각자 상대가 구현한 코드에 대한 이해 및 교차 테스트, 디버깅  
Week 6, 7: 전체 프로그램에 대한 테스트, 디버깅  
Week 8: 일정 지연에 대한 대비 기간이자 최종 프레젠테이션 준비 기간  
>####

Planning 단계에서는 생성형 AI의 도움을 받아 프로그램 디자인을 수행할 계획이며, 프로젝트 전체에 대한 큰 그림을 구상해야 할 뿐 아니라
프로그래밍 환경 구축 등의 세팅 또한 해당 기간에 수행해야 하므로 다소 길어질 수 있다. Coding 단계 또한 아직 Scala 언어에 
완벽하게 익숙하다 말하기 어려운 상태이니 지연될 수 있음을 감안해 추후 기간을 조정할 생각이다.

###

<U>Milestones</U>

- Milestone #1
  - test cluster 사용법 숙지
    - master 실행, worker 연결
    - master-worker 간 통신에 사용할 network library 선정 및 공부
  - Sample input data 생성
    - gensort 사용법 이해

- Milestone #2
  - master-worker 통신 프로토콜 구현
    - master-worker 간 통신 확인
    - 메시지 전달 및 error handling 테스트
  - Sampling
    - worker가 master로 sample data 전송하는 strategy 설계
    - master의 sample analyze, data partition decision method 설계
  - Documentation
    - 구현한 코드에 대한 documentation 작성

  ...

#

**2. Schedule for weekly meeting**

프로젝트에 주어진 시간은 이번 첫 주(~24.10.20.)를 포함해 8주(~24.12.08.)로, 구현 요구사항에 비해 그 기간이 결코
많지 않다. 프로젝트의 빠른 진전을 위해 3일 가량의 시간이 주어진 이번 주와 시험기간이 포함된 다음 주를 제외하고 
매 주 2회의 미팅을 계획하고 있으며, 변동될 수 있다.

>< Meetings >
>
>- 10.19.(Sat) : 프로젝트 주제 인식, 향후 계획 작성
>- 10.25.(Fri) : 프로그래밍 환경 구축, 프로그램 구조 디자인
>- 10.29.(Tue) : 프로그램 구조 디자인
>- 11.01.(Sat) : 사용 라이브러리 선정 등 구현 방법 구체화, 클래스 설계
>- 11.05.(Tue) : 코드 영역 분담 및 작성 
>- 11.09.(Sat) : 코드 작성, 진행 상황 확인
>- 11.12.(Tue) : 서로의 구현 코드 설명, 이해 및 테스트
>- 11.16.(Sat) : 코드 수정/테스트/디버깅, 중간 발표 준비
>- 11.19.(Tue) : 중간 발표 준비
>- 11.23.(Sat) : 중간 발표 피드백 수용, 코드 병합 후 전체 프로그램 테스트
>- 11.26.(Tue) : 테스트 및 디버깅, 필요 시 재구현
>- 11.30.(Sat) : 테스트 및 디버깅
>- 12.03.(Tue) : 테스트 및 디버깅, 최종 발표 준비
>- 12.07.(Sat) : 최종 발표 준비

#

**3. Communication methods**

장기 프로젝트의 특성상 팀원과의 지속적인 소통이 필요하다. 연락처 교환 후 카카오톡 메신저를 통해 기본적인 원거리 소통을 수행하기로 하였으며, 
프로젝트 코드 구현이나 관리 등에 어려움이 생겨 추가적인 소통이 필요하다면 위에서 계획한대로 매 주차 정해진 미팅시간에 이를 위한 모임 계획을 
정하는 것으로 생각하고 있다. 전반적인 코드 관리는 github를 통해 이루어질 것이며, 개개인이 구현한 코드 병합 시 충돌이 일어나는 것을 방지하기
위해 미팅을 통해 해당 주차에 진행할 활동의 범위와 역할을 정확히 나누고 각각의 branch를 만들어 관리한다.

#

>#### Next week goal:   
> 프로그래밍 환경 구축, cluster 사용법 숙지, master/worker 테스트 및 network library 학습
> - 김균서: master-worker connection 수행
> - 정용준: network library 활용해 간이 프로토콜 작성, 메시지 전송 등 테스트