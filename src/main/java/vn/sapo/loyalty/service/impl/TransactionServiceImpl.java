package vn.sapo.loyalty.service.impl;

import org.springframework.stereotype.Service;
import vn.sapo.loyalty.data.ConfigData;
import vn.sapo.loyalty.service.TransactionService;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class TransactionServiceImpl implements TransactionService {

  /**
   * Chuyển đổi 'Số doanh thu điều chỉnh' sang 'Số điểm điều chỉnh'
   */
  @Override
  public BigDecimal convertPointAdjust(BigDecimal spentAdjust) {
    // Cấu hình, Thiết lập tỷ lệ quy đổi từ doanh thu ra điểm được lấy từ database hoặc dữ liệu nào đó
    if (
      ConfigData.CONFIG_DEFAULT.getValue() != null
        && ConfigData.CONFIG_DEFAULT.getValue().compareTo(BigDecimal.ZERO) > 0
    ) {
      return spentAdjust.divide(ConfigData.CONFIG_DEFAULT.getValue(), 2, RoundingMode.CEILING);
    }
    return BigDecimal.ZERO;
  }
}
