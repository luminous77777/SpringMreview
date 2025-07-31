package com.devlumi.mreview.repository;

import com.devlumi.mreview.domain.entity.Member;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.IntStream;

@Log4j2
@SpringBootTest
public class MemberRepositoryTest {

  @Autowired
  private MemberRepository memberRepository;
  @Autowired
  private MovieRepository movieRepository;
  @Autowired
  private ReviewRepository reviewRepository;

  @Test
  @Transactional
  public void insertMembers() {
    IntStream.rangeClosed(1,100).forEach(i->{
      Member member = Member.builder()
              .email("user" + i + "@gmail.com")
              .pw("1111")
              .nickname("reviewer" + i)
              .build();
      memberRepository.save(member);
    });
  }

  @Test
  @Transactional
//  @Commit
  public void testDelteByMemberMid(){
    memberRepository.deleteById(90L);
    reviewRepository.deleteByMember_mid(90L);

  }
}
