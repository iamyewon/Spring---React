// axios 작업만 분리 : 클래스로 작업
import axios from "axios";

// Spring url : 상수로 처리
const SPRING_URL = "http://localhost:8899/api/article";

//중복되는 작업을 위해 class 로 모듈화
class ArticleService {
  // 메소드명(파라미터){
  //  return 작업코드
  // }

  // 전체가져오기
  getArticles() {
    return axios.get(SPRING_URL);
  }
  // 저장하기
  createArticle(article) {
    //return axios.post(SPRING_URL, {subject, writer, content ... } => 객체로 );
    return axios.post(SPRING_URL, article);
  }
  // 하나가져오기
  getArticleById(articleID) {
    return axios.get(SPRING_URL + "/" + articleID);
  }
  // 수정하기 -> put
  // 제목이 바뀔지, 내용이 바뀔지 뭐가 바뀔지 모르고 몇개 바뀔지 모르니까 객체로
  updateArticle(article, articleID) {
    return axios.put(SPRING_URL + "/" + articleID, article);
    // 이 주소로 실행할때 article도 같이 가져가..!
  }
  // 삭제하기
  deleteArticle(articleID) {
    return axios.delete(SPRING_URL + "/" + articleID);
    // const deleteArticle = (id) => {
    // axios.delete("http:localhost:8877/api/article/2");
    // };
    // ArticleList의 주소와 맞춰주면 됨
  }
}
export default new ArticleService();
// 파일 외부에서 사용하게 하려면 export : export, export default 함수명
// 클래스일때는 export default new 파일이름()

// Restful : get, post, put(수정), delete(삭제)
