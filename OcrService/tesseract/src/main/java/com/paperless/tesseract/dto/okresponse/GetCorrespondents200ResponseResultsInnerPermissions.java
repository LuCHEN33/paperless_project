package com.paperless.tesseract.dto.okresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import javax.annotation.processing.Generated;
import java.util.Objects;

/**
 * GetCorrespondents200ResponseResultsInnerPermissions
 */

@JsonTypeName("GetCorrespondents_200_response_results_inner_permissions")
@Generated(value = "com.paperless.codegen.languages.SpringCodegen", date = "2023-10-22T12:32:07.613318Z[Etc/UTC]")
public class GetCorrespondents200ResponseResultsInnerPermissions {

  private GetCorrespondents200ResponseResultsInnerPermissionsView view;

  private GetCorrespondents200ResponseResultsInnerPermissionsView change;

  public GetCorrespondents200ResponseResultsInnerPermissions() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GetCorrespondents200ResponseResultsInnerPermissions(GetCorrespondents200ResponseResultsInnerPermissionsView view, GetCorrespondents200ResponseResultsInnerPermissionsView change) {
    this.view = view;
    this.change = change;
  }

  public GetCorrespondents200ResponseResultsInnerPermissions view(GetCorrespondents200ResponseResultsInnerPermissionsView view) {
    this.view = view;
    return this;
  }

  /**
   * Get view
   * @return view
  */
  @NotNull @Valid 
  @Schema(name = "view", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("view")
  public GetCorrespondents200ResponseResultsInnerPermissionsView getView() {
    return view;
  }

  public void setView(GetCorrespondents200ResponseResultsInnerPermissionsView view) {
    this.view = view;
  }

  public GetCorrespondents200ResponseResultsInnerPermissions change(GetCorrespondents200ResponseResultsInnerPermissionsView change) {
    this.change = change;
    return this;
  }

  /**
   * Get change
   * @return change
  */
  @NotNull
  @Valid
  @Schema(name = "change", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("change")
  public GetCorrespondents200ResponseResultsInnerPermissionsView getChange() {
    return change;
  }

  public void setChange(GetCorrespondents200ResponseResultsInnerPermissionsView change) {
    this.change = change;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetCorrespondents200ResponseResultsInnerPermissions getCorrespondents200ResponseResultsInnerPermissions = (GetCorrespondents200ResponseResultsInnerPermissions) o;
    return Objects.equals(this.view, getCorrespondents200ResponseResultsInnerPermissions.view) &&
        Objects.equals(this.change, getCorrespondents200ResponseResultsInnerPermissions.change);
  }

  @Override
  public int hashCode() {
    return Objects.hash(view, change);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetCorrespondents200ResponseResultsInnerPermissions {\n");
    sb.append("    view: ").append(toIndentedString(view)).append("\n");
    sb.append("    change: ").append(toIndentedString(change)).append("\n");
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

