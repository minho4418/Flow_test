# Flow_test
### 1. 전체 삭제 기능 추가
### 2. 커스텀 확장자 중복 체크
### 3. 한글, 특수문자 추가 불가
#
### 오류 : checkbox 체크하는 곳에서 오류
### 원인 : for문으로 체크, 논체크 부분을 모두 돌려서 찾기때문에
###          전에 체크, 논체크 된 부분도 중복으로 검색됨
#
### 해결방안 : state열하나 더 만들어서 체크 될 때 1로 defalt 0
### -> 논체크 될 때 0으로 다시
### -> 실서버 업로드해서 확인
