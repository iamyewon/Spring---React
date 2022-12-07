package com.example.backend.service;

// 이름 설정은 Impl 에서 설정
// @Autowired 는 인터페이스를 가져와서 함 !!

import com.example.backend.entity.Article;
import com.example.backend.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 이 파일을 서비스로 쓰겠다는 어노테이션, interface에 주는게 아니고 class 부분에 줌
public class ArticleServiceImpl implements ArticleService{
    // implement methods  이름, 파라미터 변경 xx 작업내용만 ok

    // findAll(), save(), findById(), delete() 메소드를 사용하려면
    // repository 를 가져와야함
    @Autowired
    private ArticleRepository articleRepository;
    // Repository = db 처리하는 객체
    // 실제 저장하는 코드는 Repository 안에 있음,
    // 이 파일에서는 이름만 정해놓은 것 ~

    @Override
    public List<Article> getArticles() {
        // findAll() : select * from article;
        return articleRepository.findAll();
    }

    @Override
    public Article createArticle(Article article) {
        // insert into = save()
        return articleRepository.save(article); // 사용할때는 이름만
    }

    @Override
    public Article getArticleById(long id) {
        return articleRepository.findById(id).orElse(null);
    }

    @Override
    public Article updateArticle(Article article, long id) {
        return null;
    }

    @Override
    public void deleteArticle(long id) {
        // delete from where ~ deleteById
        articleRepository.deleteById(id);
    }
}
