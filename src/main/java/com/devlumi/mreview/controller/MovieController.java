package com.devlumi.mreview.controller;

import com.devlumi.mreview.domain.dto.MovieDTO;
import com.devlumi.mreview.domain.dto.PageRequestDTO;
import com.devlumi.mreview.domain.dto.PageResponseDTO;
import com.devlumi.mreview.domain.entity.Movie;
import com.devlumi.mreview.service.MovieService;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Data
@Log4j2
@RequestMapping("movie")
public class MovieController {
  private final MovieService movieService;

  @GetMapping("register")
  public void register(){

  }

  @PostMapping("register")
  public String register(MovieDTO movieDTO, RedirectAttributes redirectAttributes){
    log.info(movieDTO);
    redirectAttributes.addFlashAttribute("msg",movieService.register(movieDTO));
    return "redirect:/movie/register";
//    return null;
  }

  @GetMapping("list")
  public void list(@ModelAttribute("requestDto")  PageRequestDTO pageRequestDTO, Model model) {
    PageResponseDTO<?, ?> dto = movieService.getList(pageRequestDTO);  //어떤 값을 전달하는지 확인용
    log.info(dto);
    model.addAttribute("movies", dto);
  }

  @GetMapping("read")
  public void read(@ModelAttribute("requestDto") PageRequestDTO dto, Model model, Long mno){
    log.info("readpage.....");
    model.addAttribute("dto", movieService.get(mno));
  }
}
