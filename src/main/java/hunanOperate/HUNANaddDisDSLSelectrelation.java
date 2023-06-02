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
            System.out.println(fileName + "�ļ���ȡ�쳣" + e);
        }
        return json;
    }

    public static void addDisDSLSelectrelationOpreate() {
        Map<String, String> comMap = new HashMap();
        comMap.put("����������ҽԺ","HJ1857");
        comMap.put("����������ҽԺ","HJ1043");
        comMap.put("��������ҽԺ","HJ1857");
        comMap.put("����������ҽԺ","HJ1857");
        comMap.put("�����ص�һ����ҽԺ","HJ7341");
        comMap.put("����������ҽԺ","HJ1857");
        comMap.put("�齭������ҽԺ","HJ7895");
        comMap.put("����ʡ¦���еڶ�����ҽԺ","HJ1857");
        comMap.put("�κ�������ҽԺ","HJ7341");
        comMap.put("������������������ҽԺ","HJ1857");
        comMap.put("��ɽ������ҽԺ","HJ1857");
        comMap.put("��Զ������ҽԺ","HJ1857");
        comMap.put("ͨ�����������ص�һ����ҽԺ","HJ1857");
        comMap.put("����������ҽԺ","HJ1857");
        comMap.put("���ֳ���ҽԺ","HJ3730");
        comMap.put("��������ҽҽԺ","HJ0009");
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
