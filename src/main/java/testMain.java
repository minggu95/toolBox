import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import imagePrint.DrivePrintService;
import imagePrint.PrintJframe;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.lang3.StringUtils;
import util.HttpUtils;

import javax.print.PrintException;
import javax.print.attribute.standard.Copies;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


import java.io.File;

import java.io.FileInputStream;

import javax.print.Doc;

import javax.print.DocFlavor;

import javax.print.DocPrintJob;

import javax.print.PrintService;

import javax.print.PrintServiceLookup;

import javax.print.ServiceUI;

import javax.print.SimpleDoc;

import javax.print.attribute.DocAttributeSet;

import javax.print.attribute.HashDocAttributeSet;

import javax.print.attribute.HashPrintRequestAttributeSet;

import javax.swing.JFileChooser;

public class testMain {
    static String addUrl = "http://ypnew.hnggzyjy.cn:9080/hctrade/suppurDistributionRelation/addDistributionRelationDl.html";
    static String getCompanyUrl = "http://ypnew.hnggzyjy.cn:9080/hctrade/suppurDistributionRelation/getCompanyList.html?";
    static String getHospitalUrl = "http://ypnew.hnggzyjy.cn:9080/hctrade/suppurDistributionRelation/getHospitalList.html";
    static String cookies = "SESSION=e1b2e4bf-14bc-46e7-95b8-b914eb488959; isCrossRegion=10022; queryCondition=; JSESSIONID=8545EFB0075983DE8C5BB5EE5A6E6E57";

    public static void main(String[] arg0) {
        System.out.println(getData(getCompanyUrl,"河南瑞星瀚瑜商贸有限公司"));
    }

    //调用接口获取数据
    public static JSONObject getData(String url,String companyName) {
        NameValuePair[] data = {
                new NameValuePair("companyName",companyName)
        };
        String result = HttpUtils.dopost(url, cookies);
        return JSONObject.parseObject(result);
    }

    private static String parse(String content, Map<String, String> kvs) {
        String pattern = "\\$\\{(.*?)}";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(content);
        StringBuffer sr = new StringBuffer();
        while (m.find()) {
            String group = m.group();
            m.appendReplacement(sr, kvs.get(group));
        }
        m.appendTail(sr);
        return sr.toString();
    }

    /**
     * 获取下一整点时间
     * @param time
     * @return
     */
    public static Date getNextHourTime(String time) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar ca = Calendar.getInstance();
        try {
            ca.setTime(df.parse(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ca.add(Calendar.HOUR,1);
        ca.set(Calendar.MINUTE,0);
        ca.set(Calendar.SECOND,0);
        ca.set(Calendar.MILLISECOND,0);
        return ca.getTime();
    }

    public static void updateAttendReport() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            long closeCircleSecond = 0;
            long integralCloseCircleSecond = 0;
            long mealTime = 0;
            String integralCardDetails = "";
            String data = "进2022-09-19 08:00:00,出2022-09-19 11:30:00,进2022-09-19 11:35:00,出2022-09-19 17:14:00";
            String arr[] = data.split(",");//刷卡明细转数组
            if (arr.length > 1) {
                String temp = "";
                int i = 0;
                while (i < arr.length) {
                    temp = arr[i];
                    if ("进".equals(temp.substring(0, 1))) {
                        if (i + 1 < arr.length) {
                            if ("出".equals(arr[i + 1].substring(0, 1))) {
                                String outTime = arr[i + 1].substring(1);
                                String inTime = temp.substring(1);
                                closeCircleSecond = (df.parse(outTime).getTime() - df.parse(inTime).getTime()) / 1000 + closeCircleSecond;
                                /**
                                 * 1、优化验证计时点 ：计时点以半小时基数点递增或递减，即”进门“验证计时点以向后递增到就近（00:00/00:30）为基数计时）；”出门“验证计时点向前递减到就近（00:00/00:30）为基数准点计时，基准点以半小时为单位。
                                 * 2、早、中或晚三班只有各一个的进门与出门验证记录（部分单位存在午餐或晚餐送入场地内就餐/休息），结合进/出门验证计时点规则，并对闭环区间内包含了（12:00-13:00点）整时段时间的扣减1小时工时，若又包含（17：00-18：00点）整时段时间的扣再扣减1小时工时。扣减后计算当日闭环工时总时长。
                                 * 3、当日单次区间闭环进/出门工时低于1小时的，对应该区间段闭环时长按0小时不予计算至当日总时长内。
                                 */
                                //进卡处理
                                Date integralInTime = new Date();
                                Date integralOutTime = new Date();
                                if (df.parse(inTime).getMinutes() / 30 <= 0) {
                                    integralInTime = df.parse(inTime);
                                    integralInTime.setMinutes(30);
                                    integralInTime.setSeconds(0);
                                } else {
                                    integralInTime = getNextHourTime(inTime);
                                }
                                //出卡处理
                                if (df.parse(outTime).getMinutes() / 30 == 0) {
                                    integralOutTime = df.parse(outTime);
                                    integralOutTime.setMinutes(0);
                                    integralOutTime.setSeconds(0);
                                } else {
                                    integralOutTime = df.parse(outTime);
                                    integralOutTime.setMinutes(30);
                                    integralOutTime.setSeconds(0);
                                }
                                if ((integralOutTime.compareTo(integralInTime) == 1) && (integralOutTime.getTime() - integralInTime.getTime() >= 3600000)) {
                                    integralCloseCircleSecond = (integralOutTime.getTime() - integralInTime.getTime())/1000 + integralCloseCircleSecond;
                                    if(((integralInTime.getHours() < 12 || (integralInTime.getHours() == 12 && integralInTime.getMinutes() == 0 && integralInTime.getSeconds() == 0)) && integralOutTime.getHours() >= 13)
                                            || ((integralInTime.getHours() < 17 || (integralInTime.getHours() == 17 && integralInTime.getMinutes() == 0 && integralInTime.getSeconds() == 0)) && integralOutTime.getHours() >= 18)) {
                                        mealTime++;
                                    }
                                    integralCardDetails = integralCardDetails + ",进" + df.format(integralInTime) + ",出" + df.format(integralOutTime);
                                }
                                i += 2;
                            } else {
                                i += 1;
                            }
                        } else {
                            break;
                        }
                    } else {
                        i += 1;
                    }
                }
            }
            System.out.println("准确闭环时间(秒)：" + closeCircleSecond + ",(时)：" + closeCircleSecond/3600.0);
            System.out.println("整点闭环时间(秒)：" + integralCloseCircleSecond + ",(时)：" + integralCloseCircleSecond/3600.0);
            System.out.println("筛选掉用餐时间后：" + (integralCloseCircleSecond - mealTime*3600) + ",(时)：" + (integralCloseCircleSecond - mealTime*3600)/3600.0);
            System.out.println("整点进出卡详情：" + integralCardDetails.substring(1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    
}
