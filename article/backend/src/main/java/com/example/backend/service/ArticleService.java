package com.example.backend.service;

import com.example.backend.entity.Article;

import java.util.List;

public interface ArticleService {
    // 본체가 없습니다 = {} 가 없습니다 -> 접근제한자 반환형 메소드명();

    // 전체 가져오기
    // public List<id, subject, writer, content, ref ... > getArticles();
    // entity import
    public List<Article> getArticles();
    // 쿼리문 썼을때 여러줄 나오면 무조건 List 쓰고,
    // where 써서 1줄 나올때는 List 필요없음


    // 저장하기
    // public Article createArticle(submit, writer, content)
    public Article createArticle(Article article);


    // 하나 가져오기
    // public id, subject, content getArticleById(10);
    public Article getArticleById(long id);


    // 수정하기
    // update article set subject=?, content=? where id = 55;
    public Article updateArticle(Article article, long id);
    // 수정 후 저장된 내용을 한번 띄울 거라서 Article이고, 안할거면 void로


    // 삭제하기
    public void deleteArticle(long id);
}
