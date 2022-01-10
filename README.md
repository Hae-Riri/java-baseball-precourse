# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록

#### [게임 진행]
**main**
- playGame()을 실행

**playGame()**
- 게임을 반복적으로 실행

**game()**
- 랜덤값과 사용자 입력값에 따라 게임 진행

**countStrikeAndBall()**
- 스트라이크와 볼 수 세서 세팅

**printAnswer()**
- 현재 게임에 대한 답 출력

#### [입력값 검사, 정규화]
**checkInputValidation()**
- 사용자 입력값의 유효성 체크
- length 검사 메소드 호출 (hasOverLength())
- 반복 숫자 유무 검사 메소드 호출 (hasSameNumber())

**hasOverLength()**
- 입력값의 길이가 3을 초과하는지 확인

**hasSameNumber()**
- 반복되는 숫자가 존재하는지 확인

**normalizeInput()**
- 쉬운 비교를 위해 사용자 입력값에 0을 추가해서 자릿수 맞춤
- 사용자 입력값이 세 자리 수 미만일 경우를 대비한 메소드
  
#### [리셋]
**answerReset()**
- 사용자가 값을 입력할 때마다 볼과 스트라이크를 리셋

**makeNewRandomNumber()**
- 새로운 상대값 설정