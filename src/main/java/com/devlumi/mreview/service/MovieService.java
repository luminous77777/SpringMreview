package com.devlumi.mreview.service;

import com.devlumi.mreview.domain.dto.MovieDTO;
import com.devlumi.mreview.domain.entity.Movie;
import com.devlumi.mreview.domain.entity.MovieImage;

import java.util.HashMap;
import java.util.Map;

public sealed interface MovieService permits MovieServiceImpl{
  Long register(MovieDTO dto);
//무비 객체와 이미지 처리를 같이해야함
  default Map<String, Object> toEntity(MovieDTO dto){
    Map<String, Object> map = new HashMap<>();
    map.put("movie", Movie.builder().title(dto.getTitle()).mno(dto.getMno()).build());
    map.put("images", dto.getList().stream().map(m-> MovieImage.builder()
            .movie(Movie.builder().mno(dto.getMno()).build())
            .uuid(m.getUuid())
            .path(m.getPath())
            .imgName(m.getOrigin())
            .build()
    ).toList());
    return map;
  }
}
