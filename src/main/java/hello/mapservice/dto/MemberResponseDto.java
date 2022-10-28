package hello.mapservice.dto;

import hello.mapservice.model.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberResponseDto {
    private String memberId;
    private String nickname;

    public static MemberResponseDto of(Member member) {
        return MemberResponseDto.builder()
                .memberId(member.getMemberId())
                .nickname(member.getNickName())
                .build();
    }
}