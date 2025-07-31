package com.devlumi.mreview.repository;

import com.devlumi.mreview.domain.entity.Movie;
import com.devlumi.mreview.domain.entity.MovieImage;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.IntStream;

@Log4j2
@SpringBootTest
public class MovieRepositoryTest {

  @Autowired
  private MovieRepository movieRepository;

  @Autowired
  private MovieImageRepository imageRepository;

  @Test
  @Transactional
  public void insertMovies(){
    IntStream.rangeClosed(0, 100).forEach(i ->{
      Movie movie = Movie.builder()
              .title("Movie Title" + i)
              .build();

      log.info("-----------------------");

      movieRepository.save(movie);

      int count = (int)(Math.random() * 5) + 1;

      for (int j = 0; j < count; j++) {
        MovieImage movieImage = MovieImage.builder()
                .uuid(UUID.randomUUID().toString())
                .movie(movie)
                .imgName("Movie Image" + j+".jpg")
                .build();

        imageRepository.save(movieImage);
        log.info("-----------------------");
      }
    });

  }

  @Test
  public void testListPage(){
    PageRequest pageRequest = PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "mno"));

    Page<Object[]> result = movieRepository.getListPage(pageRequest);
//.forEach(m -> log.info(Arrays.toString(m))
    for (Object[] objects : result.getContent()){
      log.info(Arrays.toString(objects));
    }
  }

  @Test
  public void testGetMovieWithAll(){
    movieRepository.getMovieWithAll(100L).forEach(m -> log.info(Arrays.toString(m)));
  }
}
