package study.querydsl.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * packageName    : study.querydsl.entity
 * fileName       : Hello
 * author         : 김재성
 * date           : 2022-07-19
 * description    :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022-07-19        김재성       최초 생성
 */

@Entity
@Getter
@Setter
public class Hello {

    @Id
    @GeneratedValue
    private Long id;

}
