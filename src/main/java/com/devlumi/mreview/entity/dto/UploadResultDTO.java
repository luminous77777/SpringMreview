package com.devlumi.mreview.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Data
@AllArgsConstructor
public class UploadResultDTO implements Serializable {

  private String fileName;
  private String uuid;
  private String folderPath;

  public String getImageURL(){
    try {
      return URLEncoder.encode(folderPath + "/" + uuid + "_" + fileName, StandardCharsets.UTF_8);
    } catch (Exception e) {{}
      e.printStackTrace();
    }
    return "";
  }
}
