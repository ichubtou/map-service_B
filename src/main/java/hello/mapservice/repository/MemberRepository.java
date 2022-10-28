package hello.mapservice.repository;

import hello.mapservice.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends  JpaRepository<Member, Long>{
    Optional<Member> findByMemberId(String memberId);
    boolean existsByMemberId(String memberId);
    boolean existsByNickName(String nickname);
}
