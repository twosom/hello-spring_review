package hello_review.hellospring_review.service;

import hello_review.hellospring_review.domain.Member;
import hello_review.hellospring_review.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;


    @BeforeEach
    public void beforeEach()
    {
        memberService = new MemberService(new MemoryMemberRepository());
    }

   /* @AfterEach
    public void afterEach()
    {
        memberRepository.clearStore();
    }*/

    @Test

    void 회원가입() {
        //given : 뭔가가 주어졌는데
        Member member = new Member();
        member.setName("hello");

        //when : 이것을 실행했을 때
        Long saveId = memberService.join(member);

        //then : 결과가 이게 나와야 한다.
        Member result = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(result.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");



        /*try {
            memberService.join(member2);
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/


        //then
    }

    @Test
    void findMembers() {

    }

    @Test
    void findOne() {

    }
}