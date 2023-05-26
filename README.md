# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)

## 1단계 문자열 계산기 기능 요구사항
- [x] 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
  - [x] 덧셈 기능
  - [x] 뺄셈 기능 
  - [x] 곱셈 기능
  - [x] 나눗셈 기능

- [x] 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
  - [x] validation: 정수로 떨어지지 않는 경우

- [x] 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
> 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
  - [x] 사칙 연산을 모두 포함하는 기능 구현

### 예외처리(Input관련 예외처리)
- 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
- [x] 입력 값이 null이나 공백일 경우 `IllegalArgumentException`을 던진다.
- [x] 연산이 숫자와 연산문자(`+, -, /, *`) 외의 값이 있을 경우 `IllegalArgumentException`를 던진다.
  -  정규식으로 연산

## 1단계 문자열 계산기 프로그래밍 요구사항 
- indent(들여쓰기) depth를 2단계에서 1단계로 줄여라.
- depth의 경우 if문을 사용하는 경우 1단계의 depth가 증가한다. if문 안에 while문을 사용한다면 depth가 2단계가 된다.
- 메소드의 크기가 최대 10라인을 넘지 않도록 구현한다.
- method가 한 가지 일만 하도록 최대한 작게 만들어라.
- else를 사용하지 마라.

## 2단계 로또 (자동) 기능 요구사항
- [x] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
  - [x] 입력받은 구매 금액을 로또 가격으로 나눈 금액 만큼 로또를 생성한다.
    - [x] 떨어지지 않으면 예외를 발생한다.
    - [x] 음수나 로또 가격 이하로 입력하면 예외를 발생한다.
    
    - [ ] 로또 자동 생성은 `Collections.shuffle()` 메소드 활용한다.
    - [ ] `Collections.sort()` 메소드를 활용해 정렬한다
    - [ ] ArrayList의 `contains()` 메소드를 활용하면 어떤 값이 존재하는지 유무를 판단할 수 있다.
- [x] 로또 가격 설정 : 로또 1장의 가격은 **1000원**이다.
- [ ] 지난 주 당첨 번호를 입력 받는다. -> ui 관련 로직
  - [ ] 중복값이 있으면 예외 발생
  - [ ] 1 ~ 45 범위를 벗어나면 예외를 발생한다
  - [ ] ,로 구분된 6개의 글자가 아니면 예외를 발생한다.
  - [ ] 숫자가 아니면 예외를 발생한다.
- [ ] 당첨 번호와 일치하는 로또를 계산한다
  - [ ] 3개, 4개, 5개, 6개 일치하는 로또 개수를 계산한다
  -> 어디서 하지? `Lotteries`에서 하는게 맞는것 같은데 테스트는 어떻게 하지
  - 
- [ ] 총 수익률을 계산한다.
예시는 다음과 같다.
```
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

- UI 관련
  - 입력
    - [x] 구입 금액을 입력 받는다.
    - [x] 지난 주 당첨 번호를 입력 받는다.
    - [x] 보너스 볼을 입력 받는다.
  - 출력
    - [x] 생성한 로또를 출력한다
    - [x] 당첨 통계 결과를 출력한다.
    - [x] 총 수익률을 출력한다.
    - [x] 보너스볼 일치 결과를 포함해 출력한다.

## 2단계 로또 (자동) 프로그래밍 요구사항
- 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다.
  - 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  - UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.
- 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외   
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 참고문서: https://google.github.io/styleguide/javaguide.html 또는 https://myeonguni.tistory.com/1596
- else 예약어를 쓰지 않는다.

## 3단계 로또 (2등) 기능 요구사항
- [x] 2등을 위해 추가번호를 하나 더 추첨한다. 
  - [x] winningNumber와 중복되지 않는 추가번호를 생성한다.
  - [x] 보너스 볼을 입력받는다
- [x] 당첨 통계에 2등도 추가해야 한다.
  - [x] 5개 일치한 `Lottery` 중 보너스 볼과 일치 여부 확인을 통한 2등 판별
- 예시 )
```
지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6
보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```
## 추가된 프로그래밍 요구사항
- **java enum**을 적용해 프로그래밍을 구현한다.
- **규칙 8: 일급 콜렉션을 쓴다.**


## Step 4 기능 목록
- 사용자 수동 추첨 번호 입력