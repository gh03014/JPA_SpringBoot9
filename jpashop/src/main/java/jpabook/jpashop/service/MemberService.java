package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service//Component 스캔 대상이 되어 스프링 빈에 자동으로 등록하도록 설정한다.
@Transactional //트랜젝션
@RequiredArgsConstructor //final 타입으로 선언된 생성자를 자동으로 인젝션 해준다
public class MemberService {
    //생성자 인젝션이 이루어졌는지 판단하기 위해 final 타입 선언
    private final MemberRepository memberRepository;

    //lombok의 @RequiredArgsConstructor 기능을 사용하면 이 코드는 사용할 필요없음
    //@Autowired//회원 리포지토리를 자동으로 인젝션, 생성자 인젝션
    //public MemberService(MemberRepository memberRepository){
    //    this.memberRepository = memberRepository;
    //}

    //회원가입
    @Transactional
    public Long join(Member member){
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    //회원 중복 검사
    public void validateDuplicateMember(Member member){
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    @Transactional(readOnly = true) //읽기전용 트랜젝션, 불필요한 리소스 과부하 방지
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    //회원 조회
    @Transactional(readOnly = true) //읽기전용 트랜젝션, 불필요한 리소스 과부하 방지
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }
}
