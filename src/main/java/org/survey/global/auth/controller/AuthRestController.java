package org.survey.global.auth.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.survey.domain.member.service.MemberService;
import org.survey.global.auth.service.RefreshTokenService;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthRestController {
    private final MemberService memberService;
    private final RefreshTokenService refreshTokenService;

}
