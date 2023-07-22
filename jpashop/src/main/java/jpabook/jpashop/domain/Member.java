package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private long id;

    private String name;

    @Embedded  //JPA 내장 타입
    private Address address;

    //mappedBy를 사용하여 다른 객체(Order)에 의해 매핑되었음을 의미
    @OneToMany(mappedBy = "member")  //일대다 관계
    private List<Order> orders = new ArrayList<>();
}
