package vn.sapo.loyalty.service;

import vn.sapo.loyalty.dto.LoyaltyCardDTO;

import java.math.BigDecimal;
import java.util.List;

public interface LoyaltyCardService {
  List<LoyaltyCardDTO> getListLoyaltyCard();
  LoyaltyCardDTO getLoyaltyCardById(Long loyaltyCardId);
  void setPoint(LoyaltyCardDTO loyaltyCard, BigDecimal pointAdjust, BigDecimal spentAdjust);
  void setLoyaltyCard(LoyaltyCardDTO loyaltyCard);
}
