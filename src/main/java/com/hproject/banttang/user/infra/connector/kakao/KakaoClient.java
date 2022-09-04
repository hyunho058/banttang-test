package com.hproject.banttang.user.infra.connector.kakao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hproject.banttang.user.exception.FailedResponseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.Optional;

@Component
public class KakaoClient {
    private final KakaoService kakaoService;

    @Autowired
    public KakaoClient(ObjectMapper objectMapper) {
        this.kakaoService = new Retrofit.Builder()
                .baseUrl("https://kapi.kakao.com")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build()
                .create(KakaoService.class);
    }

    public Optional<KakaoService.KakaoProfile> profile(String accessToken) {
        try {
            var response = kakaoService.me("Bearer " + accessToken)
                    .execute();

            if (!response.isSuccessful()) {
                return Optional.empty();
            }

            return Optional.ofNullable(response.body());
        } catch (IOException e) {
            throw new FailedResponseException(e);
        }
    }
}
