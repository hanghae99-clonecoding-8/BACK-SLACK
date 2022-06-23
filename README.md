# 💤Sleep💤

## 개발기간

2022.06.17 - 2022.06.23


## 내용

🎉Slack Clone Coding
🎉잠이 필요한 개발자들의 Slack Clone Coding


## 😎 잠이 필요한 사람들

👉 FE : 임운철, 최서현

👉 BE : 곽동관, 양승훈, 문준호


# 1. 프로젝트 소개

### 늘 잠이 부족한 사람들을 위한 워크스페이스 sleep (slack cloning)
![sleep](https://user-images.githubusercontent.com/103565908/175207827-94c15e34-b25d-4b7d-b2c9-d0ca26395933.PNG)


## 기능

- [x] 1. 게시글
  - [x] 목록 가져오기
  - [x] 추가하기
  - [x] 삭제하기
  - [x] 댓글작성하기
- [x] 2. 회원가입하기
- [x] 3. 로그인하기
- [x] 4. S3로 배포
- [x] 5. modal창 열기
- [x] 6. soket 실시간채팅


## 페이지별 상세페이지별 상세

1. 회원가입 페이지

   - [x] 이메일 형식 체크
   - [x] 비밀번호 체크
   - [x] 공란시 가입불가
   - [x] 이메일 중복 체크
   - [x] 닉네임 중복 체크
   - [x] 중복 체크 완료후 가입 버튼 생성

2. 로그인 페이지

   - [x] 가입된 아이디/비번 일치시 로그인

3. 메인 페이지(게시글 목록 페이지)

   - [x] 게시글 목록 노출
   - [x] 게시글 하나는 작성자 이메일, 닉네임, 유저 프로필 이미지, 작성 날자  텍스트 내용으로 구성
   - [x] 게시글 하나를 클릭 시, 게시글 상세 페이지 모달창 오픈
   - [x] 스크롤 맨 밑으로 자동 이동
   - [x] 실시간 포스팅 랜더링
   - [x] 입력 완료후 입력창 리셋  
   - [x] 유저 프로필 확인

4. 채팅방
   - [x] 실시간 채팅 랜더링
   - [x] 입력 완료후 입력창 리셋
   - [x] 엔터키로 입력값 작성완료  

5. 게시글 상세 페이지
   - [x] 댓글 작성
### 회원가입 로그인 (spring security, jwt)
### 게시글 및 댓글
### 메시지 (Redis, Web Socket)


![슬랙 클론코딩 api 로그인 회원가입](https://user-images.githubusercontent.com/103565908/175223377-2d256849-65d7-4d05-bf35-b411ab401680.png)

![슬랙 클론코딩 api 게시글](https://user-images.githubusercontent.com/103565908/175223214-b0b0787f-39d1-4d49-be85-75f50f82dca2.png)

![슬랙 클론코딩 api 댓글](https://user-images.githubusercontent.com/103565908/175223245-9c5a9c96-2204-4e62-8b71-8762dc9ee677.png)

![슬랙 클론코딩 api 채팅방 1](https://user-images.githubusercontent.com/103565908/175223412-0983bd9f-d831-4133-a988-7bb9fdc9930d.png)

![슬랙 클론코딩 api 채팅방 2](https://user-images.githubusercontent.com/103565908/175223425-56f77433-5b75-4977-bed1-4840aaa98211.png)

## Trouble Shooting

<a href="https://ysh94.tistory.com/49">트러블슈팅</a>
