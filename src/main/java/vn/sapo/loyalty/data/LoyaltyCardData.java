package vn.sapo.loyalty.data;

import vn.sapo.loyalty.dto.LoyaltyCardDTO;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class LoyaltyCardData {
  public static List<LoyaltyCardDTO> LOYALTY_CARD_DATA = Arrays.asList(
    new LoyaltyCardDTO(1L,
      "LT0001",
      "0987654321",
      1L,
      new BigDecimal("23.45"),
      new BigDecimal(2345000),
      Instant.parse("2019-12-18T00:00:00.00Z"),
      Instant.parse("2019-12-18T00:00:00.00Z"),
      Instant.parse("2019-12-18T00:00:00.00Z"),
      Instant.parse("2019-12-18T00:00:00.00Z")
    ),
    new LoyaltyCardDTO(2L,
      "LT0002",
      "0987654322",
      2L,
      new BigDecimal(0),
      new BigDecimal(7987000),
      Instant.parse("2019-10-17T00:00:00.00Z"),
      Instant.parse("2019-10-17T00:00:00.00Z"),
      Instant.parse("2019-05-17T00:00:00.00Z"),
      Instant.parse("2019-12-17T00:00:00.00Z")
    ),
    new LoyaltyCardDTO(3L,
      "LT0003",
      "0987654323",
      3L,
      new BigDecimal(-21),
      new BigDecimal(15400000),
      Instant.parse("2019-11-12T00:00:00.00Z"),
      Instant.parse("2019-11-12T00:00:00.00Z"),
      Instant.parse("2019-04-15T00:00:00.00Z"),
      Instant.parse("2019-11-27T00:00:00.00Z")
    ),
    new LoyaltyCardDTO(4L,
      "HT0001",
      "0987654324",
      4L,
      new BigDecimal(30),
      new BigDecimal(30000000),
      Instant.parse("2019-05-23T00:00:00.00Z"),
      Instant.parse("2019-05-23T00:00:00.00Z"),
      Instant.parse("2019-03-12T00:00:00.00Z"),
      Instant.parse("2019-08-23T00:00:00.00Z")
    ),
    new LoyaltyCardDTO(5L,
      "HO0002",
      "0987654325",
      5L,
      new BigDecimal(39),
      new BigDecimal(54000000),
      Instant.parse("2019-07-27T00:00:00.00Z"),
      Instant.parse("2019-07-27T00:00:00.00Z"),
      Instant.parse("2019-02-01T00:00:00.00Z"),
      Instant.parse("2019-11-27T00:00:00.00Z")
    )
  );
}
