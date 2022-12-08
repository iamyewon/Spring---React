package com.example.backend.controller;

import com.example.backend.entity.Article;
import com.example.backend.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// @Controller => JSON 통신 x
@RestController // 디자인 신경 쓸 필요없이 자료만 주고 받기
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
// cors 와 비슷
// 이 주소로 접속하면 사용할 수 있도록

public class ArticleController {
    @Autowired
    private ArticleService articleService;
    // 서비스를 참고해서 아래도 작성하면 됨 !!


    // 전체가져오기 ( 다 가져오는 것이니 파라미터 필요x )
//    @GetMapping("/article")
//    // 메소드 명은 서비스 부분 참고 + react의 articleService
//    public List<Article> getArticles(){
//        return articleService.getArticles();
//    }
    @GetMapping("/article")
    // 앞단계의 Service 에서.. 똑같이 가져와서.. **************************
    public List<Article> getArticles(){
        return articleService.getArticles();
    }



    // 저장하기 - 자료(subject, writer, content ... )가 넘어오면 받아서 저장
    @PostMapping("/article")
    // 객체 타입(JSON)으로 변수를 가져와서 저장하기 = @RequestBody
    public Article createArticle(@RequestBody Article article){ // 메소드에는 타입과 변수명
        return articleService.createArticle(article);
    }


    @DeleteMapping("/article/{id}") // 주소/id값 -> @PathVariable
    public void deleteArticle(@PathVariable long id){
        // void 라서 return 값 x
        articleService.deleteArticle(id);
    }
//   => ArticleServiceImpl의 Delete부분을 참고해서 만들면 됨


     @PutMapping("/article/{id}")
     // id값을 이용해서 기존 자료를 가져와서 react에 표시
     public void updateArticle(@PathVariable Article article, @PathVariable long id){

     }

//     @GetMapping("/article/{id}")
//     public Article getArticleById(@PathVariable long id) {
//        // System.out.println(id);
//        // System.out.println(articleService.getArticleById(id));
//        // => Article(id=10, subject=test1, writer=test1, content=test1, ref=0, ref_step=0, ref_level=0, ip=null, regdate=2022-12-08T12:05:01)
//         return articleService.getArticleById(id);
//     }

//    public void getArticleById(@PathVariable long id) {
//        System.out.println(id);
//        System.out.println(articleService.getArticleById(id));
//    }
    // 디버깅은 이렇게 먼저, void 하고 return 없이 콘솔





}
