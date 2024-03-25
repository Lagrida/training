package net.pluriel.dto.response;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.pluriel.entities.commons.Gender;

@Data
@NoArgsConstructor
public class ActorResponseDto {
	private Integer id;
	private String firstName;
	private String lastName;
	private Date birthday;
	private Boolean status;
	private Gender gender;
	private LocalDateTime createdAt = LocalDateTime.now();
	private LocalDateTime updatedAt = LocalDateTime.now();
}
