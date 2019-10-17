package com.challenge.orderservice.security.handler;

import com.challenge.orderservice.exception.handler.ErrorMessage;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

@Component

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(
            final HttpServletRequest request, final HttpServletResponse response,
            final AuthenticationException authenticationException) throws IOException {

        final List<ErrorMessage> errorMessages = Collections.singletonList(
                ErrorMessage.builder()
                        .developerMessage("Unauthorized")
                        .userMessage("You are not authorized to perform this operation")
                        .errorCode(1)
                        .build());

        response.setCharacterEncoding(StandardCharsets.UTF_8.displayName());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.getWriter().println(new Gson().toJson(errorMessages));
    }
}
