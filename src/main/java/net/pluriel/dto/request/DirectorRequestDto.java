package net.pluriel.dto.request;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import net.pluriel.entities.commons.Country;

@Data
@NoArgsConstructor
public class DirectorRequestDto {
	private String firstName;
	private String lastName;
	private Date birthday;
	private Country nationality;
	private Boolean status;
}
