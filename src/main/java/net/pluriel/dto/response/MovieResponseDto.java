package net.pluriel.dto.response;

import java.time.LocalDateTime;
import java.util.Date;

import net.pluriel.dto.request.MovieRevenueRequestDto;
import net.pluriel.dto.request.RequestIdDto;

public class MovieResponseDto {
	private Integer id;
	private String name;
	private Integer length;
	private Integer ageCertificate;
	private Boolean status;
	private MovieRevenueRequestDto movieRevenue;
	private Date releaseDate;
	private RequestIdDto director;
	private LocalDateTime updatedAt;
	private LocalDateTime createdAt;
}
