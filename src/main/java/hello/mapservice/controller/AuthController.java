package hello.mapservice.controller;

import hello.mapservice.dto.MemberRequestDto;
import hello.mapservice.dto.MemberResponseDto;
import hello.mapservice.dto.TokenDto;
import hello.mapservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto requestDto) {
        return ResponseEntity.ok(authService.signup(requestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto requestDto) {
        return ResponseEntity.ok(authService.login(requestDto));
    }

    @GetMapping("/memberId/{memberId}/exists")
    public ResponseEntity<Boolean> checkmemberIdDuplicate(@PathVariable String memberId) {
        return ResponseEntity.ok(authService.checkmemberIdDuplicate(memberId));
    }

    @GetMapping("/nickname/{nickname}/exists")
    public ResponseEntity<Boolean> checkNickNameDuplicate(@PathVariable String nickname) {
        return ResponseEntity.ok(authService.checkNickNameDuplicate(nickname));
    }
}