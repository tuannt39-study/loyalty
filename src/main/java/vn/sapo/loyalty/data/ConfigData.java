package vn.sapo.loyalty.data;

import vn.sapo.loyalty.dto.ConfigDTO;

import java.math.BigDecimal;

public class ConfigData {
  public static ConfigDTO CONFIG_DEFAULT = new ConfigDTO(1L, new BigDecimal(100000));
}
