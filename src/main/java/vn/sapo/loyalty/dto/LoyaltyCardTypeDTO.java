package vn.sapo.loyalty.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoyaltyCardTypeDTO {
  private Long id;
  private String name;
  private BigDecimal spentThreshold;
  private int duration;
  private int discountPercent;
  private Instant createdOn;
  private Instant modifiedOn;
}
