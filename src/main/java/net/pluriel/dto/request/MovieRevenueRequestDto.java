package net.pluriel.dto.request;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MovieRevenueRequestDto {
	private Integer id;
	private BigDecimal domesticTakings;
	private BigDecimal internationalTakings;
}
