package com.hproject.banttang.location.infra.repository;

import com.hproject.banttang.location.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Optional<Location> findByAddress1AndAddress2(String address1, String address2);
}
