package xin.zhuyao.tencentbot.utils;

import org.apache.commons.codec.digest.DigestUtils;
import xin.zhuyao.httputil.HttpUtils;

import java.io.*;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * @Author: zy
 * @Date: 2019/3/7 12:52
 * @Version 1.0
 * @Description
 */
public class TencentSpeechUtils {

    private static final String URL = "https://api.ai.qq.com/fcgi-bin/aai/aai_asrs";
    private static final String appId = "2112705346";
    private static final String appKey = "jIYqPb1xWYob2m0z";

    public static void main(String[] args) {
        File mp3 = new File("D:\\test3.pcm");
        String dataSign1 = Base64.getEncoder().encodeToString(mp3.toString().getBytes());
        byte[] bytes = getBytes("D:\\test3.pcm");
        String dataSign = Base64.getEncoder().encodeToString(bytes);
        HashMap<String,String> hashMapParams = new HashMap<>();
        hashMapParams.put("app_id",appId);
        hashMapParams.put("time_stamp",String.valueOf(new Date().getTime()/1000));
        hashMapParams.put("nonce_str", UUID.randomUUID().toString().replaceAll("-",""));

        hashMapParams.put("format","1");
        hashMapParams.put("speech", dataSign);
        hashMapParams.put("rate", "16000");
        hashMapParams.put("sign", DigestUtils.md5Hex(SortUtils.formatUrlParam(hashMapParams, "utf-8", true, appKey)).toUpperCase());
        String postReturn = HttpUtils.posts(URL, hashMapParams);
        System.out.println(postReturn);
    }

    public static byte[] getBytes(String filePath){
        File file = new File(filePath);
        ByteArrayOutputStream out = null;
        try {
            FileInputStream in = new FileInputStream(file);
            out = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int i = 0;
            while ((i = in.read(b)) != -1) {

                out.write(b, 0, b.length);
            }
            out.close();
            in.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        byte[] s = out.toByteArray();
        return s;

    }


//    public static TencentBotReturn tencentBotSpeech(String appId,String appKey) throws Exception {
//
//        File mp3 = new File("D:\\test1.pcm");
//        String dataSign = Base64.getEncoder().encodeToString(mp3.toString().getBytes());
//
//        HashMap<String,String> hashMapParams = new HashMap<>();
//        hashMapParams.put("app_id",appId);
//        hashMapParams.put("time_stamp",String.valueOf(new Date().getTime()/1000));
//        hashMapParams.put("nonce_str", UUID.randomUUID().toString().replaceAll("-",""));
//
//        hashMapParams.put("sign", DigestUtils.md5Hex(SortUtils.formatUrlParam(hashMapParams, "utf-8", true, appKey)).toUpperCase());
//        hashMapParams.put("format","1");
//        hashMapParams.put("speech", question);
//        hashMapParams.put("rate", "16000");
//        String postReturn = HttpUtils.posts(URL, hashMapParams);
//        return Utils.json(postReturn,TencentBotReturn.class);
//    }
}
