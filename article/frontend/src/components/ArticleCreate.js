import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import ArticleService from "../services/ArticleService";
// ArticleService 에 있는 create메소드를 실행하면 article이 저장되도록

const ArticleCreate = () => {
  const navigate = useNavigate();

  const [subject, setSubject] = useState("");
  const [writer, setWriter] = useState("");
  const [content, setContent] = useState("");

  //  /create-article/_add : 저장
  //  그 외에는 전부 수정으로 처리
  const saveOrUpdateArticle = (e) => {
    e.preventDefault();

    // 저장
    ArticleService.createArticle({ subject, writer, content })
      // {} = [] = 객체명
      // {subject, writer, content} = article = Article.java(spring)
      // ArticleService 에는 객체로(article) 한번에 담겨있고
      // 여기서 보내줄때는 배열로 되있을 뿐, 같은형태!!
      .then((response) => {
        navigate("/");
      });

    // 수정
  };

  return (
    <div>
      {/* 페이지 하나로 create(입력), update(수정) 처리 */}
      <h1>Create Article</h1>
      <form method="post" onSubmit={saveOrUpdateArticle}>
        {/* 저장과 수정을 한번에 만듬 */}
        <div>
          <label>Subject : </label>
          <input
            type="text"
            name="subject"
            onChange={(e) => setSubject(e.target.value)}
            value={subject}
            required
          />
        </div>
        <div>
          <label>Writer : </label>
          <input
            type="text"
            name="writer"
            onChange={(e) => setWriter(e.target.value)}
            value={writer}
            required
          />
        </div>
        <div>
          <label>Content : </label>
          <textarea
            type="text"
            name="content"
            onChange={(e) => setContent(e.target.value)}
            value={content}
            required
          >
            내용을 입력하세요
          </textarea>
        </div>
        <button type="submit">Save</button>
        <button type="button">Cancel</button>
      </form>
    </div>
  );
};

export default ArticleCreate;
