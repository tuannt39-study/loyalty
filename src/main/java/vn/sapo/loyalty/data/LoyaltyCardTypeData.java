package vn.sapo.loyalty.data;

import vn.sapo.loyalty.dto.LoyaltyCardTypeDTO;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class LoyaltyCardTypeData {
  public static List<LoyaltyCardTypeDTO> LOYALTY_CARD_TYPE_DATA = Arrays.asList(
    new LoyaltyCardTypeDTO(1L,
      "Thẻ chuẩn",
      BigDecimal.ZERO,
      365,
      1,
      Instant.parse("2019-12-18T00:00:00.00Z"),
      Instant.parse("2019-12-18T00:00:00.00Z")
    ),
    new LoyaltyCardTypeDTO(2L,
      "Thẻ bạc",
      new BigDecimal(5000000),
      365,
      2,
      Instant.parse("2019-12-18T00:00:00.00Z"),
      Instant.parse("2019-12-18T00:00:00.00Z")
    ),
    new LoyaltyCardTypeDTO(3L,
      "Thẻ vàng",
      new BigDecimal(10000000),
      365,
      5,
      Instant.parse("2019-12-18T00:00:00.00Z"),
      Instant.parse("2019-12-18T00:00:00.00Z")
    ),
    new LoyaltyCardTypeDTO(4L,
      "Thẻ bạch kim",
      new BigDecimal(20000000),
      365,
      7,
      Instant.parse("2019-12-18T00:00:00.00Z"),
      Instant.parse("2019-12-18T00:00:00.00Z")
    ),
    new LoyaltyCardTypeDTO(5L,
      "Thẻ kim cương",
      new BigDecimal(500000000),
      365,
      10,
      Instant.parse("2019-12-18T00:00:00.00Z"),
      Instant.parse("2019-12-18T00:00:00.00Z")
    )
  );
}
