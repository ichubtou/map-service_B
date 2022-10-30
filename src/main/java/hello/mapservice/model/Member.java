package hello.mapservice.model;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "member")
@Data
@Getter
@Setter
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "member_memberid")
    private String memberId;

    @Column(name = "member_password")
    private String password;

    @Column(name = "member_nickname")
    private String nickName;

    @Column(name = "member_role")
    private Long memberRole;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Authority authority;

    @Builder
    public Member(Long id, String password, String userName, String nickName, String memberId, Long memberRole, Authority authority) {
        this.id = id;
        this.password = password;
        this.nickName = nickName;
        this.memberId = memberId;
        this.memberRole = memberRole;
        this.authority = authority;
    }
}