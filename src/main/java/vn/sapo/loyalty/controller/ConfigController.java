package vn.sapo.loyalty.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vn.sapo.loyalty.service.impl.ConfigServiceImpl;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/config")
public class ConfigController {
  private final ConfigServiceImpl configServiceImpl;

  public ConfigController(ConfigServiceImpl configServiceImpl) {
    this.configServiceImpl = configServiceImpl;
  }

  @PutMapping
  public ResponseEntity<String> updateConfig(@RequestParam BigDecimal value) {
    configServiceImpl.updateConfig(value);
    return ResponseEntity.ok().build();
  }
}
