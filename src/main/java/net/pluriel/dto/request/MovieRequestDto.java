package net.pluriel.dto.request;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class MovieRequestDto {
	private String name;
	private Integer length;
	private Integer ageCertificate;
	private Date releaseDate;
	private Boolean status;
	private MovieRevenueRequestDto movieRevenue;
	private RequestIdDto director;
	private List<RequestIdDto> actors;
}
