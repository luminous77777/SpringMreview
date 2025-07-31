package com.devlumi.mreview.controller;

import com.devlumi.mreview.domain.dto.MovieDTO;
import com.devlumi.mreview.domain.entity.Movie;
import com.devlumi.mreview.service.MovieService;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Data
@RequestMapping("movie")
public class MovieController {
  private final MovieService movieService;

  @GetMapping("register")
  public void register(){

  }

  @PostMapping("register")
  public String register(MovieDTO movieDTO, RedirectAttributes redirectAttributes){
    redirectAttributes.addFlashAttribute("msg",movieService.register(movieDTO));
    return "redirect:/movie/register";

  }
}
