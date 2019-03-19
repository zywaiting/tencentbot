package xin.zhuyao.tencentbot.utils;

import org.apache.commons.codec.digest.DigestUtils;
import xin.zhuyao.httputil.HttpUtils;
import xin.zhuyao.httputil.Utils;
import xin.zhuyao.tencentbot.entitydto.TencentBotDto;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * @Author: zy
 * @Date: 2019/3/7 12:52
 * @Version 1.0
 * @Description
 */
public class TencentBotUtils {

    private static final String URL = "https://api.ai.qq.com/fcgi-bin/nlp/nlp_textchat";

    public static TencentBotDto tencentBot(String appId, String appKey, String session, String question) throws Exception {
        HashMap<String,String> hashMapParams = new HashMap<>();
        hashMapParams.put("app_id",appId);
        hashMapParams.put("time_stamp",String.valueOf(new Date().getTime()/1000));
        hashMapParams.put("nonce_str", UUID.randomUUID().toString().replaceAll("-",""));
        hashMapParams.put("session",session);
        hashMapParams.put("question", question);
        hashMapParams.put("sign", DigestUtils.md5Hex(SortUtils.formatUrlParam(hashMapParams, "utf-8", true, appKey)).toUpperCase());
        String postReturn = HttpUtils.posts(URL, hashMapParams);
        return Utils.json(postReturn, TencentBotDto.class);
    }
}
