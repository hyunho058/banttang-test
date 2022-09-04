package com.hproject.banttang.deal.controller;

import com.hproject.banttang.common.controller.request.PagingRequest;
import com.hproject.banttang.common.controller.response.EmptyResponse;
import com.hproject.banttang.common.controller.response.ListResponse;
import com.hproject.banttang.common.controller.response.Paging;
import com.hproject.banttang.common.controller.response.SingleResponse;
import com.hproject.banttang.deal.controller.request.DealFilterRequest;
import com.hproject.banttang.deal.controller.request.DealSavingRequest;
import com.hproject.banttang.deal.controller.request.DealUpdateRequest;
import com.hproject.banttang.deal.controller.response.DealResponse;
import com.hproject.banttang.deal.entity.Deal;
import com.hproject.banttang.deal.service.DealService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import static java.util.stream.Collectors.toList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/deals")
public class DealController {
    private final DealService dealService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public SingleResponse<DealResponse> createDeal(@RequestBody @Valid DealSavingRequest request) {
        Deal deal = dealService.saveDeal(request);
        return new SingleResponse.Ok<>(
            new DealResponse(deal)
        );
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ListResponse<DealResponse> findDeals(@Valid DealFilterRequest dealFilterRequest,
                                                @Valid PagingRequest pagingRequest) {

        Page<Deal> findDeals = dealService.findDeals(dealFilterRequest, pagingRequest);

        return new ListResponse.Ok<>(
            findDeals.stream()
                .map(DealResponse::new)
                .collect(toList()),
            Paging.builder()
                .perPage(findDeals.getSize())
                .currentPage(findDeals.getNumber())
                .totalPage(findDeals.getTotalPages())
                .totalCount(findDeals.getTotalElements())
                .build()
        );
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public SingleResponse<DealResponse> updateDeal(@RequestBody @Valid DealUpdateRequest request) {
        Deal deal = dealService.updateDeal(request);
        return new SingleResponse.Ok<>(
            new DealResponse(deal)
        );
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public EmptyResponse deleteDeal(@RequestParam @NotEmpty Long id) {
        dealService.deleteDeal(id);
        return new EmptyResponse.Ok<>();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SingleResponse<DealResponse> findDetailDeal(@PathVariable Long id) {
        Deal deal = dealService.findDeal(id);

        return new SingleResponse.Ok<>(
            new DealResponse(deal)
        );
    }

    @GetMapping("/mydeals/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ListResponse<DealResponse> findMyDeals(@PathVariable Long userId,
                                                  @Valid PagingRequest pagingRequest) {
        Page<Deal> findDeals = dealService.findUserDeals(pagingRequest, userId);

        return new ListResponse.Ok<>(
            findDeals.stream()
                .map(DealResponse::new)
                .collect(toList()),
            Paging.builder()
                .perPage(findDeals.getSize())
                .currentPage(findDeals.getNumber())
                .totalPage(findDeals.getTotalPages())
                .totalCount(findDeals.getTotalElements())
                .build()
        );
    }

    @GetMapping("/myparticipants/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public ListResponse<DealResponse> findMyDealParticipant(@PathVariable Long userId,
                                                            @Valid PagingRequest pagingRequest
    ) {
        Page<Deal> findDeals = dealService.findUserParticipates(pagingRequest, userId);

        return new ListResponse.Ok<>(
            findDeals.stream()
                .map(DealResponse::new)
                .collect(toList()),
            Paging.builder()
                .perPage(findDeals.getSize())
                .currentPage(findDeals.getNumber())
                .totalPage(findDeals.getTotalPages())
                .totalCount(findDeals.getTotalElements())
                .build()
        );
    }
}
