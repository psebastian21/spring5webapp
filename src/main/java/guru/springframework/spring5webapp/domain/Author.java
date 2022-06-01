package guru.springframework.spring5webapp.domain;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@EqualsAndHashCode.Exclude
	private String firstName;
	@EqualsAndHashCode.Exclude
	private String lastName;
	@ManyToMany(mappedBy = "authors")
	@EqualsAndHashCode.Exclude
	private Set<Book> books;

}
