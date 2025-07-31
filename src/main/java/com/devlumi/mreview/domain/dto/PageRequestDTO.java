package com.devlumi.mreview.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.util.UriComponentsBuilder;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageRequestDTO {
  @Builder.Default
  private int page = 1;
  @Builder.Default
  private int size = 10;

  private String type;
  private String keyword;

  public Pageable getPageable(Sort sort) {
    return PageRequest.of(page - 1, size, sort);
  }

  public String getQs(){
    UriComponentsBuilder builder = UriComponentsBuilder.fromPath("");
    builder.queryParam("size", size);
    builder.queryParam("type", type);
    builder.queryParam("keyword", keyword);
    return builder.build().toUriString();
  }

  public String getQs2(){
    UriComponentsBuilder builder = UriComponentsBuilder.fromPath("");
    builder.queryParam("page", page);
    builder.queryParam("size", size);
    builder.queryParam("type", type);
    builder.queryParam("keyword", keyword);
    return builder.build().toUriString();
  }
}
