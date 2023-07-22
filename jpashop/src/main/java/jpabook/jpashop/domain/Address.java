package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable  //JPA 내장 타입
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    //실무에서 사용시 주소정보는 임의로 수정해서는 안되므로
    //Getter만 구현하고 아래와 같이 protected 타입으로 수정을 하면 안됨을 표시한다.
    //생성자에서 값을 모두 초기화하여 변경 불가능하도록 한다.
    protected Address() {

    }

    public Address(String city, String street, String zipcode){
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
