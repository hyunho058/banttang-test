package com.hproject.banttang.deal.entity;

import com.hproject.banttang.common.entity.value.BlindStatus;
import com.hproject.banttang.deal.entity.value.Category;
import com.hproject.banttang.deal.entity.value.CategoryDetail;
import com.hproject.banttang.location.entity.Location;
import com.hproject.banttang.user.entity.Member;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

class DealTest {
    @Test
    void 삭제된_거래는_deletedAt_값이_생성된다() {
        //give
        Deal deal = Deal.builder()
            .id(0L)
            .member(new Member())
            .title("제목1")
            .content("내용1")
            .location(Location.builder()
                .address1("서울특별시")
                .address2("역삼동")
                .build())
            .category(Category.BANTTANG)
            .categoryDetail(CategoryDetail.APPLIANCES)
            .beongaeCount(0L)
            .status(BlindStatus.TRADING)
            .tradeLatitude(37.5006)
            .tradeLongitude(127.036)
            .imageUrl(new ArrayList<>())
            .price(50000L)
            .maxParticipant(5L)
            .currentParticipant(2L)
            .dutchPay(10000L)
            .build();
        //when
        deal.deleteDeal();
        //then
        assertThat(deal.getDeletedAt()).isNotNull();
    }

    @Test
    void 게시글_작성_시간_1시간_지나면_0이돤다() {
        //give
        Deal deal = new Deal();
        //when
        Long remainTime1 = deal.remainingTimeCalculation(LocalDateTime.now().minusSeconds(3600));
        Long remainTime2 = deal.remainingTimeCalculation(LocalDateTime.now().minusSeconds(3601));
        //then
        assertThat(0L).isEqualTo(remainTime1);
        assertThat(0L).isEqualTo(remainTime2);
    }

    @Test
    void 거래글_등록후_한시간이_안지나면_남은시간_반환() {
        //give
        Deal deal = new Deal();
        //when
        Long remainTime1 = deal.remainingTimeCalculation(LocalDateTime.now().minusMinutes(30));
        Long remainTime2 = deal.remainingTimeCalculation(LocalDateTime.now().minusMinutes(59));
        //then
        assertThat(remainTime1 > 0).isTrue();
        assertThat(remainTime2 > 0).isTrue();
    }
}