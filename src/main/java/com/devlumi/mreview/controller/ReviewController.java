package com.devlumi.mreview.controller;

import com.devlumi.mreview.domain.dto.ReviewDTO;
import com.devlumi.mreview.service.ReviewService;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@RequestMapping("review")
public class ReviewController {
  private final ReviewService service;

  @GetMapping("{mno}/all")
  public ResponseEntity<?> list(@PathVariable Long mno) {
    return ResponseEntity.ok(service.getListwithMovie(mno));
  }

  @PostMapping("{mno}")
  public ResponseEntity<?> create(@PathVariable Long mno, @RequestBody ReviewDTO dto) {
    return ResponseEntity.ok(service.register(dto));
  }

  @PutMapping("{mno}/{reviewnum}")
  public ResponseEntity<?> update(@PathVariable Long mno,@PathVariable Long reviewnum, @RequestBody ReviewDTO dto) {
    service.modify(dto);
    return ResponseEntity.ok(dto.getReviewnum());
  }

  @DeleteMapping("{mno}/{reviewnum}")
  public ResponseEntity<?> delete(@PathVariable Long mno, @PathVariable Long reviewnum) {
    service.remove(reviewnum);
    return ResponseEntity.ok("success");
  }
}
