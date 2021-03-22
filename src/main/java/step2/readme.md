역할과 책임을 나누고, 각 객체들이 주어진 책임을 다하는지에 초점을 맞추었습니다.

# 코드 리뷰 이전

## 로또(수동)

### 역할

#### 서비스

1. 수동 로또의 모든 과정을 관장하는 로또 서비스 객체

#### 도메인

2. 로또번호를 관장하는 신 객체
3. 로또의 당첨여부를 판단하는 심판 객체
4. 원하는만큼 로또를 구입하게 해주는 로또기계 객체
5. 로또를 살 수 있는 상점 객체

#### VO

6. 심판의 판단 결과를 담은 심판응답 객체
7. 로또 객체
8. 돈 객체
9. 등수별 상금이 있는 상금 객체
10. 상점에서 로또를 구매할 때 지급되는 상점응답 객체

#### View

11. 사용자의 입력을 받을 수 있는 입력뷰 객체
12. 실행중의 출력을 보여주는 런타임뷰 객체
13. 결과를 보여주는 결과뷰 객체

### 책임

#### 서비스

1. 수동 로또의 모든 과정을 관장하는 로또 서비스 객체

- 입력뷰 객체를 통해 이용자가 가지고 있는 돈을 입력받아야 한다
- 상점 객체를 통해 살 수 있는 로또의 수를 구해야 한다
- 상점 객체를 통해 로또를 구입해야 한다
- 런타임뷰 객체를 통해 구입한 로또의 개수와 번호를 출력해야 한다
- 입력뷰 객체를 통해 지난주 당첨 로또를 입력받아야 한다
- 심판을 통해 구입한 로또의 당첨여부를 받아야 한다
- 결과뷰를 통해 구입한 로또의 당첨여부를 출력해야 한다

#### 도메인

2. 로또를 관장하는 신 객체다

- 로또번호를 점지해주어야 한다

3. 로또의 당첨여부를 판단하는 심판 객체

- 로또번호들이 몇개나 맞는지 판단해주어야 한다
- 수익률을 계산해주어야 한다

4. 원하는만큼 로또를 구입하게 해주는 로또기계 객체

- 원하는 만큼 로또를 구입하게 해주어야 한다
- 돈이 부족하면 예외를 던져야 한다

5. 로또를 살 수 있는 상점 객체다

- 살 수 있는 로또의 개수를 알려주어야 한다
- 로또를 구입하게 해주어야 한다

#### VO

6. 심판의 판단 결과를 담은 심판응답 객체다

- 3개 이상 맞은 로또의 수를 각각 담아야 한다
- 수익률을 담아야 한다

7. 로또 객체

- 6개의 번호를 담아야 한다
- 각 번호는 1~45이어야 한다

8. 돈 객체

- 음수는 허용하지 않아야 한다

9. 등수별 상금이 있는 상금 객체다

- 각 등수별로 상금이 얼마인지 담아야 한다

10. 상점에서 로또를 구매할 때 지급되는 상점응답 객체

- 원래 돈이 얼마였는지 담아야 한다
- 구입한 로또의 수를 담아야 한다
- 구입한 로또의 수만큼의 로또를 담아야 한다
- 잔돈을 담아야 한다

#### View

11. 사용자의 입력을 받을 수 있는 입력뷰 객체다

- 사용자가 얼마를 가지고 있는지 입력받아야 한다
- 지난 주 당첨번호를 입력받아야 한다

12. 실행중의 출력을 보여주는 런타임뷰 객체

- 로또를 몇개 샀는지 출력해야 한다
- 로또 번호들을 출력해야 한다

13. 결과를 보여주는 결과뷰 객체

- 몇개나 당첨됐는지 출력해야 한다
- 수익률을 출력해야 한다

# 1차 코드 리뷰 이후

## 로또(수동)

### 역할

#### 컨트롤러

1. 수동 로또의 비즈니스로직을 활성화하는 로또 컨트롤러 객체

#### 서비스

2. 수동 로또의 모든 과정을 관장하는 로또 서비스 객체

#### 도메인

3. 로또번호생성 관장하는 로또번호생성기 객체
4. 로또의 당첨여부를 판단하는 심판 객체
5. 원하는만큼 로또를 구입하게 해주는 로또기계 객체
6. 로또를 살 수 있는 상점 객체
7. 돈 객체
8. 로또 객체

#### VO

9. 심판의 판단 결과를 담은 심판응답 객체
10. 상점에서 로또를 구매할 때 지급되는 상점응답 객체

#### 유틸성 객체

11. 로또 가격과 등수별 상금이 있는 금액 객체

#### View

12. 사용자의 입력을 받을 수 있는 입력뷰 객체
13. 실행중의 출력을 보여주는 런타임뷰 객체
14. 결과를 보여주는 결과뷰 객체

### 책임

#### 컨트롤러

1. 수동 로또의 비즈니스로직을 활성화하는 로또 컨트롤러 객체

- 로또 서비스의 수동 로또 서비스를 작동해야 한다

#### 서비스

2. 수동 로또의 모든 과정을 관장하는 로또 서비스 객체

- 입력뷰 객체를 통해 이용자가 가지고 있는 돈을 입력받아야 한다
- 상점 객체를 통해 살 수 있는 로또의 수를 구해야 한다
- 상점 객체를 통해 로또를 구입해야 한다
- 런타임뷰 객체를 통해 구입한 로또의 개수와 번호를 출력해야 한다
- 입력뷰 객체를 통해 지난주 당첨 로또를 입력받아야 한다
- 심판을 통해 구입한 로또의 당첨여부를 받아야 한다
- 결과뷰를 통해 구입한 로또의 당첨여부를 출력해야 한

#### 도메인

3. 로또를 관장하는 로또넘버생성 객체다

- 로또번호를 점지해주어야 한다

4. 로또의 당첨여부를 판단하는 심판 객체

- 로또번호들이 몇개나 맞는지 판단해주어야 한다
- 수익률을 계산해주어야 한다

5. 원하는만큼 로또를 구입하게 해주는 로또 공장 객체

- 원하는 만큼 로또를 구입하게 해주어야 한다
- 돈이 부족하면 예외를 던져야 한

6. 로또를 살 수 있는 상점 객체다

- 살 수 있는 로또의 개수를 알려주어야 한다
- 로또를 구입하게 해주어야 한다

7. 돈 객체

- 음수는 허용하지 않아야 한다

8. 로또 객체

- 6개의 번호를 담아야 한다
- 각 번호는 1~45이어야 한다

#### VO

9. 심판의 판단 결과를 담은 심판응답 객체다

- 3개 이상 맞은 로또의 수를 각각 담아야 한다
- 수익률을 담아야 한다

10. 상점에서 로또를 구매할 때 지급되는 상점응답 객체

- 원래 돈이 얼마였는지 담아야 한다
- 구입한 로또의 수를 담아야 한다
- 구입한 로또의 수만큼의 로또를 담아야 한다
- 잔돈을 담아야 한다

#### 유틸성 객체

11. 로또 가격과 등수별 상금이 있는 금액 객체

- 로또의 금액을 담아야 한다
- 각 등수별로 상금이 얼마인지 담아야 한다

#### View

12. 사용자의 입력을 받을 수 있는 입력뷰 객체다

- 사용자가 얼마를 가지고 있는지 입력받아야 한다
- 지난 주 당첨번호를 입력받아야 한다

13. 실행중의 출력을 보여주는 런타임뷰 객체

- 로또를 몇개 샀는지 출력해야 한다
- 로또 번호들을 출력해야 한다

14. 결과를 보여주는 결과뷰 객체

- 몇개나 당첨됐는지 출력해야 한다
- 수익률을 출력해야 한다

# 2차 코드 리뷰 이후

## 로또(수동)

### 역할

#### 컨트롤러

1. 수동 로또의 입출력과 서비스 활성화를 담당하는 로또 컨트롤러 객체

#### 서비스

2. 도메인 객체 접근과 이를 통한 비즈니스 로직을 담당하는 로또 서비스 객체

#### 도메인

3. 로또의 당첨여부를 판단하는 심판 객체
4. 로또를 생성하는 로또생성기 객체
5. 로또번호생성을 관장하는 로또번호생성기 객체
6. 로또를 살 수 있는 상점 객체
7. 돈을 생성하는 돈생성기 객체

#### VO

8. 심판의 판단 결과를 담은 심판응답 객체
9. 로또번호가 적힌 로또 객체
10. 로또들을 담은 로또리스트 객체
11. 금액이 적힌 돈 객체
12. 상점에서 로또를 구매할 때 지급되는 상점응답 객체

#### 유틸성 객체

13. 로또 가격과 등수별 상금이 있는 금액 객체

#### View

14. 사용자의 입력을 받을 수 있는 입력뷰 객체
15. 실행중의 출력을 보여주는 런타임뷰 객체
16. 결과를 보여주는 결과뷰 객체

### 책임

#### 컨트롤러

1. 수동 로또의 입출력과 서비스 활성화를 담당하는 로또 컨트롤러 객체

- 입출력을 담당해야 한다
- 로또 서비스를 통해 비즈니스로직의 결과를 받아와야 한다

#### 서비스

2. 도메인 객체 접근과 이를 통한 비즈니스 로직을 담당하는 로또 서비스 객체

- 상점 객체를 통해 로또를 구매한 결과를 받아와야 한다
- 심판 객체을 통해 로또 구매의 결과를 받아와야 한다

#### 도메인

3. 로또의 당첨여부를 판단하는 심판 객체

- 로또번호의 판정 결과(몇개 맞는지, 수익) 판단해주어야 한다

4. 로또를 생성하는 로또생성기 객체

- 로또를 생성해주어야 한다
- 원하는 만큼 로또를 생성해주어야 한다
- 불량로또(번호가 6개가 아니거나, 1~45가 아닌 경우)가 인식되면 예외를 던져야 한다

5. 로또번호생성을 관장하는 로또번호생성기 객체

- 로또 번호를 생성해야 한다

6. 로또를 살 수 있는 상점 객체

- 살 수 있는 로또의 개수를 알려주어야 한다
- 로또를 구입하게 해주어야 한다

7. 돈을 생성하는 돈생성기 객체

- 음수는 허용하지 않아야 한다

#### VO

8. 심판의 판단 결과를 담은 심판응답 객체

- 3개 이상 맞은 로또의 수를 각각 담아야 한다
- 수익률을 담아야 한다

9. 로또번호가 적힌 로또 객체

- 로또 번호들이 담겨야 한다

10. 로또들을 담은 로또리스트 객체

- 로또들이 담겨야 한다

11. 금액이 적힌 돈 객체

- 돈의 액수가 담겨야 한다

12. 상점에서 로또를 구매할 때 지급되는 상점응답 객체

- 원래 돈이 얼마였는지 담아야 한다
- 구입한 로또의 수를 담아야 한다
- 구입한 로또의 수만큼의 로또를 담아야 한다
- 잔돈을 담아야 한다

#### 유틸성 객체

13. 로또 가격과 등수별 상금이 있는 금액 객체

- 로또의 금액을 담아야 한다
- 각 등수별로 상금이 얼마인지 담아야 한다

#### View

14. 사용자의 입력을 받을 수 있는 입력뷰 객체다

- 사용자가 얼마를 가지고 있는지 입력받아야 한다
- 지난 주 당첨번호를 입력받아야 한다

15. 실행중의 출력을 보여주는 런타임뷰 객체

- 로또를 몇개 샀는지 출력해야 한다
- 로또 번호들을 출력해야 한다

16. 결과를 보여주는 결과뷰 객체

- 몇개나 당첨됐는지 출력해야 한다
- 수익률을 출력해야 한다