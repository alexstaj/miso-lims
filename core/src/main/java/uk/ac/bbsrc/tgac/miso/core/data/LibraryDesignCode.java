package uk.ac.bbsrc.tgac.miso.core.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LibraryDesignCode")
public class LibraryDesignCode {

  @Id
  private Long libraryDesignCodeId;

  @Column(unique = true, nullable = false)
  private String code;

  @Column(nullable = false)
  private String description;

  public Long getId() {
    return libraryDesignCodeId;
  };

  public void setId(Long id) {
    this.libraryDesignCodeId = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
