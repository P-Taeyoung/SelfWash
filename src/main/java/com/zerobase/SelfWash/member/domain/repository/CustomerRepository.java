package com.zerobase.SelfWash.member.domain.repository;

import com.zerobase.SelfWash.member.domain.entity.Customer;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

  Optional<Customer> findByEmail(String email);

  boolean existsByEmail(String email);
}
