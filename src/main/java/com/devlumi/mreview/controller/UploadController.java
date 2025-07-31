package com.devlumi.mreview.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@Log4j2
public class UploadController {

  @Value("${spring.servlet.multipart.location}")
  private String uploadPath;

  @PostMapping("uploadAjax")
//  @ResponseBody
  public @ResponseBody ResponseEntity<?> uploadAjax(MultipartFile[] files){
    return ResponseEntity.ok(Arrays.stream(files).map(f -> {
      String uuid = null;
      String folderPath = null;

      try {
      //이미지만 업로드 가능

      log.info(f.getOriginalFilename());
      folderPath = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
      uuid = UUID.randomUUID().toString();
      folderPath = uploadPath + File.separator + folderPath;
      String saveName = uuid +"_"+ f.getOriginalFilename();
      new File(folderPath).mkdirs();
      f.transferTo(new File(folderPath,saveName));

      } catch (IOException e) {
        throw new RuntimeException(e);
      }
      return Map.of("fileName", f.getOriginalFilename(), "size", f.getSize(), "uuid", uuid, "path",folderPath);
    }));
  }

  @GetMapping("uploadEx")
  public void uploadEx(){
  }


//  private String makeFolder(){
//    String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
//
//    String folderPath = str.replace("/", File.separator);
//
//    File uploadPathFolder = new File(uploadPath, folderPath);
//
//    if(uploadPathFolder.exists() == false){
//      uploadPathFolder.mkdirs();
//    }
//    return folderPath;
//  }
}
