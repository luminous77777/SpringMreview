package com.devlumi.mreview.controller.unit;

import com.devlumi.mreview.controller.ReviewController;
import com.devlumi.mreview.repository.ReviewRepository;
import com.devlumi.mreview.service.ReviewServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest(ReviewController.class)
@ContextConfiguration(name = "application.yaml")
public class ReviewControllerTest {
//  @Autowired
//  private MockMvc mockMvc; //db 설정도 해야함,
//
//  @MockBean
//  private ReviewServiceImpl service;
//  @MockBean
//  private ReviewRepository repository;
//
//  @Test
//  @DisplayName("단순 목록 조회")
//  public void simplelistRead() throws Exception {
//    Long mno = 100L;
//    mockMvc.perform(MockMvcRequestBuilders.get(String.format("/review/%d/all",mno)));
//  }
}
