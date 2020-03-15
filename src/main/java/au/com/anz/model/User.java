package au.com.anz.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonPropertyOrder({
    "userId",
    "firstName",
    "lastName",
    "addressLine1",
    "addressLine2",
    "city",
    "postcode",
    "state",
    "country",
    "memberSince",
    "userAccounts"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable {

  @JsonCreator
  public User(
      @JsonProperty("firstName") String firstName,
      @JsonProperty("lastName") String lastName,
      @JsonProperty("addressLine1") String addressLine1,
      @JsonProperty("addressLine2") String addressLine2,
      @JsonProperty("city") String city,
      @JsonProperty("postcode") String postcode,
      @JsonProperty("state") String state,
      @JsonProperty("country") String country
  ) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.addressLine1 = addressLine1;
    this.addressLine2 = addressLine2;
    this.city = city;
    this.postcode = postcode;
    this.state = state;
    this.country = country;
  }

  @JsonProperty(access = Access.READ_ONLY)
  private Long userId;

  private String firstName;

  private String lastName;

  private String addressLine1;

  private String addressLine2;

  private String city;

  private String postcode;

  private String state;

  private String country;

  @JsonProperty(access = Access.READ_ONLY)
  private Set<Account> userAccounts;
}
