package vn.sapo.loyalty.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import vn.sapo.loyalty.LoyaltyApplication;
import vn.sapo.loyalty.dto.LoyaltyCardTypeDTO;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = LoyaltyApplication.class)
@Transactional
public class LoyaltyCardTypeServiceTest {

  @Autowired
  private LoyaltyCardTypeService loyaltyCardTypeService;

  @Test
  @Transactional
  public void getListLoyaltyCardType() {
    List<LoyaltyCardTypeDTO> loyaltyCardTypeDTOS = new ArrayList<>();
    assertThat(loyaltyCardTypeDTOS).isInstanceOf(ArrayList.class);
    loyaltyCardTypeDTOS = loyaltyCardTypeService.getListLoyaltyCardType();
    assertThat(loyaltyCardTypeDTOS.get(0)).isInstanceOf(LoyaltyCardTypeDTO.class);
  }
}
