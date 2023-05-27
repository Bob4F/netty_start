package com.tyson.www;

import org.junit.Test;

public class StrTest {

  String str = "\n"
      + "\n"
      + "    /**\n"
      + "     * 原始数据体育表名\n"
      + "     */\n"
      + "    String ORIGINAL_SPORT_TYPE = \"original_sport_type\";\n"
      + "\n"
      + "    /**\n"
      + "     * 原始数据区域表名\n"
      + "     */\n"
      + "    String ORIGINAL_SPORT_REGION = \"original_sport_region\";\n"
      + "\n"
      + "    /**\n"
      + "     * 原始数据比赛状态表名\n"
      + "     */\n"
      + "    String ORIGINAL_MATCH_STAT = \"original_match_stat\";\n"
      + "\n"
      + "    /**\n"
      + "     * 原始数据联赛表名\n"
      + "     */\n"
      + "    String ORIGINAL_SPORT_TOURNAMENT = \"original_sport_tournament\";\n"
      + "\n"
      + "    /**\n"
      + "     * 原始数据比赛表名\n"
      + "     */\n"
      + "    String ORIGINAL_MATCH_INFO = \"original_match_info\";\n"
      + "\n"
      + "    /**\n"
      + "     * 原始数据已经订阅的\n"
      + "     */\n"
      + "    String ORIGINAL_BOOKINGS = \"original_bookings\";\n"
      + "    String LIVE_MATCH_BOOKING=\"live_match_booking\";\n"
      + "\n"
      + "    /**\n"
      + "     * 赛事状态更新表\n"
      + "     */\n"
      + "    String ORIGINAL_MATCH_STATUS = \"original_match_status\";\n"
      + "\n"
      + "    /**\n"
      + "     * 原始数据语种表名\n"
      + "     */\n"
      + "    String ORIGINAL_LANGUAGE = \"original_language\";\n"
      + "\n"
      + "    /**\n"
      + "     * 原始数据翻译表名\n"
      + "     */\n"
      + "    String ORIGINAL_TRANSLATION = \"original_translation\";\n"
      + "\n"
      + "    /**\n"
      + "     * 原始玩法数据\n"
      + "     */\n"
      + "    String ORIGINAL_MARKET_TYPE = \"original_market_type\";\n"
      + "\n"
      + "    /**\n"
      + "     * 原始数据赛事盘口表名\n"
      + "     */\n"
      + "    String ORIGINAL_MATCH_MARKET = \"original_match_market\";\n"
      + "\n"
      + "    /**\n"
      + "     * 原始交易项数据\n"
      + "     */\n"
      + "    String ORIGINAL_SELECTION_TYPE = \"original_selection_type\";\n"
      + "\n"
      + "    /**\n"
      + "     * 原始球队更新数据\n"
      + "     */\n"
      + "    String ORIGINAL_TEAM_UPDATE = \"original_team_update\";\n"
      + "\n"
      + "    /**\n"
      + "     * scoutFeed原始赛事信息表名\n"
      + "     */\n"
      + "    String ORIGINAL_SCOUT_GAME = \"original_scout_game\";\n"
      + "\n"
      + "    /**\n"
      + "     * scoutFeed原始实时事件数据\n"
      + "     */\n"
      + "    String ORIGINAL_SCOUT_EVENT = \"original_scout_event\";\n"
      + "\n"
      + "    /**\n"
      + "     * oddsFeed运动种类赛事阶段映射表\n"
      + "     */\n"
      + "    String SPORT_PERIOD_MAP = \"bc_sport_period_map\";\n"
      + "\n"
      + "    /**\n"
      + "     * 统计表\n"
      + "     */\n"
      + "    String BC_SUMMARY_INFO = \"bc_summary_info\";\n";

  @Test
  public void perfectStr() {
    String[] splitArray = str.split(";");
    for (String s : splitArray) {
      String[] parts = s.split("\n");
      try {
        String constantValue = parts[3].trim().replaceAll("\"", ""); // 获取常量值

        String collectionName = parts[5].split("=")[1].trim().replaceAll("\"", "");
        String output = constantValue + "=" + collectionName;
        System.out.println(output);
      } catch (Exception e) {
        System.out.println("异常当前字符串" + s);
      }
    }

  }

}
