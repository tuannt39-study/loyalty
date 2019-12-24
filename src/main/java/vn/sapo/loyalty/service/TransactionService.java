package vn.sapo.loyalty.service;

import java.math.BigDecimal;

public interface TransactionService {
  BigDecimal convertPointAdjust(BigDecimal spentAdjust);
}
