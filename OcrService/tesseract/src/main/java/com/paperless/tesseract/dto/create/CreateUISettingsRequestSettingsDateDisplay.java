package com.paperless.tesseract.dto.create;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import javax.annotation.processing.Generated;
import java.util.Objects;

/**
 * CreateUISettingsRequestSettingsDateDisplay
 */

@JsonTypeName("CreateUISettings_request_settings_date_display")
@Generated(value = "com.paperless.codegen.languages.SpringCodegen", date = "2023-10-22T12:32:07.613318Z[Etc/UTC]")
public class CreateUISettingsRequestSettingsDateDisplay {

  private String dateLocale;

  private String dateFormat;

  public CreateUISettingsRequestSettingsDateDisplay() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateUISettingsRequestSettingsDateDisplay(String dateLocale, String dateFormat) {
    this.dateLocale = dateLocale;
    this.dateFormat = dateFormat;
  }

  public CreateUISettingsRequestSettingsDateDisplay dateLocale(String dateLocale) {
    this.dateLocale = dateLocale;
    return this;
  }

  /**
   * Get dateLocale
   * @return dateLocale
  */
  @NotNull 
  @Schema(name = "date_locale", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("date_locale")
  public String getDateLocale() {
    return dateLocale;
  }

  public void setDateLocale(String dateLocale) {
    this.dateLocale = dateLocale;
  }

  public CreateUISettingsRequestSettingsDateDisplay dateFormat(String dateFormat) {
    this.dateFormat = dateFormat;
    return this;
  }

  /**
   * Get dateFormat
   * @return dateFormat
  */
  @NotNull
  @Schema(name = "date_format", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("date_format")
  public String getDateFormat() {
    return dateFormat;
  }

  public void setDateFormat(String dateFormat) {
    this.dateFormat = dateFormat;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateUISettingsRequestSettingsDateDisplay createUISettingsRequestSettingsDateDisplay = (CreateUISettingsRequestSettingsDateDisplay) o;
    return Objects.equals(this.dateLocale, createUISettingsRequestSettingsDateDisplay.dateLocale) &&
        Objects.equals(this.dateFormat, createUISettingsRequestSettingsDateDisplay.dateFormat);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dateLocale, dateFormat);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateUISettingsRequestSettingsDateDisplay {\n");
    sb.append("    dateLocale: ").append(toIndentedString(dateLocale)).append("\n");
    sb.append("    dateFormat: ").append(toIndentedString(dateFormat)).append("\n");
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

