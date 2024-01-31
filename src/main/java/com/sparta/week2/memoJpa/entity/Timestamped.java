package com.sparta.week2.memoJpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
/*
@MappedSuperclass : JPA 엔티티 클래스들이 해당 추상 클래스를 상속할 경우
추삭 클래스에 선언한 멤버 변수를 컬럼으로 인식해줌 (추상 클래스가 아니어도 됨)
@EntityListeners(AuditingEntityListener.class) :
헤딩 클렛,ㅇ[ Auditing 기능을 부여해줌
 */
public abstract class Timestamped {

    @CreatedDate
    @Column(updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    /*
    @CreatedDate : 엔티티 객체가 생성되어 저장될 때 생성 시간을 저장해줌
    @Column(updatable = false) : 한번 생성되면 그 후 변경되지 않게 하는 역할
     */
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    /*
    @LastModifiedDate : 조회한 엔티티 객체의 값을 변경할 때 변경된 시간이 저장됨
    @Temporal : 날짜 데이터 타입을 매핑할 때 사용
     */
    private LocalDateTime modifiedAt;
}