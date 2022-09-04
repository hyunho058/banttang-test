package com.hproject.banttang.user.infra.connector.kakao;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

import java.beans.ConstructorProperties;

public interface KakaoService {
    @GET("/v2/user/me")
    Call<KakaoProfile> me(@Header("Authorization") String token);

    class KakaoProfile {
        private final String id;
        private final KakaoAccount kakaoAccount;

        @ConstructorProperties({"id", "kakao_account"})
        public KakaoProfile(String id, KakaoAccount kakaoAccount) {
            this.id = id;
            this.kakaoAccount = kakaoAccount;
        }

        public String getId() {
            return id;
        }

        public String getNickname() {
            return kakaoAccount.getNickname();
        }

        public String getImageUrl() {
            return kakaoAccount.getImageUrl();
        }

        public static class KakaoAccount {
            private final Profile profile;

            @ConstructorProperties({"profile"})
            public KakaoAccount(Profile profile) {
                this.profile = profile;
            }

            public Profile getProfile() {
                return profile;
            }

            public String getNickname() {
                return profile.getNickname();
            }

            public String getImageUrl() {
                return profile.getImageUrl();
            }

            public static class Profile {
                private final String nickname;
                private final String imageUrl;

                @ConstructorProperties({"nickname", "profile_image_url"})
                public Profile(String nickname, String imageUrl) {
                    this.nickname = nickname;
                    this.imageUrl = imageUrl;
                }

                public String getNickname() {
                    return nickname;
                }

                public String getImageUrl() {
                    return imageUrl;
                }
            }
        }
    }
}
