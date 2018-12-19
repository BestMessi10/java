package cn.wslint.alarm.util;

import cn.wslint.alarm.common.Constant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.ini4j.Config;
import org.ini4j.Ini;
import org.ini4j.Profile.Section;
import org.ini4j.Wini;

public class IniReader {
  // section        item     value
  private static Map<String, HashMap<String, String>> sectionsMap = new HashMap<String, HashMap<String, String>>();
  //      item    value
  private static HashMap<String, String> itemsMap = new HashMap<String, String>();

  private static String currentSection = "";

  public static void main(String[] args) throws IOException {
    File file = new File(Constant.FILE_PATH);
    //new IniReader().loadData(file); //遍历整个ini文件内容
    //new IniReader().getValue("北京", "101010400", file);  //传入三个参数：部分；条目；文件路径；返回：条目对应的值；
    //new IniReader().getValue("上海", "101020900", "E:/cityid.ini"); //传入三个参数：部分；条目；文件路径字符串；返回：条目对应的值；

		/*得到ini文件内容里面的全部部分
		 * List<String> lists = new IniReader().getSectionNames(file);
		for (String string : lists) {
			System.out.println(string);
		}*/

    new IniReader().loadData(file);
    String value = new IniReader().getValue("monitor", "alarm_machine ", file);
    System.out.println("monitor"+value);
    //传入部分和文件路径，返回：该部分下的全部条目和值
    Map<String, String> maps = new IniReader().getItemsBySectionName("logtest", file);
    System.out.println(maps.size());
    for (Map.Entry<String, String> entry : maps.entrySet()) {
      System.out.println("key= " + entry.getKey() + ";value= " + entry.getValue());
    }






  }

  /**
   * 利用api进行修改配置文件
   */
  public static void updateData(File file, String item,String key,String setValue){
    Config cfg = new Config();
    cfg.setMultiSection(false);
    Ini ini = new Wini();
    ini.setConfig(cfg);
    try {

      ini.load(file);
      Section section = ini.get(item);
      section.put(key,setValue);
      ini.store(file);

    }catch (IOException e){
      e.printStackTrace();
    }
  }

  /**
   * 遍历整个ini文件内容
   * Load data from target file
   * @param file target file. It should be in ini format
   */
  public static void loadData(File file) {
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader(file));
      String line = null;
      while ((line = reader.readLine()) != null) {
        line = line.trim();
        if("".equals(line)) continue;
        if(line.startsWith("[") && line.endsWith("]")) {
          // Ends last section
          if(itemsMap.size() > 0 && !"".equals(currentSection.trim())) {
            sectionsMap.put(currentSection, itemsMap);
          }
          currentSection = "";
          itemsMap = null;

          // Start new section initial
          currentSection = line.substring(1, line.length() -1);
          itemsMap = new HashMap<String, String>();
        } else {
          int index = line.indexOf("=");
          if(index != -1) {
            String key = line.substring(0,index);
            String value = line.substring(index + 1, line.length());
            itemsMap.put(key, value);
          }
        }

        //System.out.println(line);
      }
      System.out.println(sectionsMap.size());
      reader.close();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e1) {
          e1.printStackTrace();
        }
      }
    }
  }

  /**
   * 传入三个参数：部分；条目；文件路径；返回：条目对应的值；
   * @param section
   * @param item
   * @param file
   * @return
   */
  public static String getValue(String section, String item, File file) {
    loadData(file);

    HashMap<String, String> map = sectionsMap.get(section);
    if(map == null) {
      return "No such section:" + section;
    }
    String value = map.get(item);
    if(value == null) {
      return "No such item:" + item;
    }
    System.out.println(value);
    return value;
  }

  /**
   * 传入三个参数：部分；条目；文件路径字符串；返回：条目对应的值；
   * @param section
   * @param item
   * @param fileName
   * @return
   */
  public String getValue(String section, String item, String fileName) {
    File file = new File(fileName);
    return getValue(section, item, file);
  }

  /**
   * 传入文件路径参数，返回部分list集合；
   * @param file
   * @return
   */
  public static List<String> getSectionNames(File file) {
    List<String> list = new ArrayList<String>();
    loadData(file);
    Set<String> key = sectionsMap.keySet();
    for (Iterator<String> it = key.iterator(); it.hasNext();) {
      list.add(it.next());
    }
    return list;
  }

  /**
   * 传入部分和文件路径，返回：该部分下的全部条目和值
   * @param section
   * @param file
   * @return
   */
  public static Map<String, String> getItemsBySectionName(String section, File file) {
    loadData(file);
    return sectionsMap.get(section);
  }
}