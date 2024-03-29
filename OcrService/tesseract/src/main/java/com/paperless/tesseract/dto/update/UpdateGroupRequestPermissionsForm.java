package com.paperless.tesseract.dto.update;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import javax.annotation.processing.Generated;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * UpdateGroupRequestPermissionsForm
 */

@JsonTypeName("UpdateGroup_request_permissions_form")
@Generated(value = "com.paperless.codegen.languages.SpringCodegen", date = "2023-10-22T12:32:07.613318Z[Etc/UTC]")
public class UpdateGroupRequestPermissionsForm {

  @Valid
  private List<String> setPermissions = new ArrayList<>();

  public UpdateGroupRequestPermissionsForm() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public UpdateGroupRequestPermissionsForm(List<String> setPermissions) {
    this.setPermissions = setPermissions;
  }

  public UpdateGroupRequestPermissionsForm setPermissions(List<String> setPermissions) {
    this.setPermissions = setPermissions;
    return this;
  }

  public UpdateGroupRequestPermissionsForm addSetPermissionsItem(String setPermissionsItem) {
    if (this.setPermissions == null) {
      this.setPermissions = new ArrayList<>();
    }
    this.setPermissions.add(setPermissionsItem);
    return this;
  }

  /**
   * Get setPermissions
   * @return setPermissions
  */
  @NotNull
  @Schema(name = "set_permissions", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("set_permissions")
  public List<String> getSetPermissions() {
    return setPermissions;
  }

  public void setSetPermissions(List<String> setPermissions) {
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
    UpdateGroupRequestPermissionsForm updateGroupRequestPermissionsForm = (UpdateGroupRequestPermissionsForm) o;
    return Objects.equals(this.setPermissions, updateGroupRequestPermissionsForm.setPermissions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(setPermissions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateGroupRequestPermissionsForm {\n");
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

