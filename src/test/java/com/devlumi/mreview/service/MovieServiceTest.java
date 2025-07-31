package com.devlumi.mreview.service;

import com.devlumi.mreview.domain.dto.PageRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class MovieServiceTest {
  @Autowired
  private MovieService movieService;

  @Test
  public void testList() {
    movieService.getList(PageRequestDTO.builder().build()).getList().forEach(log::info);
  }
}
