package com.paperless.tesseract.dto.okresponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import javax.annotation.processing.Generated;
import java.util.Objects;

/**
 * GetUISettings200ResponseSettingsUpdateChecking
 */

@JsonTypeName("GetUISettings_200_response_settings_update_checking")
@Generated(value = "com.paperless.codegen.languages.SpringCodegen", date = "2023-10-22T12:32:07.613318Z[Etc/UTC]")
public class GetUISettings200ResponseSettingsUpdateChecking {

  private String backendSetting;

  public GetUISettings200ResponseSettingsUpdateChecking() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GetUISettings200ResponseSettingsUpdateChecking(String backendSetting) {
    this.backendSetting = backendSetting;
  }

  public GetUISettings200ResponseSettingsUpdateChecking backendSetting(String backendSetting) {
    this.backendSetting = backendSetting;
    return this;
  }

  /**
   * Get backendSetting
   * @return backendSetting
  */
  @NotNull
  @Schema(name = "backend_setting", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("backend_setting")
  public String getBackendSetting() {
    return backendSetting;
  }

  public void setBackendSetting(String backendSetting) {
    this.backendSetting = backendSetting;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetUISettings200ResponseSettingsUpdateChecking getUISettings200ResponseSettingsUpdateChecking = (GetUISettings200ResponseSettingsUpdateChecking) o;
    return Objects.equals(this.backendSetting, getUISettings200ResponseSettingsUpdateChecking.backendSetting);
  }

  @Override
  public int hashCode() {
    return Objects.hash(backendSetting);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetUISettings200ResponseSettingsUpdateChecking {\n");
    sb.append("    backendSetting: ").append(toIndentedString(backendSetting)).append("\n");
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

