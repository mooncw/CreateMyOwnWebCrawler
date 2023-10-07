# CreateMyOwnWebCrawler
패스트캠퍼스 사전과제 - 코로나바이러스감염증-19 국내 발생현황 홈페이지에서 **'확진자 연령별 현황'** 웹 크롤링
- 홈페이지 주소 : https://ncov.kdca.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=11&ncvContSeq=&contSeq=&board_id=&gubun=

## 사용 기술 스택
java, jsoup, itextpdf, poi

## 진행 사항
### 구현 클래스
- **CovidStatus**
  - 확진자 연령별 현황 관련 데이터를 넣기 위한 VO 클래스
  - 데이터 : 구분, 확진자, 사망자, 치명률
    <details>
      <summary>코드</summary>
      <div markdown="1">
        <img src="https://github.com/mooncw/CreateMyOwnWebCrawler/assets/97713997/e6860fde-5bfd-43d5-a786-3ea9ab6d4643">
      </div>
    </details>

- **MyJsoup**
  - jsoup으로 코로나바이러스감염증-19 국내 발생현황 홈페이지 크롤링하여 필요한 데이터를 CovidStatus 객체에 넣는 클래스
  - 정적인 홈페이지를 하나를 HTML 파싱 및 데이터 추출 작업이기에 jsoup 사용
  - url을 입력으로 받아 jsoup으로 추출한 데이터를 넣은 CovidStatus 객체를 리턴
    <details>
      <summary>코드</summary>
      <div markdown="1">
        <img src="https://github.com/mooncw/CreateMyOwnWebCrawler/assets/97713997/5794fbf6-8126-43c2-895c-bb55f3db5d84">
      </div>
    </details>

- **DataToExcel**
  - 데이터가 들어있는 CovidStatus 객체를 엑셀 파일로 저장하는 클래스
  - MyJsoup로 얻은 CovidStatus 객체와 파일이름을 입력받아 엑셀 형식에 맞게 Workbook을 조작 후 저장
    <details>
      <summary>코드</summary>
      <div markdown="1">
        <img src="https://github.com/mooncw/CreateMyOwnWebCrawler/assets/97713997/f371ac98-ef3b-48e2-9ab3-ca68ca99a2ca">
      </div>
    </details>
- **DataToPDF**
  - 데이터가 들어있는 CovidStatus 객체를 PDF 파일로 저장하는 클래스
  - MyJsoup로 얻은 CovidStatus 객체와 파일이름을 입력받아 PDF 형식에 맞게 Document를 조작 후 저장
    <details>
      <summary>코드</summary>
      <div markdown="1">
        <img src="https://github.com/mooncw/CreateMyOwnWebCrawler/assets/97713997/124bd1af-3c4c-42c6-adfa-59039f07f8c0">
        <img src="https://github.com/mooncw/CreateMyOwnWebCrawler/assets/97713997/6ea7c444-9c30-4cce-a649-6b65f272d81c">
      </div>
    </details>
- **MyOwnWebCrawler**
  - DataToExcel과 DataToPDF를 실행시키는 메인 클래스
  - 성공 여부를 프린트하는 기능 포함
    <details>
      <summary>코드</summary>
      <div markdown="1">
        <img src="https://github.com/mooncw/CreateMyOwnWebCrawler/assets/97713997/61daecd6-de13-453c-b891-daf0e09f69ad">
      </div>
    </details>

## 결과


## (그 외 상세한 내용들)
---------------------------------
- [x] 과제 제목 과 과제에 대한 설명
- [ ] 구현할 기능 목록과 각 기능의 내용
- [ ] 입력과 출력 내용에 대한 설명
- [x] 개발도구
- [ ] 그 외 상세한 내용들
