package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;
import lombok.RequiredArgsConstructor;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository//repository로 지정하여 스프링 빈에서 자동으로 등록하도록 한다.
@RequiredArgsConstructor //final 타입으로 선언된 생성자를 자동으로 인젝션 해준다
public class MemberRepository { //회원 리포지토리
    private final EntityManager em;

    //lombok의 @RequiredArgsConstructor 기능을 사용하면 이 코드는 사용할 필요없음
    //@PersistenceContext //자동으로 스피링빈으로 주입
    //private EntityManager em;

    //JPA Insert -  회원저장
    public void save(Member member){
        em.persist(member);
    }

    //JPA Select 리턴 - 회원 조회
    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    //모든 회원 조회 - 회원목록
    //createQuery를 사용하여 쿼리 지정
    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    //이름을 기준으로 회원 목록 조회
    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name).getResultList();
    }
}
