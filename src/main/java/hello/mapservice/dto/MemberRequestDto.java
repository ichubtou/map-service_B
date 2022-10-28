package hello.mapservice.dto;

import hello.mapservice.model.Authority;
import hello.mapservice.model.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberRequestDto {
    private String memberId;
    private String password;
    private String nickname;
    private String username;
    private Long memberRole;

    public Member toMember(PasswordEncoder passwordEncoder) {
        return Member.builder()
                .memberId(memberId)
                .password(passwordEncoder.encode(password))
                .nickName(nickname)
                .memberRole(memberRole)
                .authority(Authority.ROLE_USER)
                .build();
    }

    public UsernamePasswordAuthenticationToken toAuthentication() {
        return new UsernamePasswordAuthenticationToken(memberId, password);
    }
}