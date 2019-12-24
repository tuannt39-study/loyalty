package vn.sapo.loyalty.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import vn.sapo.loyalty.LoyaltyApplication;
import vn.sapo.loyalty.dto.LoyaltyCardDTO;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = LoyaltyApplication.class)
@Transactional
public class LoyaltyCardServiceTest {

  private static final Long ID1 = -1L;
  private static final Long ID2 = 1L;
  private static final BigDecimal POINT_ADJUST_DEF = new BigDecimal("23.45");
  private static final BigDecimal SPENT_ADJUST_DEF = new BigDecimal(2345000);
  private static LoyaltyCardDTO loyaltyCard = new LoyaltyCardDTO(1L,
    "LT0001",
    "0987654321",
    1L,
    POINT_ADJUST_DEF,
    SPENT_ADJUST_DEF,
    Instant.parse("2019-12-18T00:00:00.00Z"),
    Instant.parse("2019-12-18T00:00:00.00Z"),
    Instant.parse("2019-12-18T00:00:00.00Z"),
    Instant.parse("2019-12-18T00:00:00.00Z")
  );
  private static final BigDecimal POINT_ADJUST = new BigDecimal("30.4");
  private static final BigDecimal SPENT_ADJUST = new BigDecimal(3040000);
  private static final BigDecimal POINT_ADJUST_ADD = new BigDecimal("53.85");
  private static final BigDecimal SPENT_ADJUST_ADD = new BigDecimal(5385000);
  private static final BigDecimal SPENT_ADJUST_3 = new BigDecimal(21000000);
  private static final Long TYPE_1 = 1L;
  private static final Long TYPE_4 = 4L;

  @Autowired
  private LoyaltyCardService loyaltyCardService;

  @Test
  @Transactional
  public void getListLoyaltyCard() {
    List<LoyaltyCardDTO> listLoyaltyCard = new ArrayList<>();
    assertThat(listLoyaltyCard).isInstanceOf(ArrayList.class);
    listLoyaltyCard = loyaltyCardService.getListLoyaltyCard();
    assertThat(listLoyaltyCard.get(0)).isInstanceOf(LoyaltyCardDTO.class);
  }

  @Test
  @Transactional
  public void getLoyaltyCardById() {
    Long loyaltyCardId = ID1;
    LoyaltyCardDTO loyaltyCardDTO = loyaltyCardService.getLoyaltyCardById(loyaltyCardId);
    assertThat(loyaltyCardDTO).isNotNull();
    assertThat(loyaltyCardDTO.getId()).isNull();
    loyaltyCardId = ID2;
    loyaltyCardDTO = loyaltyCardService.getLoyaltyCardById(loyaltyCardId);
    assertThat(loyaltyCardDTO).isNotNull();
    assertEquals(loyaltyCardDTO.getId(), ID2);
  }

  @Test
  @Transactional
  public void setPoint() {
    loyaltyCard.setPoint(POINT_ADJUST_DEF);
    loyaltyCard.setTotalSpent(SPENT_ADJUST_DEF);
    loyaltyCardService.setPoint(loyaltyCard, POINT_ADJUST, SPENT_ADJUST);
    assertEquals(loyaltyCard.getPoint(), POINT_ADJUST_ADD);
    assertEquals(loyaltyCard.getTotalSpent(), SPENT_ADJUST_ADD);
  }

  @Test
  @Transactional
  public void setLoyaltyCard() {
    loyaltyCard.setPoint(POINT_ADJUST_DEF);
    loyaltyCard.setTotalSpent(SPENT_ADJUST_DEF);
    loyaltyCardService.setLoyaltyCard(loyaltyCard);
    assertEquals(loyaltyCard.getLoyaltyCardTypeId(), TYPE_1);
    loyaltyCard.setTotalSpent(SPENT_ADJUST_3);
    loyaltyCardService.setLoyaltyCard(loyaltyCard);
    assertEquals(loyaltyCard.getLoyaltyCardTypeId(), TYPE_4);
  }
}
