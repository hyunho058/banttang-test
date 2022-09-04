package com.hproject.banttang.deal.infra.repository.custom;

import com.hproject.banttang.deal.controller.request.DealFilterRequest;
import com.hproject.banttang.deal.entity.Deal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface DealRepositoryCustom {
    Page<Deal> findDeals(Pageable pageable, DealFilterRequest dealFilterRequest);

    Optional<Deal> findDealAndUser(Long id);

    Page<Deal> findUserDeals(Pageable pageable, long id);

    Page<Deal> findUserParticipates(Pageable pageable, Long id);
}
