package xin.zhuyao.tencentbot.utils;

import org.apache.commons.codec.digest.DigestUtils;
import xin.zhuyao.httputil.HttpUtils;
import xin.zhuyao.httputil.Utils;
import xin.zhuyao.tencentbot.pojo.TencentBotReturn;
import xin.zhuyao.tencentbot.pojo.TencentPictureReturn;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * @Author: zy
 * @Date: 2019/3/8 15:46
 * @Version 1.0
 * @Description
 */
public class TencentPictureUtils {

    private static final String URL = "https://ai.qq.com/cgi-bin/appdemo_facedecoration";

    public static TencentPictureReturn tencentPicture(String imageUrl, String decoration){
        HashMap<String,String> hashMapParams = new HashMap<>();
        hashMapParams.put("g_tk","5381");
        hashMapParams.put("image_url",imageUrl);
        hashMapParams.put("decoration", decoration);
        String postReturn = HttpUtils.posts(URL, hashMapParams);
        return Utils.json(postReturn, TencentPictureReturn.class);
    }

//    public static void main(String[] args) {
//        TencentPictureReturn tencentPictureReturn = tencentPicture("http://p3.pstatp.com/large/12da00042b6ea7882b7a", "5");
//        System.out.println("11");
//    }
}
