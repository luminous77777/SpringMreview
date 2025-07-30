package com.devlumi.mreview.repository;

import com.devlumi.mreview.entity.Member;
import com.devlumi.mreview.entity.Movie;
import com.devlumi.mreview.entity.Review;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@Log4j2
@SpringBootTest
public class ReviewRepositoryTest {

  @Autowired
  private ReviewRepository reviewRepository;



  @Test
  @Transactional
  public void insertMovieReviews() {
    IntStream.rangeClosed(0, 200).forEach(i -> {

      Long mno = (long)(Math.random() * 100) +1;

      Long mid = (long)(Math.random() * 100) +1;
      Member member = Member.builder().mid(mid).build();

      Review movieReview = Review.builder()
              .member(member)
              .movie(Movie.builder().mno(mno).build())
              .grade((int)(Math.random() * 5) +1)
              .text("영화 감상....." + i)
              .build();

      reviewRepository.save(movieReview);
    });

  }

  @Test
//  @Transactional(readOnly = true)
  public void testFindByMovieMno(){
    reviewRepository.findByMovie_mno(100L).forEach(r ->{
      log.info(r);
//      log.info(r.getMember());
      log.info(r.getMember().getEmail()); //lazy로드 상태일때 @Transactional이 없다면 이것은 오류
      log.info(r.getMovie().getTitle());
    });
  }


}
