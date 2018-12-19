package wslint.wisdomreport.common;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by ymd on 2018/12/17
 */
public class ConfUtil {

  public static Properties p = null;

  public static String getConfig(String configFilePath, String str) {
    if (p == null) {
      p = new Properties();
    }
    try {
      p.load(new BufferedInputStream(new FileInputStream(configFilePath)));
      return p.getProperty(str).trim();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }

  public static void update(String configFilePath,String key, String value) {
    p.setProperty(key, value);
    FileOutputStream oFile = null;
    try {
      oFile = new FileOutputStream(configFilePath);
      //将Properties中的属性列表（键和元素对）写入输出流
      p.store(oFile, "");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        oFile.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

}
