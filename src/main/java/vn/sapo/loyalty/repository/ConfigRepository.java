package vn.sapo.loyalty.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.sapo.loyalty.domain.Config;

@Repository
public interface ConfigRepository extends JpaRepository<Config, Long> {
}
