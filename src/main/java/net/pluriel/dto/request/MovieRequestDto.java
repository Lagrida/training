package net.pluriel.dto.request;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.pluriel.entities.Actor;

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
	private Integer movieRevenueId;
	private Integer directorId;
	private List<Actor> actors ;
}
