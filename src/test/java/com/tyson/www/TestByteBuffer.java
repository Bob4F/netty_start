package com.tyson.www;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestByteBuffer {

  public static void main(String[] args) {
    // FileChannel
    try (FileChannel channel = new FileInputStream("data.txt").getChannel()) {
      ByteBuffer buffer = ByteBuffer.allocate(10);
      while (true) {
        int len = channel.read(buffer);
        if (len == -1) {
          break;
        }
        // 打印buffer内容
        buffer.flip();// 切换读取模式
        while (buffer.hasRemaining()) { // 是否还有没读的数据
          byte b = buffer.get();
          log.info("实际的字节{}", (char) b);
        }
        // 写模式
        buffer.clear();
      }
    } catch (IOException e) {
      log.error("测试异常", e);
    }
  }
}
