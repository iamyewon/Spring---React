package com.example.backend.service;

// 이름 설정은 Impl 에서 설정
// @Autowired 는 인터페이스를 가져와서 함 !!

import com.example.backend.entity.Article;
import com.example.backend.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
        // findAll() : select * from article Order By id DESC;
        return articleRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
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
        // article 에도 안에 자료가 많고, id도 넘어오고 ,,
        // 메모리를 비우고(초기화) 자료를 모두 저장시킬 것..
        // 생성자를 이용하여 초기화
        // react js 에서 넘어온 자료를 저장하기 위한 Model(=Entity)을 초기화
        // 자료 저장을 하기 위해서는 getter, setter 이용해서 임시 메모리에 저장
        // 저장할때는 get() -> set() 이용해서 저장
        // db에 저장
        Article newArticle = new Article();
        // entity에 있는 Article을 새로 만들어서 초기화
        newArticle.setId(id);
        // getId 하면 0이 뜸, get 말고 받아온 id를 넣어주기
        newArticle.setSubject(article.getSubject());
        newArticle.setWriter(article.getWriter());
        newArticle.setContent(article.getContent());
        // set~은 임시메모리에 저장하는것 / get~은 react에서 받아온 부분
        return articleRepository.save(newArticle);
        // 변경을 해서 저장이 됨.
    }

    @Override
    public void deleteArticle(long id) {
        // delete from where ~ deleteById
        articleRepository.deleteById(id);
    }
}
