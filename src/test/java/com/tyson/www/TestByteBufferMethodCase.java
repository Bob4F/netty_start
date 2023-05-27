package com.tyson.www;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class TestByteBufferMethodCase {

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

  /**
   * rewind
   * mark & reset
   */
  @Test
  public void readTest() {
    ByteBuffer buffer = ByteBuffer.allocate(10);
    buffer.put(new byte[]{'a', 'b', 'c'});
    buffer.flip();

    buffer.get(new byte[2]);
    log.info("当前get值:{}", (char)buffer.get());
    buffer.rewind();
    log.info("rewind后get当前位置值{}", (char)buffer.get());

    //mark & reset
    buffer.mark(); // 标记position位置。
    log.info("{}", (char)buffer.get());
    log.info("{}", (char)buffer.get());
    buffer.reset();// 重置position位置。
    log.info("{}", (char)buffer.get());
  }


  @Test
  public void string2ByteBufferCase() {
    ByteBuffer buffer = ByteBuffer.allocate(10);
    buffer.put("hello".getBytes(StandardCharsets.UTF_8));

    // Charset
    ByteBuffer hello = StandardCharsets.UTF_8.encode("hello");
    // 往回转
    String s = StandardCharsets.UTF_8.decode(hello).toString();
    log.info("Charset往回转值：{}", s);
    // wrap
    ByteBuffer wrap = ByteBuffer.wrap("hello".getBytes(StandardCharsets.UTF_8));


  }
}
