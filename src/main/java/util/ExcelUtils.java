package util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtils {

    /**
     * 天津数据表1
     * @param jsonArray
     * @return
     */
    public static boolean JsonArrayToExcelData1(JSONArray jsonArray, String name) {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("Sheet1");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("注册证号");
        cell = row.createCell(1);
        cell.setCellValue("旧注册证号");
        cell = row.createCell(2);
        cell.setCellValue("产品名称");
        cell = row.createCell(3);
        cell.setCellValue("材质");
        cell = row.createCell(4);
        cell.setCellValue("特征");
        cell = row.createCell(5);
        cell.setCellValue("国家医保编码");
        cell = row.createCell(6);
        cell.setCellValue("型号");
        cell = row.createCell(7);
        cell.setCellValue("规格");
        cell = row.createCell(8);
        cell.setCellValue("申报企业名称");
        cell = row.createCell(9);
        cell.setCellValue("联盟/省级");
        cell = row.createCell(10);
        cell.setCellValue("曾中选价格");
        cell = row.createCell(11);
        cell.setCellValue("采购单元");
        cell = row.createCell(12);
        cell.setCellValue("部件名称");

        if(jsonArray != null && !jsonArray.isEmpty()) {
            for(int i=0;i<jsonArray.size();i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                row = sheet.createRow(i+1);
                cell = row.createCell(0);
                cell.setCellValue(obj.getString("REGCARDNM"));
                cell = row.createCell(1);
                cell.setCellValue("");
                cell = row.createCell(2);
                cell.setCellValue(obj.getString("GPARTNAME"));
                cell = row.createCell(3);
                cell.setCellValue("");
                cell = row.createCell(4);
                cell.setCellValue(obj.getString("SPECSREAL"));
                cell = row.createCell(5);
                cell.setCellValue(obj.getString("GJYBBM"));
                cell = row.createCell(6);
                cell.setCellValue(obj.getString("MODELVALUE"));
                cell = row.createCell(7);
                cell.setCellValue("");
                cell = row.createCell(8);
                cell.setCellValue(obj.getString("COMNAME_SB"));
                cell = row.createCell(9);
                cell.setCellValue("");
                cell = row.createCell(10);
                if(obj.get("OLDBIDPRICE") != null) {
                    cell.setCellValue(obj.getString("OLDBIDPRICE"));
                } else {
                    cell.setCellValue(obj.getString("PRICE"));
                }
                cell = row.createCell(11);
                cell.setCellValue(obj.getString("SPECS"));
                cell = row.createCell(12);
                cell.setCellValue(obj.getString("INFACTPOSTIONNAME"));
            }
        }
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream("E:\\gq\\"+name+".xls");
            wb.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * 天津数据表2
     * @param jsonArray
     * @return
     */
    public static boolean JsonArrayToExcelData2(JSONArray jsonArray, String name) {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("Sheet1");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("目录ID");
        cell = row.createCell(1);
        cell.setCellValue("采购单元");
        cell = row.createCell(2);
        cell.setCellValue("产品名称");
        cell = row.createCell(3);
        cell.setCellValue("注册证号");
        cell = row.createCell(4);
        cell.setCellValue("旧注册证号");
        cell = row.createCell(5);
        cell.setCellValue("生产企业名称");
        cell = row.createCell(6);
        cell.setCellValue("申报企业");
        cell = row.createCell(7);
        cell.setCellValue("国家医保编码");
        cell = row.createCell(8);
        cell.setCellValue("型号");
        cell = row.createCell(9);
        cell.setCellValue("规格");
        cell = row.createCell(10);
        cell.setCellValue("报价");
        cell = row.createCell(11);
        cell.setCellValue("联盟或省级");
        cell = row.createCell(12);
        cell.setCellValue("部件名称");

        if(jsonArray != null && !jsonArray.isEmpty()) {
            for(int i=0;i<jsonArray.size();i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                row = sheet.createRow(i+1);
                cell = row.createCell(0);
                cell.setCellValue(obj.getString("CATALOGUEID"));
                cell = row.createCell(1);
                cell.setCellValue(obj.getString("SPECS"));
                cell = row.createCell(2);
                cell.setCellValue(obj.getString("GPARTNAME"));
                cell = row.createCell(3);
                cell.setCellValue(obj.getString("REGCARDNM"));
                cell = row.createCell(4);
                cell.setCellValue(obj.getString("OLDREGCARDNM"));
                cell = row.createCell(5);
                cell.setCellValue(obj.getString("COMNAME_SC"));
                cell = row.createCell(6);
                cell.setCellValue(obj.getString("COMNAME_SB"));
                cell = row.createCell(7);
                cell.setCellValue(obj.getString("GJYBBM"));
                cell = row.createCell(8);
                cell.setCellValue(obj.getString("MODELVALUE"));
                cell = row.createCell(9);
                cell.setCellValue(obj.getString("SPECVALUE"));
                cell = row.createCell(10);
                cell.setCellValue(obj.getString("PRICE"));
                cell = row.createCell(11);
                cell.setCellValue("");
                cell = row.createCell(12);
                cell.setCellValue(obj.getString("INFACTPOSTIONNAME"));
            }
        }
        FileOutputStream fileOut = null;
        try {
            fileOut = new FileOutputStream("D:\\Desktop\\qian\\20230826tianjin\\"+name+".xls");
            wb.write(fileOut);
            fileOut.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
