package com.devlumi.mreview.service;

import com.devlumi.mreview.domain.dto.ReviewDTO;
import com.devlumi.mreview.domain.entity.Review;
import com.devlumi.mreview.repository.ReviewRepository;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@Log4j2
public non-sealed class ReviewServiceImpl implements ReviewService{

  private final ReviewRepository repository;


  @Override
  public List<ReviewDTO> getListwithMovie(Long mno) {
    return repository.findByMovie_mno(mno).stream().map(this::toDTO).toList();
  }

  @Override
  public Long register(ReviewDTO dto) {
    return repository.save(toEntity(dto)).getReviewnum();
  }

  @Override
  public void modify(ReviewDTO dto) {
    Review review = repository.findById(dto.getReviewnum()).orElseThrow(() -> new IllegalArgumentException("review number not found"));
    review.setGrade(dto.getGrade());
    review.setText(dto.getText());
  }

  @Override
  public void remove(Long reviewnum) {
    repository.deleteById(reviewnum);
  }
}
