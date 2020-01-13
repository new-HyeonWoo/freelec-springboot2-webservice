package com.hyeon.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// lombok 어노테이션 (필수 x)
@Getter
// 기본 생성자 자동추가
@NoArgsConstructor
// JPA 어노테이션
// - 테이블과 링크될 클래스임을 나타냄
// - 기본값으로 클래스의 카멜케이스 일므을 언더스코어 네이밍으로 이름을 매칭한다.
// - ex) SalesManager.java -> sales_manager table
@Entity
public class Posts {


    // 해당 테이블의 PK 필드를 나타냄
    @Id
    // PK 생성규칙
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 테이블 컬럼을 나타냄. 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 된다.
    // 옵션 선언 안하면 기본값 사용 (VARCHAR(255) 등..)
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

}

