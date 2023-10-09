# CreateMyOwnWebCrawler
패스트캠퍼스 사전과제 - 코로나바이러스감염증-19 국내 발생현황 홈페이지에서 **'확진자 연령별 현황'** 웹 크롤링
- 홈페이지 주소 : https://ncov.kdca.go.kr/bdBoardList_Real.do?brdId=1&brdGubun=11&ncvContSeq=&contSeq=&board_id=&gubun=

## 사용 기술 스택
java, jsoup, itextpdf, poi

## 구현 클래스
### Model
- **CovidStatus**
  - 확진자 연령별 현황 관련 데이터를 넣기 위한 VO 클래스
  - 데이터 : 구분, 확진자, 사망자, 치명률
    <details>
      <summary>코드</summary>
      <div markdown="1">
        <img src="https://github.com/mooncw/CreateMyOwnWebCrawler/assets/97713997/e6860fde-5bfd-43d5-a786-3ea9ab6d4643">
      </div>
    </details>

### View
- **DataToExcel**
  - 데이터가 들어있는 CovidStatus 객체를 엑셀 파일로 저장하는 클래스
  - MyJsoup로 얻은 CovidStatus 객체와 파일이름을 입력받아 엑셀 형식에 맞게 Workbook을 조작 후 저장
    <details>
      <summary>코드</summary>
      <div markdown="1">
        <img src="https://github.com/mooncw/CreateMyOwnWebCrawler/assets/97713997/83306796-164b-4880-b985-737f2105cd22">
        <img src="https://github.com/mooncw/CreateMyOwnWebCrawler/assets/97713997/818b1b75-e9dd-44c4-892e-a83322409282">
        <img src="https://github.com/mooncw/CreateMyOwnWebCrawler/assets/97713997/199f55e5-966d-491a-afa7-e57527a27dfc">
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

### Controller
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
### 실행 영상(성공 여부 프린트와 파일들이 생기는 것 확인)
![MyOwnWebCrawler java실행](https://github.com/mooncw/CreateMyOwnWebCrawler/assets/97713997/dcd222f5-b760-4191-b574-0489dbeaff2f)

<br>

### 생성한 파일
- **MyCovidExcel**

  ![image](https://github.com/mooncw/CreateMyOwnWebCrawler/assets/97713997/9548b552-b9f2-44bf-9798-9618e1b2ce12)

<br>

- **MyCovidPDF**

  ![image](https://github.com/mooncw/CreateMyOwnWebCrawler/assets/97713997/093935bc-e863-411f-b82f-0b753fb0c0b2)  
