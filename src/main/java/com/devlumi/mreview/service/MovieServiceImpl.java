package com.devlumi.mreview.service;

import com.devlumi.mreview.domain.dto.MovieDTO;
import com.devlumi.mreview.domain.dto.PageRequestDTO;
import com.devlumi.mreview.domain.dto.PageResponseDTO;
import com.devlumi.mreview.domain.entity.Movie;
import com.devlumi.mreview.domain.entity.MovieImage;
import com.devlumi.mreview.repository.MovieImageRepository;
import com.devlumi.mreview.repository.MovieRepository;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
@Data
public non-sealed class MovieServiceImpl implements MovieService{

private final MovieRepository movieRepository;
private final MovieImageRepository movieImageRepository;
  @Override
  @Transactional
  public Long register(MovieDTO dto) {
    Map<String,Object> map =  toEntity(dto);
    Movie movie = (Movie) map.get("movie");
    movieRepository.save(movie);
    List<MovieImage> list =((List<MovieImage>) map.get("images"));
//    list.forEach(image->image.setMovie(movie));
    list.forEach(movieImageRepository::save);


//    ((List<MovieImage>) map.get("images")).forEach(movieImageRepository::save);

    return movie.getMno();
  }

  @Override
  public PageResponseDTO<MovieDTO, Object[]> getList(PageRequestDTO dto) {
    return new PageResponseDTO<>(movieRepository.getListPage(dto.getPageable(Sort.by(Sort.Direction.DESC,"mno"))),
            arr -> toDTO((Movie) arr[0], (List<MovieImage>)(Arrays.asList((MovieImage) arr[1])), (Double) arr[2], (Long) arr[3])) ;
  }
}
