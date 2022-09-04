package com.hproject.banttang.deal.service;

import com.hproject.banttang.common.service.file.FileUploadService;
import com.hproject.banttang.deal.controller.request.DealSavingRequest;
import com.hproject.banttang.deal.controller.request.DealUpdateRequest;
import com.hproject.banttang.deal.entity.Deal;
import com.hproject.banttang.deal.entity.value.Category;
import com.hproject.banttang.deal.entity.value.CategoryDetail;
import com.hproject.banttang.deal.infra.repository.DealRepository;
import com.hproject.banttang.deal.service.exception.DealNotFoundException;
import com.hproject.banttang.location.entity.Location;
import com.hproject.banttang.location.infra.repository.LocationRepository;
import com.hproject.banttang.user.entity.Member;
import com.hproject.banttang.user.exception.UserNotFoundException;
import com.hproject.banttang.user.infra.repository.UserRepository;
import org.apache.catalina.security.SecurityUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DealServiceTest {
    @InjectMocks
    private DealService dealService;
    @Mock
    private DealRepository dealRepository;
    @Mock
    private LocationRepository locationRepository;
    @Mock
    private UserRepository userRepository;
    @Mock
    private FileUploadService fileUploadService;
    private static MockedStatic<SecurityUtil> securityUtilMockedStatic;

    @BeforeAll
    public static void beforeClass() {
        securityUtilMockedStatic = mockStatic(SecurityUtil.class);
    }

    @AfterAll
    public static void afterClass() {
        securityUtilMockedStatic.close();
    }

    @Test
    void 거래등록_유저정보가_있을때() {
        //give
        List<String> images = new ArrayList<>();
        images.add("http://www.image.com/image.jpg");
        DealSavingRequest dealSavingRequest = DealSavingRequest
                .builder()
                .title("title")
                .content("content")
                .category(Category.BANTTANG)
                .address1("서울특별시 강남구")
                .address2("역삼동")
                .tradeLongitude(127.048)
                .tradeLatitude(35.5045)
                .price(50000L)
                .dutchPay(20000L)
                .maxParticipant(5L)
                .imageUrls(images)
                .build();
        when(locationRepository.findByAddress1AndAddress2(any(), any())).thenReturn(Optional.of(new Location()));
        when(userRepository.findById(any())).thenReturn(Optional.of(new Member()));

        //when, then
        assertDoesNotThrow(() -> dealService.saveDeal(dealSavingRequest));
        verify(userRepository, times(1)).findById(any());
        verify(dealRepository, times(1)).save(any());
    }

    @Test
    void 거래등록_유저정보가_없을때() {
        //give
        List<String> images = new ArrayList<>();
        images.add("http://www.image.com/image.jpg");
        DealSavingRequest dealSavingRequest = DealSavingRequest
                .builder()
                .title("title")
                .content("content")
                .category(Category.BANTTANG)
                .address1("서울특별시 강남구")
                .address2("역삼동")
                .tradeLongitude(127.048)
                .tradeLatitude(35.5045)
                .price(50000L)
                .dutchPay(20000L)
                .maxParticipant(5L)
                .imageUrls(images)
                .build();

        //when
        when(userRepository.findById(any())).thenReturn(Optional.empty());

        //then
        assertThrows(UserNotFoundException.class, () -> {
            dealService.saveDeal(dealSavingRequest);
        });
    }

    @Test
    void 지역정보_있을때() {
        //give
        String address1 = "서울특별시 강남구";
        String address2 = "역삼동";

        //when
        when(locationRepository.findByAddress1AndAddress2(address1, address2))
                .thenReturn(Optional.of(
                        Location.builder()
                                .address1(address1)
                                .address2(address2)
                                .build())
                );

        //then
        assertDoesNotThrow(() -> dealService.getLocation(address1, address2));
        verify(locationRepository, times(1)).findByAddress1AndAddress2(address1, address2);
        assertThat(dealService.getLocation(address1, address2).getAddress1()).isEqualTo(address1);
        assertThat(dealService.getLocation(address1, address2).getAddress2()).isEqualTo(address2);
    }

    @Test
    void 지역정보_없을때() {
        //give
        String address1 = "서울특별시 강남구";
        String address2 = "역삼동";

        //when
        when(locationRepository.findByAddress1AndAddress2(address1, address2)).thenReturn(Optional.empty());

        //then
        assertDoesNotThrow(() -> dealService.getLocation(address1, address2));
        verify(locationRepository, times(1)).findByAddress1AndAddress2(address1, address2);
        verify(locationRepository, times(1)).save(any());
    }

    @Test
    void 거래상세_조회_성공() {
        //give
        long id = 0l;

        //when
        when(dealRepository.findDealAndUser(id)).thenReturn(Optional.of(new Deal()));

        //then
        assertDoesNotThrow(() -> dealService.findDeal(id));
        verify(dealRepository, times(1)).findDealAndUser(any());
    }

    @Test
    void 거래상세_조회_실패() {
        //give
        long id = 0l;

        //when
        when(dealRepository.findDealAndUser(id)).thenReturn(Optional.empty());

        //then
        assertThrows(DealNotFoundException.class, () -> {
                    dealService.findDeal(id);
                }
        );
        verify(dealRepository, times(1)).findDealAndUser(id);
    }

    @Test
    void 거래_수정_거래_없을때() {
        //give
        DealUpdateRequest dealUpdateRequest = DealUpdateRequest.builder()
                .id(0L)
                .title("title")
                .content("content")
                .address1("서울특별시 강남구")
                .address2("역삼동")
                .tradeLongitude(127.048)
                .tradeLatitude(35.5045)
                .category(Category.BANTTANG)
                .categoryDetail(CategoryDetail.APPLIANCES)
                .price(50000L)
                .dutchPay(25000L)
                .maxParticipant(5L)
                .build();

        //when
        when(dealRepository.findById(dealUpdateRequest.getId())).thenReturn(Optional.empty());

        //then
        assertThrows(DealNotFoundException.class,
                () -> dealService.updateDeal(dealUpdateRequest)
        );
        verify(dealRepository, times(1)).findById(dealUpdateRequest.getId());
    }

    @Test
    void 거래_수정_거래_있을때() {
        //give
        List<String> images = new ArrayList<>();
        images.add("http://www.image.com/image.jpg");
        List<String> deleteImages = new ArrayList<>();
        images.add("http://www.image11.com/image.jpg");
        DealUpdateRequest dealUpdateRequest = DealUpdateRequest.builder()
                .id(0L)
                .title("title")
                .content("content")
                .address1("서울특별시 강남구")
                .address2("역삼동")
                .tradeLongitude(127.048)
                .tradeLatitude(35.5045)
                .category(Category.BANTTANG)
                .categoryDetail(CategoryDetail.APPLIANCES)
                .price(50000L)
                .dutchPay(25000L)
                .maxParticipant(5L)
                .imageUrls(images)
                .deleteImages(deleteImages)
                .build();

        //when
        when(dealRepository.findById(dealUpdateRequest.getId()))
                .thenReturn(Optional.of(new Deal()));

        //then
        assertDoesNotThrow(
                () -> dealService.updateDeal(dealUpdateRequest)
        );
        verify(dealRepository, times(1)).findById(any());
    }

    @Test
    void 게시글삭제() {
        //given
        Long id = 1L;
        //when
        when(dealRepository.findByIdAndDeletedAtIsNull(any())).thenReturn(Optional.of(new Deal()));
        //then
        assertDoesNotThrow(() -> {
            dealService.deleteDeal(id);
        });


    }

    @Test
    void 게시글_삭제_댓글_못_찾을_때_DealNotFoundException_확인() {
        //given
        Long id = 1L;
        when(dealRepository.findByIdAndDeletedAtIsNull(any())).thenReturn(Optional.empty());

        //when,then
        assertThrows(DealNotFoundException.class, () -> {
            dealService.deleteDeal(id);
        });
    }

    @Test
    void 번개_거래_남은시간_계산() {

    }
}