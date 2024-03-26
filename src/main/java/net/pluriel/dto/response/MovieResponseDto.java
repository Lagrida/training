package net.pluriel.dto.response;

import java.time.LocalDateTime;
import java.util.Date;

public class MovieResponseDto {
	private Integer id;
	private String name;
	private Integer length;
	private Integer ageCertificate;
	private Boolean status;
	private Integer movieRevenueId;
	private Date releaseDate;
	private Integer directorId;
	private LocalDateTime updatedAt;
	private LocalDateTime createdAt;
}
