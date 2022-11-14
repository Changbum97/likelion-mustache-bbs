package com.mustache.springbootmustachebbs.product_exercise.domain.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")    // 생략 가능
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // 상품 번호

    @Column(nullable = false)
    private String name;        // 상품 이름

    @Column(nullable = false)
    private Integer price;      // 상품 가격

    @Column(nullable = false)
    private Integer stock;      // 상품 재고

    private LocalDateTime createdAt;    // 상품 생성 일자
    private LocalDateTime updatedAt;    // 상품 정보 변경 일자

    @Transient      // 해당 컬럼을 제외하고 싶을때 사용
    private String aaa;
}
