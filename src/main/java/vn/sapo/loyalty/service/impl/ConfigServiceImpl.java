package vn.sapo.loyalty.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import vn.sapo.loyalty.repository.ConfigRepository;
import vn.sapo.loyalty.service.ConfigService;

import java.math.BigDecimal;

@Service
public class ConfigServiceImpl implements ConfigService {
  @Value("${loyalty.id}")
  private Long id;

  private final ConfigRepository configRepository;

  public ConfigServiceImpl(ConfigRepository configRepository) {
    this.configRepository = configRepository;
  }

  @Override
  public void updateConfig(BigDecimal value) {
    configRepository.findById(id).ifPresent(config -> {
      config.setValue(value);
      configRepository.save(config);
    });
  }
}
