package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("A") //Item이 싱글테이블이므로 Album 상품의 dtype를 전달한다.
@Getter @Setter
public class Album extends Item{
    private String artist;
    private String etc;
}
