package hello_review.hellospring_review.service;

import hello_review.hellospring_review.domain.Member;
import hello_review.hellospring_review.repository.MemberRepository;
import hello_review.hellospring_review.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    @Autowired MemberService memberService;
    //SpringConfgi에 JdbcMemberRepository로 Bean설정이 되어 있음.
    //인터페이스로 정의
    @Autowired MemberRepository memberRepository;


    @Test
    void 회원가입() {

        //given : 뭔가가 주어졌는데
        Member member = new Member();
        member.setName("spring100");

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
}