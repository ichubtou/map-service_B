//package hello.mapservice.repository;
//
//import hello.mapservice.model.Member;
//import hello.mapservice.model.UserRole;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.transaction.annotation.Transactional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest
//class MemberRepositoryTest {
//    @Autowired
//    MemberRepository repository;
//
//    @Test
//    @Transactional
//    @Rollback(false)
//    public void testMember() {
//        Member member = new Member(1, "aaa", "0000", "김에이", "에이", "aaa@aaa.com", 1, UserRole.USER);
//
//        repository.save(member);
//
//        Member findMember = repository.findByUserName(member.getUserName());
//
//        assertEquals(findMember.getMemberId(), member.getMemberId());
//        assertEquals(findMember.getNickName(), member.getNickName());
//        assertEquals(findMember.getRole(), member.getRole());
//        assertEquals(findMember, member);
//
//    }
//}