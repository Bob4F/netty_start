package com.tyson.www;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class FileChannelCase {


  @Test
  public void transfer() {
    try (FileChannel from = new FileInputStream("data.txt").getChannel();
        FileChannel to = new FileOutputStream("to.txt").getChannel()) {
      // 一次最多传2G
      from.transferTo(0, from.size(), to);
    } catch (IOException e) {
      log.error("传输异常", e);
    }
  }

  /**
   * 遍历文件夹
   * @throws IOException
   */
  @Test
  public void walkFileTree() throws IOException {
    Path path = Paths.get("/Users/mac/home/git_space/");

    final AtomicInteger fileCount = new AtomicInteger();
    final AtomicInteger directCount = new AtomicInteger();
    Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
          throws IOException {
        log.info("文件夹名:{}", dir);
        directCount.incrementAndGet();
        return super.preVisitDirectory(dir, attrs);
      }

      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        log.info("文件名:{}", file);
        fileCount.incrementAndGet();
        return super.visitFile(file, attrs);
      }
    });

    log.info("文件夹总数:{}", directCount.get());
    log.info("文件总数:{}", fileCount.get());



  }

}
