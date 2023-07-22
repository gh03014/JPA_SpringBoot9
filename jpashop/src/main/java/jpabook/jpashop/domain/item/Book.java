package jpabook.jpashop.domain.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("B") //Item이 싱글테이블이므로 book 상품의 dtype를 전달한다.
@Getter @Setter
public class Book extends Item{
    private String author;
    private String isbn;
}
