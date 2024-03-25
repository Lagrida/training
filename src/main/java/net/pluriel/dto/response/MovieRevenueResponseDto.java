package net.pluriel.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MovieRevenueResponseDto {
	private BigDecimal domesticTakings;
	private BigDecimal internationalTakings;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
