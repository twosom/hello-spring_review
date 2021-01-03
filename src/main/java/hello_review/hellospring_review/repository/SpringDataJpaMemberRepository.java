package hello_review.hellospring_review.repository;

import hello_review.hellospring_review.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository
{
    //JPQL select m from Member m where m.name=?
    @Override
    Optional <Member> findByName(String name);
}
