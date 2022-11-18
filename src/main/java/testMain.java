import com.alibaba.fastjson.JSONObject;
import scData.SCProductServiceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class testMain {


    public static void main(String[] arg0) {
        /*String url = "http://10.99.10.62:6888/ormrpc/services/WSBillInterfaceFacade?wsdl";
        String param = "[{\n" +
                "\tnumber:\"002\",\n" +
                "\tname:\"test\",\n" +
                "\tdescription:\"测试项目\",\n" +
                "\tstate:\"启用\",\n" +
                "\tcompany:\"HSJT\",\n" +
                "\tparentNumber:\"\",\n" +
                "\tisLeaf:\"1\",\n" +
                "\tgroupName:\"测试\",\n" +
                "    closestatues:\"Close\",\n" +
                "    prestartdate:\"2021-02-08\",\n" +
                "     startdate:\"2021-02-08\"\n" +
                "}]";*/
        /*JSONObject json=new JSONObject();
        json.put("createUserId","liguoming");
        json.put("modelId","75");
        List organizationData = new ArrayList();
        Map map1 = new HashMap();
        map1.put("company","2001");
        map1.put("budgetitem","3.02.11");
        map1.put("project","06.91.21003");
        organizationData.add(map1);
        json.put("organizationData",organizationData);
        System.out.println(json.toJSONString());*/
        String param = "{\"success\":true,\"code\":\"1\",\"msg\":\"??????\",\"data\":{\"data\":[{\"budgetitem\":\"3.02.11\",\"project\":\"06.91.21003\",\"company\":\"2001\",\"target\":\"amount\",\"scene\":\"budgetamount\",\"amount\":\"2.333335393333E12\"}]}}";
//        JSONObject json = JSONObject.parseObject(param);
//        String arr = json.getString("data");
//        JSONObject temp = JSONObject.parseObject(arr);
//        JSONArray jsonArray = JSONObject.parseArray(temp.getString("data")) ;
//        JSONObject temp1 = (JSONObject)jsonArray.get(0);
//        System.out.println(temp1.getString("amount"));
        JSONObject json = new JSONObject();
//        List organizationData = new ArrayList();
//        Map map = new HashMap();
//        for (int n = 0; n < 2; n++) {
//            map = new HashMap();
//            for (int j = 0; j < 2; j++)
//            {
//                map.put("amount",2);
//                map.put("budgetitem",2);
//            }
//            organizationData.add(map);
//        }
//        json.put("organizationData",organizationData);
//        EStaffRegisterDto eStaffRegisterDto = new EStaffRegisterDto();
//        eStaffRegisterDto.setBirthDay("2001-10-29");
//        eStaffRegisterDto.setBirthPlace("上海市浦东新区");
//        eStaffRegisterDto.setCertNo("310222200110290089");
//        eStaffRegisterDto.setCertBeginDate("2015-01-01");
//        eStaffRegisterDto.setCertEndDate("2025-01-01");
//        eStaffRegisterDto.setGender("1");
//        eStaffRegisterDto.setImage("125324");
//        eStaffRegisterDto.setName("张三");
//        eStaffRegisterDto.setCompID("2001");
//        eStaffRegisterDto.setInitializedBy("2895");
//        eStaffRegisterDto.setNation("25");
//        eStaffRegisterDto.setSignOrg("上海浦东派出所");
//        ZKTecoPersonDto zkTecoPersonDto = new ZKTecoPersonDto();
//        zkTecoPersonDto.setPin("2021112601");
//        String data = json.toJSONString(zkTecoPersonDto);
//        String a = "s%:s%/api/person/get/{2}?access_token=s%";
//        System.out.println(data);
//        TimeInfo timeInfo = new TimeInfo();
//        timeInfo.setDate("2021-12-02 00:00:00");
//        timeInfo.setPeriod(1488);
//        System.out.println(TimeUtils.dateRollHour(timeInfo));
//        JSONArray jsonArray = new JSONArray();
//        System.out.println(jsonArray.size());
//        String date = "2022-01-01 00:00:00";
//        System.out.println(date.substring(0,10));
//        String date = "2021-12-01 06:28:38";
//        System.out.println(date.substring(0,10));
//        System.out.println(date.substring(11));
        //出00:22:11,进08:34:16,出10:02:59,进10:06:00,进10:48:34
//        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date1 = null;
//        try {
//            date1 = df.parse("2021-12-12 10:02:59");
//            Date date2 = df.parse("2021-12-12 08:34:16");
//            long time = (date1.getTime() - date2.getTime())/1000;
//            System.out.println(time+"");
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        String arr = "[\n" +
//                "        {\"startDate\":\"2018-07-01 12:31:00\",\"name\":\"aa\"},\n" +
//                "        {\"startDate\":\"2018-07-01 12:20:00\",\"name\":\"bb\"},\n" +
//                "        {\"startDate\":\"2018-07-01 15:30:00\",\"name\":\"cc\"},\n" +
//                "        {\"startDate\":\"2018-07-01 09:30:00\",\"name\":\"dd\"}]";
//        JSONArray jsonArray =JSONArray.parseArray(arr);
//        Collections.sort(jsonArray, new Comparator<Object>() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                JSONObject js1 = (JSONObject)o1;
//                JSONObject js2 = (JSONObject)o2;
//                Date i1 = js1.getDate("startDate");
//                Date i2 = js2.getDate("startDate");
//                return i1.compareTo(i2);
//            }});
//        for(int i = 0; i < jsonArray.size(); i++) {
//            JSONObject jsonObject = jsonArray.getJSONObject(i);
//            String pic = jsonObject.getString("startDate");
//            System.out.println(pic);
//        }
//        String arrParam = "出00:57:43,进13:21:47,出23:59:59";
//        String arr[] = arrParam.split(",");
//        System.out.println(arr[0].substring(0,1)+":"+arr[0].substring(1,8));
//        try {
//            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            long time = (df.parse("2021-12-17 12:59:59").getTime() - df.parse("2021-12-17 11:21:47").getTime())/1000;
//            //String cardDetails = "出2021-12-17 08:01:47,进2021-12-17 09:52:48,出2021-12-17 10:59:59,进2021-12-17 13:52:48,出2021-12-17 16:59:59,进2021-12-17 20:52:48,出2021-12-17 23:59:59";
//            String cardDetails = "出2021-12-17 00:57:43,进2021-12-17 11:21:47,出2021-12-17 12:59:59,进2021-12-17 13:21:47,出2021-12-17 23:59:59";
//            long closeCircleSecond = 0;
//            String arr[] = cardDetails.split(",");//刷卡明细转数组
//            Stack arrStack = new Stack();
//            for(int i = 0; i<arr.length; i++) {
//                if("进".equals(arr[i].substring(0,1))) {
//                    arrStack.clear();//清理栈数据
//                    arrStack.push(arr[i].substring(1,20));
//                    continue;
//                } else {
//                    if(!arrStack.empty()) {
//                        String outTime = arr[i].substring(1,20);
//                        String inTime = (String)arrStack.pop();
//                        closeCircleSecond  =(df.parse(outTime).getTime() - df.parse(inTime).getTime())/1000 + closeCircleSecond;
//                    }
//                }
//
//            }
//            System.out.println(time+"="+closeCircleSecond);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        String paaaram  ="12434312";
//        String arr[] =  paaaram.split(",");
//        System.out.println(arr[0]);
//        String[] conditions = {"1122","1122"};
//        conditions[0] = "1122";
//        conditions[1] = "3344";
//        System.out.println(conditions);
//        Violation violation = new Violation();
//        violation.setBadge("600619022503");
//        violation.setDegree(1);
//        violation.setEID(12814);
//        violation.setInitializedBy(1);
//        violation.setMajor(1);
//        violation.setOpDate(new Date());
//        violation.setVioBeh(1);
//        String objectJson = json.toJSONString(violation);
//        System.out.println(objectJson);
//        String condition = "('${paydepnum}'=='2.04.344'&&${subject2}==2300007)&&'${forceFlag}'>'2'";
//        Map<String, String> m = new HashMap<>();
//        m.put("${paydepnum}", "2.04.344");
//        m.put("${subject2}", "2300007");
//        m.put("${forceFlag}", "11");
//        String checkResult = parse(condition, m);
//        System.out.println(checkResult);
//        ScriptEngineManager manager = new ScriptEngineManager();
//        ScriptEngine engine = manager.getEngineByName("js");
//        Object result = new Object();
//        try {
//            result = engine.eval(checkResult);
//        } catch (ScriptException e) {
//            e.printStackTrace();
//        }
//        System.out.println(result.toString());
//        TimeInfo timeInfo = new TimeInfo();
//        timeInfo.setPeriod(1);
//        timeInfo.setDate("2002");
//        TimeInfo newTimeInfo = timeInfo;
//        newTimeInfo.setPeriod(2);
//        System.out.println(timeInfo.getPeriod());
//        BigDecimal payDeductionAmount = BigDecimal.ZERO;
//        payDeductionAmount = payDeductionAmount.add(new BigDecimal(2));
//        System.out.println(payDeductionAmount);
//            try {
//                InetAddress ip4 = Inet4Address.getLocalHost();
//                System.out.println(ip4.getHostAddress());
//            } catch (UnknownHostException e) {
//                e.printStackTrace();
//            }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String outTime = "2022-08-17 23:59:23";
//        int minutes = 0;
//        try {
//            //minutes = df.parse(outTime).getMinutes();
//            df.parse(outTime).setMinutes(20);
//            Date nextHourTime = df.parse(outTime);
//            nextHourTime.setMinutes(30);
//            Calendar ca = Calendar.getInstance();
//            ca.setTime(df.parse(outTime));
//            ca.add(Calendar.HOUR,1);
//            ca.set(Calendar.MINUTE,0);
//            ca.set(Calendar.SECOND,0);
//            ca.set(Calendar.MILLISECOND,0);
//            System.out.println(df.format(ca.getTime()));
//            System.out.println(df.format(nextHourTime));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        System.out.println("123".substring(1));
//        MailDTO mailDTO = new MailDTO();
//        mailDTO.setSendMailAddress("wisonadmin@wison.com");
//        mailDTO.setSendPWD("Wison09*&");
//        mailDTO.setSubject("财务中台邮件提醒：支付申请【"+"1111111"+"】被驳回");
//        List<String> mailList = new ArrayList<>();
//        mailList.add("liguoming@wison.com");
//        mailDTO.setReceiverMailAddress(mailList);
//        String url = "https://fc.wison.com/fincenter/payment/PaymentPortal";
//        mailDTO.setText("李国明"+"，您好。<br />" +
//                "      您在财务中台提交的支付申请："+"111111"+"已经被驳回，请进入系统查看处理。<a href ='"+url+"'>点击进入</a><br /><br /><br />" +
//                "发送人：财务中台系统");
//        if(!MailUtils.sendEmail(mailDTO)) {
//            throw new RuntimeException("支付申请【"+"11111111"+"】驳回发送邮件失败");
//        }
//        ThreadDemo T1 = new ThreadDemo( "Thread-1");
//        T1.start();
//
//        ThreadDemo T2 = new ThreadDemo( "Thread-2");
//        T2.start();
//        List data = new ArrayList();
//        data.add("123");
//        data.add("999");
//        data.add("000");
//        Map map = new HashMap();
//        map.put("data", data);
//        if(map.size() > 0) {
//            if(data.size() > 0) {
//                throw new RuntimeException(map.get("data").toString());
//            }
//        }
//        TimeInfo timeInfo = new TimeInfo();
//        timeInfo.setDate("123");
//        timeInfo.setPeriod(1);
//        System.out.println(JSONObject.toJSONString(timeInfo));
//        updateAttendReport();
//        try {
//            long time = (df.parse("2022-09-28 07:42:09.000").getTime() - df.parse("2022-09-28 07:42:08.000").getTime())/1000;
//            System.out.println(time);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        JSONArray jsonArray = new JSONArray();
//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("scurrencycode","1");
//        jsonArray.add(jsonObject);
//        jsonObject = new JSONObject();
//        jsonObject.put("zone","2");
//        jsonArray.add(jsonObject);
//        jsonObject = new JSONObject();
//        jsonObject.put("accountCompany","3");
//        jsonArray.add(jsonObject);
//        jsonObject = new JSONObject();
//        jsonObject.put("projecttype", "4");
//        jsonArray.add(jsonObject);
//        System.out.println(jsonArray);
//        System.out.println(jsonArray.getJSONObject(0).get("scurrencycode"));
//        String js=JSONObject.toJSONString(jsonArray, SerializerFeature.WriteClassName);
//        List<JSONObject> list = JSONObject.parseArray(js,JSONObject.class);
//        Map map = new HashMap();
//        for(JSONObject jsonObject1 : list) {
//            for (Map.Entry<String, Object> entry : jsonObject1.entrySet()) {
//                map.put(entry.getKey(), entry.getValue());
//            }
//        }
//        System.out.println(map);

        SCProductServiceImpl.dataConditionOprate();
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
