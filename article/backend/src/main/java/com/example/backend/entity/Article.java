package com.example.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter // getter 안만들게요
@Setter // setter 안만들게요
@NoArgsConstructor // 빈생성자 안만들게요
@AllArgsConstructor // 파라미터 있는 생성자도 안만들게요
@ToString
@Table(name="article") // 테이블 이름과 똑같이 맞출테니 이 테이블에 저장해주세요
// 테이블 안의 이름과 Model 멤버변수 이름이 동일하면 저장
public class Article {
    // 멤버변수, 생성자(파라x), 생성자(파라o), getter, setter, toString
    @Id //Jakarta
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;  // db 에 bigint
    @Column(name="subject")// 테이블 컬럼의 subject 에 저장
    private String subject;
    @Column(name="writer")
    private String writer;
    @Column(name="content")
    private String content;
    @Column(name="ref")
    private int ref;
    @Column(name="ref_step")
    private int ref_step;
    @Column(name="ref_level")
    private int ref_level;
    @Column(name="ip")
    private String ip;
    @Column(name="regdate")
    @CreationTimestamp // 현재 날짜 생성 메소드 : now() 와 비슷
    private LocalDateTime regdate;
}
