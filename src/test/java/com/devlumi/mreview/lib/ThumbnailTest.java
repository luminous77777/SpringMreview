package com.devlumi.mreview.lib;

import net.coobird.thumbnailator.Thumbnails;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@SpringBootTest
public class ThumbnailTest {
  @Test
  public void testConvert() throws IOException {
    BufferedImage originalImage = ImageIO.read(new File("C:\\Users\\tj\\Desktop\\test","tran.webp"));

    BufferedImage thumbnail = Thumbnails.of(originalImage)
            .size(200,200)
            .asBufferedImage();

    ImageIO.write(thumbnail, "webp", new File("C:\\Users\\tj\\Desktop\\test","output.webp"));
  }
  @Test
  public void testConvertWebp() throws IOException {
    BufferedImage originalImage = ImageIO.read(new File("C:\\Users\\tj\\Desktop\\test","tran.png"));
    ImageIO.write(originalImage, "webp", new File("C:\\Users\\tj\\Desktop\\test","output.webp"));
    BufferedImage webpThumbnail = Thumbnails.of(originalImage).size(200,200).asBufferedImage();


    ImageIO.write(webpThumbnail, "webp", new File("C:\\Users\\tj\\Desktop\\test","outputthumb.webp"));

  }
}
