package vn.sapo.loyalty.service.impl;

import org.springframework.stereotype.Service;
import vn.sapo.loyalty.data.LoyaltyCardData;
import vn.sapo.loyalty.dto.LoyaltyCardDTO;
import vn.sapo.loyalty.dto.LoyaltyCardTypeDTO;
import vn.sapo.loyalty.service.LoyaltyCardService;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class LoyaltyCardServiceImpl implements LoyaltyCardService {

  private LoyaltyCardTypeServiceImpl loyaltyCardTypeServiceImpl;

  public LoyaltyCardServiceImpl(LoyaltyCardTypeServiceImpl loyaltyCardTypeServiceImpl) {
    this.loyaltyCardTypeServiceImpl = loyaltyCardTypeServiceImpl;
  }

  /**
   * Lấy danh sách thẻ tích điểm
   */
  @Override
  public List<LoyaltyCardDTO> getListLoyaltyCard() {
    return LoyaltyCardData.LOYALTY_CARD_DATA;
  }

  /**
   * Tìm mã tích điểm theo id
   */
  @Override
  public LoyaltyCardDTO getLoyaltyCardById(Long loyaltyCardId) {
    if (loyaltyCardId > 0) {
      // Tìm đối tượng theo id từ database hoặc danh sách nào đó
      return getListLoyaltyCard().stream()
        .filter(loyaltyCardDTO -> loyaltyCardDTO.getId().equals(loyaltyCardId))
        .findFirst()
        .orElse(new LoyaltyCardDTO());
    }
    return new LoyaltyCardDTO();
  }

  /**
   * Cộng điểm vào thẻ tích điểm của khách hàng khi có giao dịch thành công
   */
  @Override
  public void setPoint(LoyaltyCardDTO loyaltyCard, BigDecimal pointAdjust, BigDecimal spentAdjust) {
    loyaltyCard.setPoint(loyaltyCard.getPoint().add(pointAdjust));
    loyaltyCard.setTotalSpent(loyaltyCard.getTotalSpent().add(spentAdjust));
  }

  /**
   * Gán lại hạng, giá trị thẻ tích điểm của khách hàng dựa vào tổng doanh thu
   * Danh sách hạng thẻ sắp xếp theo thứ tự giảm dần
   */
  @Override
  public void setLoyaltyCard(LoyaltyCardDTO loyaltyCard) {
    List<LoyaltyCardTypeDTO> loyaltyCardTypeDTOS = loyaltyCardTypeServiceImpl.getListLoyaltyCardType();
    loyaltyCardTypeDTOS.sort((o1, o2) -> o2.getSpentThreshold().compareTo(o1.getSpentThreshold()));
    loyaltyCardTypeDTOS.stream().filter(loyaltyCardTypeDTO -> loyaltyCard.getTotalSpent().compareTo(loyaltyCardTypeDTO.getSpentThreshold()) > 0)
      .findFirst()
      .ifPresent(loyaltyCardTypeDTO -> {
        loyaltyCard.setLoyaltyCardTypeId(loyaltyCardTypeDTO.getId());
        loyaltyCard.setEndDate(loyaltyCard.getStartDate().plus(loyaltyCardTypeDTO.getDuration(), ChronoUnit.DAYS));
      });
  }
}
