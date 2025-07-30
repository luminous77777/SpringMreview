package com.devlumi.mreview.repository;

import com.devlumi.mreview.entity.Review;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {
  @EntityGraph(attributePaths = "member", type = EntityGraph.EntityGraphType.FETCH) //{"",""}
  List<Review> findByMovie_mno(Long mno);

  @Modifying
  @Query("delete from Review r where r.member.mid = ?1")
  void deleteByMember_mid(Long mid);
}
