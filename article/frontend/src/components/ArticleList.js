import React, { useEffect, useState } from "react";
import ArticleService from "../services/ArticleService";
import moment from "moment/moment";
import { useNavigate, useParams } from "react-router-dom";

const ArticleList = () => {
  const [articles, setArticles] = useState([]);
  // <> 는 여러줄이 들어있기 때문에 배열로 받아야함
  const navigate = useNavigate();

  //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

  const editArticle = (id) => {
    // 페이지이동(id값을 가지고)
    navigate(`/create-article/${id}`);
  };

  //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

  const deleteArticle = (id) => {
    // axios.delete("http:localhost:8877/api/article/"+id);
    // axios로 통신해도 됨
    ArticleService.deleteArticle(id).then((response) => {
      window.alert("Article Delete Completed...");
      // 필터링
      // 삭제된 내용을 검색하여 삭제된 내용은 제외(filter)하고 다시 변수에 담기
      // setArticles(articles.id !== id); 지우는 아이디와 비교 쭉 ~
      setArticles(articles.filter((a) => a.id !== id));
      // articles 배열 안에 있는 id들과 매개변수로 받은 id를 하나하나 비교해서
      // 삭제할 내용은 제외하고 나머지를 다시 저장
    });
    // 내가 누른 번호를 ArticleService.deleteArticle 에 전달
  };

  //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

  const viewArticle = (id) => {};

  //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

  useEffect(() => {
    // ArticleService 에 클래스로 만든 파일 가져와서 메소드 호출
    ArticleService.getArticles().then((response) => {
      setArticles(response.data);
    });
  }, []);

  // console.log(articles);

  //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

  return (
    <div>
      <a href="/create-article/add">Create Article</a>
      <table>
        <thead>
          <tr>
            <th>ID.</th>
            <th>Subject.</th>
            <th>Writer.</th>
            <th>Content.</th>
            <th>Regdate.</th>
            <th>Edit / Delete / View</th>
          </tr>
        </thead>
        <tbody>
          {articles.map((article, key) => {
            return (
              <tr key={key}>
                <td>{article.id}</td>
                <td>{article.subject}</td>
                <td>{article.writer}</td>
                <td>{article.content}</td>
                {/* <td>{moment(데이터).format(형식)}</td> */}
                <td>{moment(article.regdate).format("YYYY.MM.DD HH:mm:ss")}</td>
                <td>
                  <button onClick={() => editArticle(article.id)}>Edit</button>/{" "}
                  {/* id값이 필요하기때문에 매개변수가 필요, 필요없으면 콜백함수 필요x.. */}
                  <button onClick={() => deleteArticle(article.id)}>
                    Delete
                  </button>
                  /{" "}
                  <button onClick={() => viewArticle(article.id)}>View</button>
                </td>
              </tr>
            );
          })}
        </tbody>
      </table>
    </div>
  );
};

export default ArticleList;
