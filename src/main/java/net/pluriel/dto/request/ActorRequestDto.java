package net.pluriel.dto.request;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.pluriel.entities.commons.Gender;

@Data
@NoArgsConstructor
public class ActorRequestDto {

	private String firstName;
	private String lastName;
	private Date birthday;
	private Boolean status;
	private Gender gender;
	
}

