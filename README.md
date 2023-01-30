# CKRun
<h2>쿠키런 오븐브레이크 쿠키 평점 사이트</h2>

![메인화면](https://user-images.githubusercontent.com/73933471/215435500-d2f2ce8f-dbba-44ed-853e-294300c8458d.gif)

---

## 사용 기술 및 라이브러리
* JDK 11
* Spring Boot 2.7.7
* MyBatis
* Oracle 11g
* ThymeLeaf
* Jquery 3.6.1

---


## [실행동영상]
[![실행영상]( https://img.youtube.com/vi/kU11_uGRH-8/0.jpg)](https://www.youtube.com/watch?v=kU11_uGRH-8)

## 로그인/회원가입
- 회원가입, 로그인 후 세션 생성을 통한 상태 관리
- 회원가입 시 비밀번호 길이, 확인 체크
- 스프링 시큐리티 OAuth2 방식으로 구현한 구글 로그인 연동, 상태 관리

## 쿠키목록/검색
- 쿠키 목록보기 버튼에 따라 최대 10,30,50개씩 보기 설정
- 쿠키이름, 태그를 통한 검색 처리
- 쿠키목록 페이징 처리

## 평점작성/추천
- 댓글 중 추천수 기준 top3를 상단에 표시
- 등록버튼을 통해 평점댓글 작성
- 추천 버튼을 통해 해당 댓글 추천수 AJAX 처리
