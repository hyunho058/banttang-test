package com.hproject.banttang.deal.service;

import com.hproject.banttang.common.controller.request.PagingRequest;
import com.hproject.banttang.common.entity.value.BlindStatus;
import com.hproject.banttang.common.service.file.FileUploadService;
import com.hproject.banttang.deal.controller.request.DealFilterRequest;
import com.hproject.banttang.deal.controller.request.DealSavingRequest;
import com.hproject.banttang.deal.controller.request.DealUpdateRequest;
import com.hproject.banttang.deal.entity.Deal;
import com.hproject.banttang.deal.infra.repository.DealRepository;
import com.hproject.banttang.deal.service.exception.DealNotFoundException;
import com.hproject.banttang.location.entity.Location;
import com.hproject.banttang.location.infra.repository.LocationRepository;
import com.hproject.banttang.user.entity.Member;
import com.hproject.banttang.user.exception.UserNotFoundException;
import com.hproject.banttang.user.infra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DealService {
    private final UserRepository userRepository;
    private final DealRepository dealRepository;
    private final LocationRepository locationRepository;
    private final FileUploadService fileUploadService;

    @Transactional
    public Deal saveDeal(DealSavingRequest request) {
        Member member = userRepository.findById(request.getUserId())
                .orElseThrow(UserNotFoundException::new);

        Location location = getLocation(
                request.getAddress1(),
                request.getAddress2()
        );

        return dealRepository.save(
                Deal.builder()
                        .member(member)
                        .title(request.getTitle())
                        .content(request.getContent())
                        .location(location)
                        .category(request.getCategory())
                        .categoryDetail(request.getCategoryDetail())
                        .beongaeCount(0L)
                        .status(BlindStatus.TRADING)
                        .imageUrl(request.getImageUrls())
                        .tradeLatitude(request.getTradeLatitude())
                        .tradeLongitude(request.getTradeLongitude())
                        .price(request.getPrice())
                        .dutchPay(request.getDutchPay())
                        .maxParticipant(request.getMaxParticipant())
                        .currentParticipant(1L)
                        .build()
        );
    }

    public Page<Deal> findDeals(DealFilterRequest dealFilterRequest,
                                PagingRequest pagingRequest) {
        return dealRepository.findDeals(
                PageRequest.of(
                        pagingRequest.getPage(),
                        pagingRequest.getPerPage()
                ),
                dealFilterRequest
        );
    }

    @Transactional
    public Deal updateDeal(DealUpdateRequest request) {
        Deal findDeal = dealRepository.findById(request.getId())
                .map(deal -> deal.updateDeal(
                        request,
                        getLocation(
                                request.getAddress1(),
                                request.getAddress2()
                        )
                ))
                .orElseThrow(DealNotFoundException::new);
        return findDeal;
    }

    public Location getLocation(String address1, String address2) {
        return locationRepository.findByAddress1AndAddress2(
                address1,
                address2
        ).orElseGet(
                () -> locationRepository.save(
                        Location.builder()
                                .address1(address1)
                                .address2(address2)
                                .build()
                )
        );
    }

    public Deal findDeal(Long id) {
        return dealRepository.findDealAndUser(id)
                .orElseThrow(DealNotFoundException::new);
    }

    @Transactional
    public void deleteDeal(Long id) {
        Deal deal = dealRepository.findByIdAndDeletedAtIsNull(id)
                .orElseThrow(DealNotFoundException::new);
        deal.deleteDeal();
    }

    public Page<Deal> findUserDeals(PagingRequest pagingRequest, Long userId) {
        return dealRepository.findUserDeals(
                PageRequest.of(
                        pagingRequest.getPage(),
                        pagingRequest.getPerPage()
                ),
                userId
        );
    }

    public Page<Deal> findUserParticipates(PagingRequest pagingRequest, Long userId) {
        return dealRepository.findUserParticipates(
                PageRequest.of(
                        pagingRequest.getPage(),
                        pagingRequest.getPerPage()
                ),
                userId
        );
    }
}
