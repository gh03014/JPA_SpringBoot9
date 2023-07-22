package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("M") //Item이 싱글테이블이므로 movie 상품의 dtype를 전달한다.
@Getter @Setter
public class Movie extends Item{
    private String director;
    private String actor;
}
