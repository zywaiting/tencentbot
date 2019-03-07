package xin.zhuyao.tencentbot.utils;

import org.apache.commons.lang3.StringUtils;

import java.net.URLEncoder;
import java.util.*;

/**
 * @Author: zy
 * @Date: 2019/3/7 11:03
 * @Version 1.0
 * @Description
 */
public class SortUtils {
    /**
     * @param param 参数
     * @param encode 编码
     * @param isLower 是否小写
     * @return
     */
    public static String formatUrlParam(Map<String, String> param, String encode, boolean isLower,String appKey) {
        String params = "";
        Map<String, String> map = param;

        try {
            List<Map.Entry<String, String>> itmes = new ArrayList<Map.Entry<String, String>>(map.entrySet());

            //对所有传入的参数按照字段名从小到大排序
            //Collections.sort(items); 默认正序
            //可通过实现Comparator接口的compare方法来完成自定义排序
            Collections.sort(itmes, new Comparator<Map.Entry<String, String>>() {
                @Override
                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                    // TODO Auto-generated method stub
                    return (o1.getKey().toString().compareTo(o2.getKey()));
                }
            });

            //构造URL 键值对的形式
            StringBuffer sb = new StringBuffer();
            for (Map.Entry<String, String> item : itmes) {
                if (StringUtils.isNotBlank(item.getKey())) {
                    String key = item.getKey();
                    String val = item.getValue();
                    val = URLEncoder.encode(val, encode);
                    if (isLower) {
                        sb.append(key.toLowerCase() + "=" + val);
                    } else {
                        sb.append(key + "=" + val);
                    }
                    sb.append("&");
                }
            }

            params = "";
            if (!sb.toString().isEmpty()) {
                params = sb.append("app_key=" + URLEncoder.encode(appKey, encode)).toString();
            }
        } catch (Exception e) {
            return "";
        }
        return params;
    }




}
