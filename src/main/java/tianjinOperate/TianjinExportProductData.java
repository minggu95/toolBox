package tianjinOperate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.io.FileUtils;
import util.ExcelUtils;
import util.HttpUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TianjinExportProductData {

    static String cookies = "ASP.NET_SessionId=aeekmofyfxthygog0j2i5vu0; HBHC_SESSIONID=MEx5zqHOcMSTMHbhJA1mgpsw%2bVuXyghj7vRKbgB5sADBVOrWjlzE35Fd%2fLWtiC0K%2fdNBLCKju80%3d";

    public static JSONArray fileToJsonArray() {
        String jsonFilePath = "E://gq//tianjinCompany.json";
//        String jsonFilePath = "D://Desktop//qian//20230826tianjin//tianjinTemp.json";
        File file = new File(jsonFilePath );
        String input = null;
        try {
            input = FileUtils.readFileToString(file,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = JSONArray.parseArray(input);
        JSONArray jsonArray1 = new JSONArray();
        Map<String, String> map = new HashMap<>();
        if(!jsonArray.isEmpty()) {
            for(Object object : jsonArray) {
                JSONObject jsonObject = (JSONObject)object;
                JSONObject jsonObject1 = new JSONObject();
                jsonObject1.put("CLASSIFYID",jsonObject.getString("CLASSIFYID"));
                jsonObject1.put("BATCHID",jsonObject.getString("BATCHID"));
                jsonObject1.put("OLDBIDPRICE",jsonObject.getString("OLDBIDPRICE"));
                jsonObject1.put("INFACTPOSTIONNAME",jsonObject.getString("INFACTPOSTIONNAME"));
                jsonArray1.add(jsonObject1);
            }
        }
        return jsonArray1;
    }

    /**
     * 查询并导出表1
     */
    public static void exportData1() {
        JSONArray jsonArray = fileToJsonArray();
        if(jsonArray != null && !jsonArray.isEmpty()) {
            JSONArray jsonArrayData = new JSONArray();
            JSONObject jsonObject;
            String result = "";
            JSONArray jsonArrayTemp;
            for (Object object : jsonArray) {
                jsonObject = (JSONObject) object;
                String referer = "https://hc.tjmpc.cn:17058/Pages/3N_GPARTDSL/ProductBJ.aspx?CLASSIFYID="+jsonObject.getString("CLASSIFYID")+"&BATCHID=xzjrdsl1";
                String url1="https://hc.tjmpc.cn:17058/HSNN/CM/BaseDB/Web/Controller/Product3NController/N3BJ_ProductInfoNeedAllList.HSNN?BATCHID=xzjrdsl1&CLASSIFYID="+jsonObject.getString("CLASSIFYID")+"&REGCARDNM=&MODELVALUE=&SPECVALUE=&REGCARDNM02=&ALLIANCENAME=&PRICE=";
//                String url1="https://hc.tjmpc.cn:17058/HSNN/CM/BaseDB/Web/Controller/Product3NController/N3BJ_ProductInfoNeedAllList.HSNN?BATCHID=xzjrdsl1&CLASSIFYID=17_9&REGCARDNM=&MODELVALUE=&SPECVALUE=&REGCARDNM02=&ALLIANCENAME=&PRICE=";
                System.out.println(url1);
                NameValuePair[] data = {
                        new NameValuePair()
                };
                result = HttpUtils.dopost(url1,data, cookies, referer);
                if(result != null && !"".equals(result)) {
                    jsonArrayTemp = JSONArray.parseArray(result);
                    //添加旧中标价格
                    if(!jsonArrayTemp.isEmpty()) {
                        for(Object objectTemp : jsonArrayTemp) {
                            JSONObject jsonObject1 = (JSONObject) objectTemp;
                            jsonObject1.put("OLDBIDPRICE",jsonObject.getString("OLDBIDPRICE"));
                            jsonObject1.put("INFACTPOSTIONNAME",jsonObject.getString("INFACTPOSTIONNAME"));
                        }
                    }
                    jsonArrayData.addAll(jsonArrayTemp);
                }
            }
            //导出所有产品表1数据
            ExcelUtils.JsonArrayToExcelData1(jsonArrayData, "data1");
        }
    }

    /**
     * 查询并导出表2
     */
    public static void exportData2() {
        JSONArray jsonArray = fileToJsonArray();
        if(jsonArray != null && !jsonArray.isEmpty()) {
            JSONArray jsonArrayData = new JSONArray();
            JSONObject jsonObject;
            String result = "";
            JSONArray jsonArrayTemp;
            for (Object object : jsonArray) {
                jsonObject = (JSONObject) object;
                String referer = "https://hc.tjmpc.cn:17058/Pages/3N_GPARTDSL/ProductBJ.aspx?CLASSIFYID="+jsonObject.getString("CLASSIFYID")+"&BATCHID=xzjrdsl1";
                String url1="https://hc.tjmpc.cn:17058/HSNN/CM/BaseDB/Web/Controller/Product3NController/N3BJ_ProductInfoAlreadyBJList.HSNN?BATCHID=xzjrdsl1&CLASSIFYID="+jsonObject.getString("CLASSIFYID")+"&REGCARDNM=&MODELVALUE=&SPECVALUE=&REGCARDNM02=&ALLIANCENAME=&PRICE=";
                System.out.println(url1);
                NameValuePair[] data = {
                        new NameValuePair("page", "1"),
                        new NameValuePair("rows", "1000")
                };
                result = HttpUtils.dopost(url1,data, cookies, referer);
                if(result != null && !"".equals(result)) {
                    jsonArrayTemp = JSONArray.parseArray(JSONObject.parseObject(result).getString("rows"));
                    //添加旧中标价格
                    if(!jsonArrayTemp.isEmpty()) {
                        for(Object objectTemp : jsonArrayTemp) {
                            JSONObject jsonObject1 = (JSONObject) objectTemp;
                            jsonObject1.put("INFACTPOSTIONNAME",jsonObject.getString("INFACTPOSTIONNAME"));
                        }
                    }
                    jsonArrayData.addAll(jsonArrayTemp);
                }
            }
            //导出所有产品表1数据
            ExcelUtils.JsonArrayToExcelData2(jsonArrayData, "data2");
        }
    }
}
