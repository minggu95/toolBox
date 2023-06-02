package hunanOperate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.axis.utils.StringUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import util.HttpUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class HUNANaddDisDSLSelectrelation {
    static String cookies = "ASP.NET_SessionId=v1vlnyfzncnldbp5moyxv5a3; HNHC_SESSIONID=bBJlgu5SZxN4WPLGj7XAU82nGfnroR3JQ04P%2fbCuA1P5v%2bUY0CwpKNfzyUva0qGcdxmR7cSu27E%3d";
    //SID=FCD4CC9BDA59BBD7E0535415150A6ED0&Details=HJ4665,1*

    public static JSONObject fileToJson(String fileName) {
        JSONObject json = null;
        try (
                InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
        ) {
            json = JSONObject.parseObject(IOUtils.toString(is, "utf-8"));
        } catch (Exception e) {
            System.out.println(fileName + "文件读取异常" + e);
        }
        return json;
    }

    public static void addDisDSLSelectrelationOpreate() {
        Map<String, String> comMap = new HashMap();
        comMap.put("安仁县人民医院","HJ1857");
        comMap.put("慈利县人民医院","HJ1043");
        comMap.put("道县人民医院","HJ1857");
        comMap.put("东安县人民医院","HJ1857");
        comMap.put("桂阳县第一人民医院","HJ7341");
        comMap.put("衡阳县人民医院","HJ1857");
        comMap.put("洪江市人民医院","HJ7895");
        comMap.put("湖南省娄底市第二人民医院","HJ1857");
        comMap.put("嘉禾县人民医院","HJ7341");
        comMap.put("江华瑶族自治县人民医院","HJ1857");
        comMap.put("蓝山县人民医院","HJ1857");
        comMap.put("宁远县人民医院","HJ1857");
        comMap.put("通道侗族自治县第一人民医院","HJ1857");
        comMap.put("新田县人民医院","HJ1857");
        comMap.put("溆浦城南医院","HJ3730");
        comMap.put("溆浦县中医医院","HJ0009");
        String jsonFilePath = "E://guqainData//hunan.json";
        File file = new File(jsonFilePath );
        String input = null;
        try {
            input = FileUtils.readFileToString(file,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.parseObject(input);
        JSONArray jsonArray = jsonObject.getJSONArray("rows");
        Map<String, String> map = new HashMap<>();
        if(!jsonArray.isEmpty()) {
            JSONObject jsonObject1 = null;
            String company = "";
            for(Object object : jsonArray) {
                jsonObject1 = (JSONObject)object;
                if(jsonObject1.getString("DISCOUNT") == null && jsonObject1.getString("DISCOMCOUNT") == null) {
                    company = comMap.get(jsonObject1.getString("HOSNAME"));
                    if(!StringUtils.isEmpty(company)) {
                        map.put(jsonObject1.getString("SID"), company+","+jsonObject1.getString("CGL")+"*");
                    }
                }
            }
        }
        if(!map.isEmpty()) {
            Set<String> set = map.keySet();
            String url1 = "";
            String result = "";
            for (String sid : set) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                url1="https://jyjy.hnsggzy.com:6003/HSNN/CM/Trade/Web/Controller/ContractController/AddDisDSLSelectrelation.HSNN?"+"SID="+sid+"&Details="+map.get(sid);
                System.out.println(url1);
                result = HttpUtils.httpPost(url1,"", cookies);
                System.out.println(result);
            }
        }
    }
}
