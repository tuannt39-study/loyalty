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
public class TransactionDTO {
  private Long id;
  private Long loyaltyCardId;
  private BigDecimal pointAdjust;
  private BigDecimal spentAdjust;
  private Instant createdOn;
}
