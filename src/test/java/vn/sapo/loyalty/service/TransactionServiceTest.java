package vn.sapo.loyalty.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import vn.sapo.loyalty.LoyaltyApplication;
import vn.sapo.loyalty.data.ConfigData;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = LoyaltyApplication.class)
@Transactional
public class TransactionServiceTest {

  @Autowired
  private TransactionService transactionService;

  private static final BigDecimal CONFIG_ZERO = BigDecimal.ZERO;
  private static final BigDecimal CONFIG_DEFAULT = new BigDecimal(9999999);
  private static final BigDecimal CONFIG_NEGATIVE = new BigDecimal(-9999999);

  @Test
  @Transactional
  public void convertPointAdjust() {
    ConfigData.CONFIG_DEFAULT.setValue(CONFIG_NEGATIVE);
    BigDecimal pointAdjust = transactionService.convertPointAdjust(CONFIG_ZERO);
    assertThat(pointAdjust).isZero();
    ConfigData.CONFIG_DEFAULT.setValue(CONFIG_DEFAULT);
    pointAdjust = transactionService.convertPointAdjust(CONFIG_ZERO);
    assertThat(pointAdjust).isZero();
    pointAdjust = transactionService.convertPointAdjust(CONFIG_DEFAULT);
    assertThat(pointAdjust).isPositive();
    pointAdjust = transactionService.convertPointAdjust(CONFIG_NEGATIVE);
    assertThat(pointAdjust).isNegative();
  }

}
