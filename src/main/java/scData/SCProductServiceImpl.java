package scData;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.NameValuePair;
import util.HttpUtils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @Program testDemo
 * @ClassName SCProductServiceImpl
 * @Description SCProductServiceImpl
 * @Author liguoming
 * @Date 2022-11-17 16:55
 * @Version 1.0
 **/
public class SCProductServiceImpl {

    //获取四川产品url地址
    static String productUrl1 = "https://www.scyxzbcg.cn/hcstd/publicity/getPublicityUpdatePrice.html?publicityBatch=cOOCD8/CXRnzBNPDkpC59nLGLXlia5NIErQt2WIkH8Zf77duc2z1%2Bg==&updateType=1";
    static String productUrl2 = "https://www.scyxzbcg.cn/hcstd/publicity/getPublicityUpdatePrice.html?publicityBatch=cOOCD8/CXRnzBNPDkpC59nLGLXlia5NIErQt2WIkH8Zf77duc2z1%2Bg==&updateType=2";
    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public static void getSCProductInfoToExcel(List<String> list, String url, String[] names) {
        try {
            String tempFileDir = "D:/四川数据/";
            File parentFileDir = new File(tempFileDir);
            if (!parentFileDir.exists()) {
                parentFileDir.mkdirs();
            }
            int num = (int)(Math.random()*100);
            String uploadFile = tempFileDir+df.format(new Date())+"-"+num+"四川数据.xlsx";
            OutputStream fos = new FileOutputStream(uploadFile);
            XSSFWorkbook workBook = new XSSFWorkbook();
            if(list != null && !list.isEmpty()) {
                for(int i=0; i<list.size(); i++) {
                    //获取网络接口数据
                    //临时获取页数
                    JSONArray jsonArray = new JSONArray();
                    JSONObject jsonObject = getData(url, list.get(i), 1);
                    if(jsonObject.getInteger("code") == 0) {
                        //循环多页
                        if(jsonObject.getInteger("total") > 0) {
                            for(int m = 1; m<=jsonObject.getInteger("total"); m++) {
                                jsonObject = getData(url, list.get(i), m);
                                if(jsonObject.getInteger("code") == 0) {
                                    jsonArray.addAll(jsonObject.getJSONArray("rows"));
                                }
                            }
                        }
                    } else {
                        throw new RuntimeException("调用接口失败："+jsonObject.getString("msg"));
                    }
                    //数据插入excel
                    if(jsonArray.size() > 0) {
                        XSSFSheet sheet = workBook.createSheet(list.get(i));
                        XSSFRow row = null;
                        XSSFCell cell = null;
                        row = sheet.createRow(0);
                        for (int index = 0; index < names.length; index++) {
                            cell = row.createCell(index);
                            cell.setCellValue(names[index]);
                        }
                        //表数据
                        for (int j = 0; j < jsonArray.size(); j++) {
                            JSONObject json = jsonArray.getJSONObject(j);
                            row = sheet.createRow(j+1);//创建行
                            cell = row.createCell(0);//序号
                            cell.setCellValue(j+1);

                            cell = row.createCell(1);//内容
                            cell.setCellValue(json.getString("procurecatalogId"));

                            cell = row.createCell(2);
                            cell.setCellValue(json.getString("oldGoodsId"));

                            cell = row.createCell(3);
                            cell.setCellValue(json.getString("regCerno"));

                            cell = row.createCell(4);
                            cell.setCellValue(json.getString("regCername"));

                            cell = row.createCell(5);
                            cell.setCellValue(json.getString("productName"));

                            cell = row.createCell(6);
                            cell.setCellValue(json.getString("outLookc"));

                            cell = row.createCell(7);
                            cell.setCellValue(json.getString("model"));

                            cell = row.createCell(8);
                            cell.setCellValue(json.getString("companyNameTb"));

                            cell = row.createCell(9);
                            cell.setCellValue(json.getString("companyNameSc"));

                            cell = row.createCell(10);
                            if(json.getInteger("purchaseType") == 0) {
                                cell.setCellValue("价格联动专区");
                            } else if(json.getInteger("purchaseType") == 1) {
                                cell.setCellValue("带量专区");
                            } else if(json.getInteger("purchaseType") == 3) {
                                cell.setCellValue("备案专区");
                            }

                            cell = row.createCell(11);
                            if(!"".equals(json.getString("afterFacownPrice")) && json.getString("afterFacownPrice") != null) {
                                cell.setCellValue(json.getString("afterFacownPrice"));
                            } else {
                                cell.setCellValue("暂未更新");
                            }

                            cell = row.createCell(12);
                            if(json.getBoolean("thisUpdate")) {
                                cell.setCellValue("否");
                            } else {
                                cell.setCellValue("是");
                            }

                            cell = row.createCell(13);
                            cell.setCellValue(json.getString("beforeFacownPrice"));

                            cell = row.createCell(14);
                            if(!"".equals(json.getString("afterFacownPrice")) && json.getString("afterFacownPrice") != null) {
                                cell.setCellValue(json.getString("afterFacownPrice"));
                            } else {
                                cell.setCellValue("暂未更新");
                            }
                        }
                    }
                }
                workBook.write(fos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //调用接口获取数据
    public static JSONObject getData(String url,String companyName, int page) {
        NameValuePair[] data = {
                new NameValuePair("companyNameTb",companyName),
                new NameValuePair("page",page+""),
                new NameValuePair("rows","100")
        };
        String result = HttpUtils.dopost(url, data);
        return JSONObject.parseObject(result);
    }

    public static void dataConditionOprate() {
        //公司
        List<String> list = new ArrayList();
        list.add("强生");
        list.add("雅培");
        list.add("波科");
        list.add("美敦力");
        list.add("惠泰");
        list.add("心诺普");
        list.add("微创电生理");
        list.add("锦江");
        list.add("上海普实");
        list.add("威海维心");
        list.add("百多力");
        list.add("四川锦江");
        list.add("科塞尔");
        list.add("北京美中双和");
        list.add("乐普");
        //表头1
        String[] names1 = { "序号", "商品代码", "老平台四川流水号" , "注册备案号", "注册备案产品名称"
                ,"单件产品名称","规格","型号","申报企业","生产企业"
                ,"申报类型","拟更新联动参考价","是否本次更新","更新前最低外省价","更新后最低外省价"};
        //表头2
        String[] names2 = { "序号", "商品代码", "老平台四川流水号" , "注册备案号", "注册备案产品名称"
                ,"单件产品名称","规格","型号","申报企业","生产企业"
                ,"申报类型","拟更新我省最高参考价/我省参考价","是否本次更新","更新前最低外省价","更新后最低外省价"};
        getSCProductInfoToExcel(list, productUrl1, names1);
    }
}
