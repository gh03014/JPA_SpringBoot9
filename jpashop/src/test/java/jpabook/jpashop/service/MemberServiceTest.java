package jpabook.jpashop.service;

import static org.junit.Assert.*;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class) //junit 실행시 스프링과 연동되어 실행
@SpringBootTest //스프링부트를 띄운 상태로 테스트 가능하도록 한다.
@Transactional
public class MemberServiceTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Autowired EntityManager em;

    @Test
    //@Rollback(false)
    public void 회원가입() throws Exception{
        Member member = new Member();
        member.setName("jaehwan");

        Long saveId = memberService.join(member);

        em.flush(); //RollBack은 하되 insert 쿼리를 확인하고자 할때 사용
        assertEquals(member, memberRepository.findOne(saveId));
    }

    @Test(expected = IllegalStateException.class) //try구문 없이 코드를 간결하게 사용가능
    public void 중복_회원_예외() throws Exception{
        Member member1 = new Member();
        member1.setName("jaehwan");
        Member member2 = new Member();
        member2.setName("jaehwan");

        memberService.join(member1);
        memberService.join(member2); //예외가 발생해야한다.
    }
}