package com.paperless.tesseract.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.openapitools.jackson.nullable.JsonNullable;

import javax.annotation.processing.Generated;
import java.util.Arrays;
import java.util.Objects;

/**
 * DocTag
 */

@Generated(value = "com.paperless.codegen.languages.SpringCodegen", date = "2023-10-22T12:32:07.613318Z[Etc/UTC]")
public class DocTagDTO {

  private Long id;

  private JsonNullable<String> slug = JsonNullable.<String>undefined();

  private JsonNullable<String> name = JsonNullable.<String>undefined();

  private JsonNullable<String> color = JsonNullable.<String>undefined();

  private JsonNullable<String> match = JsonNullable.<String>undefined();

  private Long matchingAlgorithm;

  private Boolean isInsensitive;

  private Boolean isInboxTag;

  private Long documentCount;

  public DocTagDTO id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public DocTagDTO slug(String slug) {
    this.slug = JsonNullable.of(slug);
    return this;
  }

  /**
   * Get slug
   * @return slug
  */
  
  @Schema(name = "slug", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("slug")
  public JsonNullable<String> getSlug() {
    return slug;
  }

  public void setSlug(JsonNullable<String> slug) {
    this.slug = slug;
  }

  public DocTagDTO name(String name) {
    this.name = JsonNullable.of(name);
    return this;
  }

  /**
   * Get name
   * @return name
  */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public JsonNullable<String> getName() {
    return name;
  }

  public void setName(JsonNullable<String> name) {
    this.name = name;
  }

  public DocTagDTO color(String color) {
    this.color = JsonNullable.of(color);
    return this;
  }

  /**
   * Get color
   * @return color
  */
  
  @Schema(name = "color", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("color")
  public JsonNullable<String> getColor() {
    return color;
  }

  public void setColor(JsonNullable<String> color) {
    this.color = color;
  }

  public DocTagDTO match(String match) {
    this.match = JsonNullable.of(match);
    return this;
  }

  /**
   * Get match
   * @return match
  */
  
  @Schema(name = "match", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("match")
  public JsonNullable<String> getMatch() {
    return match;
  }

  public void setMatch(JsonNullable<String> match) {
    this.match = match;
  }

  public DocTagDTO matchingAlgorithm(Long matchingAlgorithm) {
    this.matchingAlgorithm = matchingAlgorithm;
    return this;
  }

  /**
   * Get matchingAlgorithm
   * @return matchingAlgorithm
  */
  
  @Schema(name = "matching_algorithm", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("matching_algorithm")
  public Long getMatchingAlgorithm() {
    return matchingAlgorithm;
  }

  public void setMatchingAlgorithm(Long matchingAlgorithm) {
    this.matchingAlgorithm = matchingAlgorithm;
  }

  public DocTagDTO isInsensitive(Boolean isInsensitive) {
    this.isInsensitive = isInsensitive;
    return this;
  }

  /**
   * Get isInsensitive
   * @return isInsensitive
  */
  
  @Schema(name = "is_insensitive", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("is_insensitive")
  public Boolean getIsInsensitive() {
    return isInsensitive;
  }

  public void setIsInsensitive(Boolean isInsensitive) {
    this.isInsensitive = isInsensitive;
  }

  public DocTagDTO isInboxTag(Boolean isInboxTag) {
    this.isInboxTag = isInboxTag;
    return this;
  }

  /**
   * Get isInboxTag
   * @return isInboxTag
  */
  
  @Schema(name = "is_inbox_tag", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("is_inbox_tag")
  public Boolean getIsInboxTag() {
    return isInboxTag;
  }

  public void setIsInboxTag(Boolean isInboxTag) {
    this.isInboxTag = isInboxTag;
  }

  public DocTagDTO documentCount(Long documentCount) {
    this.documentCount = documentCount;
    return this;
  }

  /**
   * Get documentCount
   * @return documentCount
  */
  
  @Schema(name = "document_count", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("document_count")
  public Long getDocumentCount() {
    return documentCount;
  }

  public void setDocumentCount(Long documentCount) {
    this.documentCount = documentCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DocTagDTO docTagDTO = (DocTagDTO) o;
    return Objects.equals(this.id, docTagDTO.id) &&
        equalsNullable(this.slug, docTagDTO.slug) &&
        equalsNullable(this.name, docTagDTO.name) &&
        equalsNullable(this.color, docTagDTO.color) &&
        equalsNullable(this.match, docTagDTO.match) &&
        Objects.equals(this.matchingAlgorithm, docTagDTO.matchingAlgorithm) &&
        Objects.equals(this.isInsensitive, docTagDTO.isInsensitive) &&
        Objects.equals(this.isInboxTag, docTagDTO.isInboxTag) &&
        Objects.equals(this.documentCount, docTagDTO.documentCount);
  }

  private static <T> boolean equalsNullable(JsonNullable<T> a, JsonNullable<T> b) {
    return a == b || (a != null && b != null && a.isPresent() && b.isPresent() && Objects.deepEquals(a.get(), b.get()));
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, hashCodeNullable(slug), hashCodeNullable(name), hashCodeNullable(color), hashCodeNullable(match), matchingAlgorithm, isInsensitive, isInboxTag, documentCount);
  }

  private static <T> int hashCodeNullable(JsonNullable<T> a) {
    if (a == null) {
      return 1;
    }
    return a.isPresent() ? Arrays.deepHashCode(new Object[]{a.get()}) : 31;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DocTag {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    slug: ").append(toIndentedString(slug)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    color: ").append(toIndentedString(color)).append("\n");
    sb.append("    match: ").append(toIndentedString(match)).append("\n");
    sb.append("    matchingAlgorithm: ").append(toIndentedString(matchingAlgorithm)).append("\n");
    sb.append("    isInsensitive: ").append(toIndentedString(isInsensitive)).append("\n");
    sb.append("    isInboxTag: ").append(toIndentedString(isInboxTag)).append("\n");
    sb.append("    documentCount: ").append(toIndentedString(documentCount)).append("\n");
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

