package com.hproject.banttang.deal.controller;

import com.hproject.banttang.common.controller.request.PagingRequest;
import com.hproject.banttang.common.controller.response.EmptyResponse;
import com.hproject.banttang.common.controller.response.ListResponse;
import com.hproject.banttang.common.controller.response.SingleResponse;
import com.hproject.banttang.common.entity.value.BlindStatus;
import com.hproject.banttang.deal.controller.request.DealFilterRequest;
import com.hproject.banttang.deal.controller.request.DealSavingRequest;
import com.hproject.banttang.deal.controller.request.DealUpdateRequest;
import com.hproject.banttang.deal.controller.response.DealResponse;
import com.hproject.banttang.deal.entity.Deal;
import com.hproject.banttang.deal.entity.value.Category;
import com.hproject.banttang.deal.entity.value.CategoryDetail;
import com.hproject.banttang.deal.service.DealService;
import com.hproject.banttang.location.entity.Location;
import com.hproject.banttang.user.entity.Member;
import com.hproject.banttang.user.entity.value.Provider;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DealControllerTest {
    @InjectMocks
    private DealController controller;
    @Mock
    private DealService dealService;

    @Test
    void 거래글_등록() {
        //give
        Long userId = 1L;
        String title = "제목";
        String address1 = "서울특별시 강남구";
        String address2 = "역삼동";
        List<String> images = new ArrayList<>();
        images.add("http://www.image.com/image.jpg");
        DealSavingRequest request = new DealSavingRequest(
            1L,
            title,
            "내용",
            Category.BANTTANG,
            CategoryDetail.APPLIANCES,
            address1,
            address2,
            127.123,
            37.828,
            20000L,
            10000L,
            5L,
            images
        );
        //when
        when(dealService.saveDeal(any())).thenReturn(
            new Deal(1L,
                new Member(
                    userId,
                    "name",
                    Provider.KAKAO,
                    "userKey",
                    "password",
                    null,
                    null,
                    "refreshToken",
                    "fcmToken",
                    "imageUrl"
                ),
                title,
                "내용",
                new Location(1L, address1, address2),
                Category.BANTTANG,
                CategoryDetail.APPLIANCES,
                LocalDateTime.now(),
                0L,
                BlindStatus.TRADING,
                127.123,
                37.828,
                images,
                null,
                20000L,
                5L,
                0L,
                10000L
            )
        );
        SingleResponse<DealResponse> result = controller.createDeal(request);

        //then
        assertNotNull(result);
        assertEquals(title, result.getContent().getTitle());
    }

    @Test
    void 거래리스트_조회() {
        //give
        String address1 = "서울특별시 강남구";
        String address2 = "역삼동";
        List<String> images = new ArrayList<>();
        images.add("http://www.image.com/image.jpg");

        DealFilterRequest dealFilterRequest = new DealFilterRequest(
            Category.BANTTANG,
            CategoryDetail.APPLIANCES,
            null,
            null,
            null
        );
        PagingRequest pagingRequest = new PagingRequest(0, 10);

        //when
        when(dealService.findDeals(any(), any())).thenReturn(new PageImpl<Deal>(
            Arrays.asList(
                new Deal(1L,
                    new Member(
                        1L,
                        "name",
                        Provider.KAKAO,
                        "userKey",
                        "password",
                        null,
                        null,
                        "refreshToken",
                        "fcmToken",
                        "imageUrl"
                    ),
                    "title",
                    "내용",
                    new Location(1L, address1, address2),
                    Category.BANTTANG,
                    CategoryDetail.APPLIANCES,
                    LocalDateTime.now(),
                    0L,
                    BlindStatus.TRADING,
                    127.123,
                    37.828,
                    images,
                    null,
                    20000L,
                    5L,
                    0L,
                    10000L
                ),
                new Deal(2L,
                    new Member(
                        1L,
                        "name",
                        Provider.KAKAO,
                        "userKey",
                        "password",
                        null,
                        null,
                        "refreshToken",
                        "fcmToken",
                        "imageUrl"
                    ),
                    "title",
                    "내용",
                    new Location(1L, address1, address2),
                    Category.BANTTANG,
                    CategoryDetail.APPLIANCES,
                    LocalDateTime.now(),
                    0L,
                    BlindStatus.TRADING,
                    127.123,
                    37.828,
                    images,
                    null,
                    20000L,
                    5L,
                    0L,
                    10000L
                )
            )
        ));
        ListResponse<DealResponse> result = controller.findDeals(dealFilterRequest, pagingRequest);

        //then
        assertAll(
            () -> assertNotNull(result),
            () -> assertThat(result.getItems().size()).isEqualTo(2),
            () -> assertThat(result.getPaging().getCurrentPage()).isEqualTo(0),
            () -> assertThat(result.getPaging().getTotalPage()).isEqualTo(1),
            () -> assertThat(result.getPaging().getTotalCount()).isEqualTo(2)
        );
    }

    @Test
    void 거래글_수정() {
        //give
        Long dealId = 1L;
        String title = "제목";
        String address1 = "서울특별시 강남구";
        String address2 = "역삼동";
        List<String> images = new ArrayList<>();
        images.add("http://www.image.com/image.jpg");
        DealUpdateRequest request = new DealUpdateRequest(
            dealId,
            title,
            "내용",
            Category.BANTTANG,
            CategoryDetail.APPLIANCES,
            address1,
            address2,
            127.123,
            37.828,
            20000L,
            10000L,
            5L,
            images,
            images
        );

        //when
        when(dealService.updateDeal(any())).thenReturn(
            new Deal(1L,
                new Member(
                    1L,
                    "name",
                    Provider.KAKAO,
                    "userKey",
                    "password",
                    null,
                    null,
                    "refreshToken",
                    "fcmToken",
                    "imageUrl"
                ),
                title,
                "내용",
                new Location(1L, address1, address2),
                Category.BANTTANG,
                CategoryDetail.APPLIANCES,
                LocalDateTime.now(),
                0L,
                BlindStatus.TRADING,
                127.123,
                37.828,
                images,
                null,
                20000L,
                5L,
                0L,
                10000L
            )
        );

        SingleResponse<DealResponse> result = controller.updateDeal(request);

        //then
        assertNotNull(result);
        assertEquals(title, result.getContent().getTitle());
    }

    @Test
    void 거래글_상세_조회() {
        //give
        Long id = 1L;
        String address1 = "서울특별시 강남구";
        String address2 = "역삼동";
        List<String> images = new ArrayList<>();
        images.add("http://www.image.com/image.jpg");

        //when
        when(dealService.findDeal(id)).thenReturn(
            new Deal(id,
                new Member(
                    1L,
                    "name",
                    Provider.KAKAO,
                    "userKey",
                    "password",
                    null,
                    null,
                    "refreshToken",
                    "fcmToken",
                    "imageUrl"
                ),
                "title",
                "내용",
                new Location(1L, address1, address2),
                Category.BANTTANG,
                CategoryDetail.APPLIANCES,
                LocalDateTime.now(),
                0L,
                BlindStatus.TRADING,
                127.123,
                37.828,
                images,
                null,
                20000L,
                5L,
                0L,
                10000L
            )
        );

        SingleResponse<DealResponse> result = controller.findDetailDeal(id);

        //then
        assertNotNull(result);
        assertEquals(id, result.getContent().getId());
    }

    @Test
    void 거래_삭제() {
        //given
        Long id = 1L;

        //when
        doNothing().when(dealService).deleteDeal(any());
        EmptyResponse result = controller.deleteDeal(id);

        //then
        AssertionsForClassTypes.assertThat(result).isNotNull();
    }
}