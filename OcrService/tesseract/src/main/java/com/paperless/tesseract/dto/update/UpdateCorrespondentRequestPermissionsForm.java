package com.paperless.tesseract.dto.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.paperless.tesseract.dto.okresponse.GetCorrespondents200ResponseResultsInnerPermissions;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import javax.annotation.processing.Generated;
import java.util.Objects;

/**
 * UpdateCorrespondentRequestPermissionsForm
 */

@JsonTypeName("UpdateCorrespondent_request_permissions_form")
@Generated(value = "com.paperless.codegen.languages.SpringCodegen", date = "2023-10-22T12:32:07.613318Z[Etc/UTC]")
public class UpdateCorrespondentRequestPermissionsForm {

  private Integer owner;

  private GetCorrespondents200ResponseResultsInnerPermissions setPermissions;

  public UpdateCorrespondentRequestPermissionsForm() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UpdateCorrespondentRequestPermissionsForm(Integer owner, GetCorrespondents200ResponseResultsInnerPermissions setPermissions) {
    this.owner = owner;
    this.setPermissions = setPermissions;
  }

  public UpdateCorrespondentRequestPermissionsForm owner(Integer owner) {
    this.owner = owner;
    return this;
  }

  /**
   * Get owner
   * @return owner
  */
  @NotNull 
  @Schema(name = "owner", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("owner")
  public Integer getOwner() {
    return owner;
  }

  public void setOwner(Integer owner) {
    this.owner = owner;
  }

  public UpdateCorrespondentRequestPermissionsForm setPermissions(GetCorrespondents200ResponseResultsInnerPermissions setPermissions) {
    this.setPermissions = setPermissions;
    return this;
  }

  /**
   * Get setPermissions
   * @return setPermissions
  */
  @NotNull
  @Valid
  @Schema(name = "set_permissions", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("set_permissions")
  public GetCorrespondents200ResponseResultsInnerPermissions getSetPermissions() {
    return setPermissions;
  }

  public void setSetPermissions(GetCorrespondents200ResponseResultsInnerPermissions setPermissions) {
    this.setPermissions = setPermissions;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateCorrespondentRequestPermissionsForm updateCorrespondentRequestPermissionsForm = (UpdateCorrespondentRequestPermissionsForm) o;
    return Objects.equals(this.owner, updateCorrespondentRequestPermissionsForm.owner) &&
        Objects.equals(this.setPermissions, updateCorrespondentRequestPermissionsForm.setPermissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(owner, setPermissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateCorrespondentRequestPermissionsForm {\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    setPermissions: ").append(toIndentedString(setPermissions)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

