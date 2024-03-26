package net.pluriel.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "movies")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "nbr_minute")
	private Integer length;

	@Temporal(TemporalType.DATE)
	@Column(name = "release_date")
	private Date releaseDate;

	@Column(name = "age_certificate")
	private Integer ageCertificate;

	@Column(name = "status", columnDefinition = "boolean default true")
	@Builder.Default
	private Boolean status = true;

	@Column(name = "created_at", updatable = false)
	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "updated_at")
	private LocalDateTime updatedAt;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "movie_revenue_id")
	private MovieRevenue movieRevenue;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "director_id", nullable = false)
	private Director director;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		name = "T_Movie_Actors_Associations",
		joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
		inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"))
	private List<Actor> actors;

}
