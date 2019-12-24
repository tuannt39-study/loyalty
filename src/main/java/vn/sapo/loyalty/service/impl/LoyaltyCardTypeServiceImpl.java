package vn.sapo.loyalty.service.impl;

import org.springframework.stereotype.Service;
import vn.sapo.loyalty.data.LoyaltyCardTypeData;
import vn.sapo.loyalty.dto.LoyaltyCardTypeDTO;
import vn.sapo.loyalty.service.LoyaltyCardTypeService;

import java.util.List;

@Service
public class LoyaltyCardTypeServiceImpl implements LoyaltyCardTypeService {

  /**
   * Lấy danh sách hạng thẻ tích điểm
   */
  @Override
  public List<LoyaltyCardTypeDTO> getListLoyaltyCardType() {
    return LoyaltyCardTypeData.LOYALTY_CARD_TYPE_DATA;
  }
}
