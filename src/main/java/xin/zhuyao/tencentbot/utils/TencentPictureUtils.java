package xin.zhuyao.tencentbot.utils;

import xin.zhuyao.httputil.HttpUtils;
import xin.zhuyao.httputil.Utils;
import xin.zhuyao.tencentbot.entitydto.TencentPictureDto;

import java.util.HashMap;

/**
 * @Author: zy
 * @Date: 2019/3/8 15:46
 * @Version 1.0
 * @Description
 */
public class TencentPictureUtils {

    private static final String URL = "https://ai.qq.com/cgi-bin/appdemo_facedecoration";

    public static TencentPictureDto tencentPicture(String imageUrl, String decoration){
        HashMap<String,String> hashMapParams = new HashMap<>();
        hashMapParams.put("g_tk","5381");
        hashMapParams.put("image_url",imageUrl);
        hashMapParams.put("decoration", decoration);
        String postReturn = HttpUtils.posts(URL, hashMapParams);
        return Utils.json(postReturn, TencentPictureDto.class);
    }

//    public static void main(String[] args) {
//        TencentPictureDto tencentPictureReturn = tencentPicture("http://p3.pstatp.com/large/12da00042b6ea7882b7a", "5");
//        System.out.println("11");
//    }
}
