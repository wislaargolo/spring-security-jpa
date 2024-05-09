package br.com.ufrn.imd.securityexample.repository;

import java.util.Optional;

import br.com.ufrn.imd.securityexample.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
}
