package com.gao.jvm;

import java.util.HashMap;
import java.util.Map;

/**
 * User: wangchen.gpx
 * Date: 13-4-28
 * Time: 上午10:15
 */
public class MapTest {
    private Map<String,String> m = new HashMap<String,String>();
       public void MapTest() {
              m.put("Mickey", "Mouse");
               m.put("Mickey", "Mantle");
            }
        public int size() {
               return m.size();
            }
        public static void main(String args[ ]) {
            MapTest moreNames = new MapTest();
                System.out.println(moreNames.size());
            }

}
