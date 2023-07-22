package jpabook.jpashop.domain;


import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Category {
    @Id
    @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany //다대다 관계
    //관계형DB는 다대다 관계를 이어줄 중간 collection이 없으므로 일대다 관례로 연결할 값을 지정해야한다
    @JoinTable(name = "category_item",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id")
    )
    private List<Item> items = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent; //부모 객체

    @OneToMany(mappedBy = "parent") //parent 객체에서 매핑됨을 의미
    private List<Category> child = new ArrayList<>(); //자식 객체
}
