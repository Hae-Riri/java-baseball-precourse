# 숫자 야구 게임
## 진행 방법
* 숫자 야구 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)

## 기능 목록

#### 게임 진행
- main
    - play()를 최초 실행
    - play()를 사용자 입력값(1,2)에 따라 반복 실행
- play()
  - 111에서 999까지의 랜덤값과 사용자 입력값을 받은 후 답 출력

#### 게임 전 초기화
- answerInit()
    - 사용자가 값을 입력할 때마다 볼과 스트라이크를 초기화

- makeNewRandomNumber()
  - 새로운 상대값 설정

#### 입력값 유효성 검사
- checkInputValidation()
    - 사용자 입력값의 유효성 체크정
    - length 검사 메소드 호출 (hasOverLength())
    - 반복 숫자 유무 검사 메소드 호출 (hasSameNumber())
- hasOverLength()
  - 입력값의 길이가 3을 초과하는지 확인
- hasSameNumber()
  - 반복되는 숫자가 존재하는지 확인

#### 답안 도출
- setStrikeAndBall()
    - 스트라이크와 볼 수 세서 세팅
  
- setBall()
    - 볼 수 세서 세팅