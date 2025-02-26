package com.zerobase.SelfWash.member.domain.repository;

import com.zerobase.SelfWash.member.domain.entity.Owner;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

  Optional<Owner> findByEmail(String email);

  boolean existsByEmail(String email);
}
