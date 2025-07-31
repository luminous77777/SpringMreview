package com.devlumi.mreview.service;

import com.devlumi.mreview.domain.dto.MovieImageDTO;
import com.devlumi.mreview.domain.entity.Movie;
import com.devlumi.mreview.domain.entity.MovieImage;

public interface MovieImageService {
  static MovieImage toEntity(MovieImageDTO dto) {
    return MovieImage.builder()
            .movie(Movie.builder().mno(dto.getMno()).build())
            .uuid(dto.getUuid())
            .path(dto.getPath())
            .imgName(dto.getOrigin())
            .build();
  }
}
