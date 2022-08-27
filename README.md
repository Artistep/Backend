# Artistep - Backend

## 기술 스택

|구분| 상세                           |
|---|------------------------------|
|WebFramework| Spring Boot, Spring Security |
|DB 접근 기술| Spring Data JPA, QueryDSL    |
|DBMS| MySQL                        |
|협업 툴| Slack, Git                   |

---

## ERD

[설계 후 첨부 예정]()


## API 명세서

[설계 후 첨부 예정]()


---

## 담당 기능

| 담당자                               | 구분                                          |
|-----------------------------------|---------------------------------------------|
| [Hejow](https://github.com/Hejow) | 1페이지 (메인페이지) <br> 2페이지 (카테고리별 게시글 검색)       |
|[diger-King](https://github.com/diger-king)| 3페이지 (카테고리별 게시판) <br> 5페이지 (내정보) <br> OAuth |

---

# 브랜치 전략

[브랜치 전략 이미지](https://user-images.githubusercontent.com/60564431/179346591-d0edee5e-1bff-4600-aee0-330590bdffde.jpg)

# main Branch

배포 가능한 버전

# develop Branch

다음 버전 개발

# feature Branch

develop 브랜치에서 분기, 기능 개발 후 develop branch 병합

# release Branch

Feature Branch 으로부터 병합된 Develop Branch 를 분기

기능 QA 및 테스트를 위한 branch

# hotfix

main branch 에서 발생한 버그 수정 후 병합

---

# 네이밍 컨벤션

패키지, 변수, 메서드 : Camel

클래스, 인터페이스 : Pascal

! 메서드 : 메서드 끝에 본인 이니셜 남기기 (ex) public void testMethodKDH())

# 커밋 메세지

[커밋 템플릿 사용](https://velog.io/@bky373/Git-%EC%BB%A4%EB%B0%8B-%EB%A9%94%EC%8B%9C%EC%A7%80-%ED%85%9C%ED%94%8C%EB%A6%BF)
