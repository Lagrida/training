package net.pluriel.dto.response;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.pluriel.entities.commons.Country;

@Data
@NoArgsConstructor
public class DirectorResponseDto {
	private Integer id;
	private String firstName;
	private String lastName;
	private Date birthday;
	private Country nationality;
	private Boolean status;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
}
