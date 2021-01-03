package hello_review.hellospring_review.service;



import hello_review.hellospring_review.aop.TimeTraceAop;
import hello_review.hellospring_review.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig
{
   // @Autowired  생성자가 1개인 경우 생략 가능
    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }



//    @Bean
//    public MemberRepository memberRepository()
//    {
        //return new MemoryMemberRepository();
        //memberRepository는 상위interface 이기에
        //interface를 상속받은 하위 클래스
        //MemoryMemberRepository를 주든
        //JdbcMemberRepository를 주든 상관 없다.
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);

//    }

}
