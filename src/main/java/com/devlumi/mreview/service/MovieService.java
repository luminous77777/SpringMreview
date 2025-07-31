package com.devlumi.mreview.service;

import com.devlumi.mreview.domain.dto.MovieDTO;
import com.devlumi.mreview.domain.dto.MovieImageDTO;
import com.devlumi.mreview.domain.dto.PageRequestDTO;
import com.devlumi.mreview.domain.dto.PageResponseDTO;
import com.devlumi.mreview.domain.entity.Movie;
import com.devlumi.mreview.domain.entity.MovieImage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public sealed interface MovieService permits MovieServiceImpl{
  Long register(MovieDTO dto);
  PageResponseDTO<MovieDTO, Object[]> getList(PageRequestDTO dto);


//무비 객체와 이미지 처리를 같이해야함
  default Map<String, Object> toEntity(MovieDTO dto){
    Map<String, Object> map = new HashMap<>();
    Movie movie = Movie.builder().title(dto.getTitle()).mno(dto.getMno()).build();

    map.put("movie", movie);
    map.put("images", dto.getList().stream().map(m-> MovieImage.builder()
            .movie(movie)
            .uuid(m.getUuid())
            .path(m.getPath())
            .imgName(m.getOrigin())
            .build()
    ).toList());
    return map;
  }

  default MovieDTO toDTO(Movie movie, List<MovieImage> images, double avg, long reviewCnt){
    return MovieDTO.builder()
            .mno(movie.getMno())
            .title(movie.getTitle())
            .regDate(movie.getRegDate())
            .modDate(movie.getModDate())
            .list(images.stream().map(i -> i == null ? null : MovieImageDTO.builder()
                    .origin(i.getImgName())
                    .uuid(i.getUuid())
                    .path(i.getPath())
                    .build()).toList())
            .avg(avg)
            .reviewCnt(reviewCnt)
            .build();
  }
}
