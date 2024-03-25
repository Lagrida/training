package net.pluriel.dto.request;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MovieRevenueRequestDto {

	 private BigDecimal domesticTakings=BigDecimal.ZERO;
	 private BigDecimal internationalTakings=BigDecimal.ZERO;
}
