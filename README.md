

# Spring 8조 slack 클론코딩


# 1. 프로젝트 소개

### 늘 잠이 부족한 사람들을 위한 워크스페이스 sleep (slack cloning)
![sleep](https://user-images.githubusercontent.com/103565908/175207827-94c15e34-b25d-4b7d-b2c9-d0ca26395933.PNG)


## 구현한 기능
### 회원가입 로그인 (spring security, jwt)
### 게시글 및 댓글
### 채팅방 (Redis, Web Socket)


![슬랙 클론코딩 api 로그인 회원가입](https://user-images.githubusercontent.com/103565908/175223377-2d256849-65d7-4d05-bf35-b411ab401680.png)

![슬랙 클론코딩 api 게시글](https://user-images.githubusercontent.com/103565908/175223214-b0b0787f-39d1-4d49-be85-75f50f82dca2.png)

![슬랙 클론코딩 api 댓글](https://user-images.githubusercontent.com/103565908/175223245-9c5a9c96-2204-4e62-8b71-8762dc9ee677.png)

![슬랙 클론코딩 api 채팅방 1](https://user-images.githubusercontent.com/103565908/175223412-0983bd9f-d831-4133-a988-7bb9fdc9930d.png)

![슬랙 클론코딩 api 채팅방 2](https://user-images.githubusercontent.com/103565908/175223425-56f77433-5b75-4977-bed1-4840aaa98211.png)

## Trouble Shooting

# BE security에서 로그인성공 시 application/Json으로 내려주는 형식의 코드를 작성하면 바디에 내려준 데이터 값중 한글이 깨지는 현상
#      스프링 부트 2.2.0 업그레이드 후 응답 Content-Type 에서 Charset 빠져서 charset을 추가하여 application/json; charset=utf-8로 써줘서 해결
# 소켓 연결이 계속 안돼서 한참 찾다가 스킵패스리스트에 ws-stomp를 추가해줘야 한다는 사실을 깨달았다.
# 비슷한 문제로 , 당시 TIL에 정리하진 못했었던 문제. EC2 인스턴스 인바운드 보안규칙에 6379번 포트를 안 열어줘서 안 됐던 문제도 있었다.
