package au.com.anz.dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "user")
@SequenceGenerator(name="userIdGenerator", initialValue=1900100030, allocationSize=100)
public class UserDAO implements Serializable {

  @Id
  @GeneratedValue(generator = "userIdGenerator")
  @Column(name = "userId", updatable = false, nullable = false)
  @NotNull
  private Long userId;

  @NotNull
  @Column(name = "givenName", nullable = false)
  private String givenName;

  @NotNull
  @Column(name = "surname", nullable = false)
  private String surname;

  @Column(name = "addressLine1")
  private String addressLine1;

  @Column(name = "addressLine2")
  private String addressLine2;

  @Column(name = "city")
  private String city;

  @Column(name = "postcode")
  private String postcode;

  @Column(name = "state")
  private String state;

  @Column(name = "country")
  private String country;
}