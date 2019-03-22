package xin.zhuyao.tencentbot;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xin.zhuyao.httputil.HttpUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import xin.zhuyao.tencentbot.pojo.WechatSubscriptionEntity;
import xin.zhuyao.tencentbot.service.WechatService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zy
 * @Date: 2019/3/20 19:15
 * @Version 1.0
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WechatSubscriptionTests {

    @Autowired
    private WechatService wechatService;

    //读取网页，把网页数据存到数据库中
    @Test
    public void wechatSubscription() {
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter dateTimeFormatterNYR = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String html = HttpUtils.get("https://wq-zy.oss-cn-hangzhou.aliyuncs.com/profile_ext.htm");
        Document doc = Jsoup.parse(html);
        List<String> sendDateList = new ArrayList<>();
        List<String> fileNameUrlList = new ArrayList<>();
        List<String> fileNameList = new ArrayList<>();
        Elements elements = doc.getElementsByTag("p");
        for (Element element : elements) {
            String sendDate = element.getElementsByClass("weui_media_extra_info").text();
            if (StringUtils.isNotBlank(sendDate)) {
                String yyyy = "";
                String MM = "";
                String dd = "";
                String[] split = sendDate.split("年");
                yyyy = split[0] + "年";
                String[] split1 = split[1].split("月");
                if (split1[0].length() == 1) {
                    MM = "0" + split1[0] + "月";
                }else {
                    MM = split1[0] + "月";
                }
                String[] split2 = split1[1].split("日");
                if (split2[0].length() == 1) {
                    dd = "0" + split2[0] + "日";
                }else {
                    dd = split2[0] + "日";
                }
                String sendDateStr = yyyy + MM + dd;
                LocalDate date= LocalDate.parse(sendDateStr, dateTimeFormatter1);
                sendDateList.add(dateTimeFormatter2.format(date));
            }
        }
        Elements elementsH4 = doc.getElementsByTag("h4");
        for (Element element : elementsH4) {
            String fileNameUrl = element.attr("hrefs");
            String fileName = element.text();
            fileNameUrlList.add(fileNameUrl);
            fileNameList.add(fileName);
        }

        List<WechatSubscriptionEntity> wechatSubscriptionEntityList = new ArrayList<>();
        for (int i = 0; i < fileNameList.size(); i++) {
            WechatSubscriptionEntity wechatSubscriptionEntity = new WechatSubscriptionEntity();
            wechatSubscriptionEntity.setFileName(fileNameList.get(i));
            wechatSubscriptionEntity.setFileNameUrl(fileNameUrlList.get(i));
            wechatSubscriptionEntity.setSendDate(sendDateList.get(i));
            wechatSubscriptionEntity.setCreateDate(dateTimeFormatterNYR.format(LocalDateTime.now()));
            wechatSubscriptionEntity.setUpdateDate(dateTimeFormatterNYR.format(LocalDateTime.now()));
            wechatSubscriptionEntity.setEmploy(false);
            wechatSubscriptionEntity.setSubscriptionName("Java团长");
            wechatSubscriptionEntityList.add(wechatSubscriptionEntity);
        }
        wechatService.saveAll(wechatSubscriptionEntityList);
    }
}
