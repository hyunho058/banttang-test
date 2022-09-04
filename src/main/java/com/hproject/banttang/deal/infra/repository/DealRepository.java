package com.hproject.banttang.deal.infra.repository;

import com.hproject.banttang.deal.entity.Deal;
import com.hproject.banttang.deal.infra.repository.custom.DealRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DealRepository extends JpaRepository<Deal, Long>, DealRepositoryCustom {
    Deal findByTitle(String title);

    Optional<Deal> findByIdAndDeletedAtIsNull(Long id);
}
