package net.pluriel.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.JoinColumn;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.pluriel.entities.commons.Country;
import net.pluriel.entities.commons.Gender;

@Data
@Entity
@Table(name = "actors", 
	   uniqueConstraints={
			   @UniqueConstraint(columnNames = {"first_name", "last_name", "nationality"})
	 })
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Actor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday")
	private Date birthday;

	@Column(name = "nationality",nullable = false)
	@Enumerated(EnumType.STRING)
	@Builder.Default
	private Country nationality = Country.American;

	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
	@Builder.Default
	private Gender gender = Gender.Homme;

	@Column(name = "status", columnDefinition = "boolean default true")
	@Builder.Default
	private Boolean status = true;

	@Column(name = "created_at", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;
}
