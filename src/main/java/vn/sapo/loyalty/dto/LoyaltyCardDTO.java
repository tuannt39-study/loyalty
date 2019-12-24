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
public class LoyaltyCardDTO {
  private Long id;
  private String code;
  private String phone;
  private Long loyaltyCardTypeId;
  private BigDecimal point;
  private BigDecimal totalSpent;
  private Instant startDate;
  private Instant endDate;
  private Instant createdOn;
  private Instant modifiedOn;
}
