package henanOpreate;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.httpclient.NameValuePair;
import util.HttpUtils;

import java.util.*;

public class HNProductServiceImpl {

    static String getHospitalUrl = "http://ypnew.hnggzyjy.cn:9080/hctrade/suppurDistributionRelation/getHospitalList.html";
    static String getCompanyUrl = "http://ypnew.hnggzyjy.cn:9080/hctrade/suppurDistributionRelation/getCompanyList.html?";
    static String addUrl = "http://ypnew.hnggzyjy.cn:9080/hctrade/suppurDistributionRelation/addDistributionRelationDl.html";
    static String cookies = "isCrossRegion=10022; queryCondition=; SESSION=a7c5e76e-0c32-4921-a870-4053376b6561; JSESSIONID=8BDF07CB97AFB3EC92C9D0C31BBFB0D4";

    public static List<String> getParam(String type, Map<String, String> names) {
        List<String> list = new ArrayList<>();
        String result = "";
        JSONObject jsonObject = null;
        for(String temp:names.keySet()){
            String value = names.get(temp);
            result = "";
            //医院
            NameValuePair[] hospital = {
                    new NameValuePair("hospitalName", temp)
            };
            String hospitalResult = HttpUtils.dopost(getHospitalUrl, hospital, cookies);
            JSONObject hospitalJsonObject = JSONObject.parseObject(hospitalResult);
            JSONObject tempJsonObject = (JSONObject)hospitalJsonObject.getJSONArray("rows").get(0);
            result = result+temp+","+tempJsonObject.getString("hospitalId");

            //公司
            NameValuePair[] data = {
                    new NameValuePair("companyName", value)
            };
            String companyresult = HttpUtils.dopost(getCompanyUrl, data, cookies);
            JSONObject companyjsonObject = JSONObject.parseObject(companyresult);
            JSONObject comjsonObject = (JSONObject)companyjsonObject.getJSONArray("rows").get(0);
            result = result+","+value+","+comjsonObject.getString("companyId");

            list.add(result);
        }
        return list;
    }

    public static List<String> getParamByCode(String type, Map<String, String> names) {
        List<String> list = new ArrayList<>();
        String result = "";
        JSONObject jsonObject = null;
        for(String temp:names.keySet()){
            String value = names.get(temp);
            result = "";
            //医院
            NameValuePair[] hospital = {
                    new NameValuePair("hospitalCode", temp)
            };
            String hospitalResult = HttpUtils.dopost(getHospitalUrl, hospital, cookies);
            JSONObject hospitalJsonObject = JSONObject.parseObject(hospitalResult);
            JSONObject tempJsonObject = (JSONObject)hospitalJsonObject.getJSONArray("rows").get(0);
            result = result+tempJsonObject.getString("hospitalName")+","+temp;

            //公司
            NameValuePair[] data = {
                    new NameValuePair("companyName", value)
            };
            String companyresult = HttpUtils.dopost(getCompanyUrl, data, cookies);
            JSONObject companyjsonObject = JSONObject.parseObject(companyresult);
            JSONObject comjsonObject = (JSONObject)companyjsonObject.getJSONArray("rows").get(0);
            result = result+","+value+","+comjsonObject.getString("companyId");

            list.add(result);
        }
        return list;
    }

    public static boolean addSend(List<String> param) {
        Map<String, String> map = new HashMap();
        //procurecatalogId,goodsId
        map.put("1006729","1016023");//1
        map.put("1006730","1016040");//2
        map.put("1006731","1016041");//3
        map.put("1006732","1016042");//4
        map.put("1006733","1016043");//5
        map.put("1006737","1016024");//6
        map.put("1006738","1015872");//7
        map.put("1006739","1016026");//8
        map.put("1006742","1015851");//9
        map.put("1006743","1015924");//10
        map.put("1006744","1015865");//11
        map.put("1006747","1015915");//12
        map.put("1006748","1015955");//13
        map.put("1006749","1015956");//14
        map.put("1006750","1015957");//15
        map.put("1006751","1015958");//16
        map.put("1006752","1015959");//17
        map.put("1006753","1015824");//18
        map.put("1006754","1015873");//19
        map.put("1006755","1015874");//20
        map.put("1006756","1015923");//21
        map.put("1006757","1015925");//22
        map.put("1006758","1015837");//23
        map.put("1006759","1015825");//24
        map.put("1006760","1016025");//25
        map.put("1006769","1015982");//26
        map.put("1006770","1016007");//27
        map.put("1006771","1016008");//28
        map.put("1006772","1015870");//29
        map.put("1006773","1015871");//30
        map.put("1006774","1015906");//31
        map.put("1006775","1015907");//32
        map.put("1006971","1016068");//33
//        map.put("1006972","1016056");//34
//        map.put("1006973","1016059");//35
//        map.put("1006974","1016046");//36
//        map.put("1006975","1016047");//37
//        map.put("1006976","1016071");//38
//        map.put("1006977","1016044");//39
//        map.put("1006978","1016045");//40
        for(int i=0; i<param.size(); i++) {
            for(String temp:map.keySet()) {
                String value = map.get(temp);
                String[] arr = param.get(i).split(",");
                NameValuePair[] data = {
                        new NameValuePair("companyIds", arr[3]),
                        new NameValuePair("companyNames", arr[2]),
                        new NameValuePair("procurecatalogId", temp),
                        new NameValuePair("goodsId", value),
                        new NameValuePair("hospitalIds[]", arr[1]),
                        new NameValuePair("hospitalNames[]", arr[0])
                };
                String result = HttpUtils.dopost(addUrl, data, cookies);
            }
        }
        return true;
    }

    /**
     * Map<String,String> params = new HashMap<>();
     * params.put("平顶山市第二人民医院","河南安澜医疗器械销售有限公司");
     * params.put("平顶山市第一人民医院","华润秉诚（河南）医疗器械有限公司");
     * params.put("长垣县人民医院","河南润墨科技有限公司");
     * params.put("驻马店市中医院","河南曼斯特医疗器械有限公司");
     * params.put("安阳市中医院","河南山水供应链管理服务有限公司");
     * params.put("邓州市中心医院","河南瑞星瀚瑜商贸有限公司");
     * params.put("巩义市人民医院","国药集团河南省医疗器械有限公司");
     * params.put("河南大学第一附属医院","国药器械开封医疗器械有限公司");
     * params.put("鹤壁市人民医院","上海鹤弘供应链管理有限公司");
     * params.put("滑县人民医院","河南罗良商贸有限公司");
     * params.put("辉县市人民医院","河南祥诺医疗器械有限公司");
     * params.put("郏县人民医院","国药集团平顶山医疗器械有限公司");
     * params.put("焦作市人民医院","焦作市乐沣医学科技服务有限公司");
     * params.put("浚县人民医院","鹤壁惠泠医疗器械有限公司");
     * params.put("林州市中医院","上海清斯贸易商行");
     * params.put("漯河市第六人民医院","华润秉诚（河南）医疗器械有限公司");
     * params.put("漯河市中心医院","华润秉诚（河南）医疗器械有限公司");
     * params.put("泌阳县人民医院","河南维诺思医疗供应链管理有限公司");
     * params.put("渑池县人民医院","河南然炫贸易有限公司");
     * params.put("宁陵县人民医院","河南鼎远医疗器械销售有限公司");
     * params.put("濮阳市安阳地区医院","河南山水供应链管理服务有限公司");
     * params.put("杞县中医院","河南子非医疗科技有限公司");
     * params.put("社旗县人民医院","江西亿永骏医疗器械有限公司");
     * params.put("太康县中医院","河南鼎远医疗器械销售有限公司");
     * params.put("息县中心医院","河南君泽医疗器械有限公司");
     * params.put("淅川县人民医院","江西亿永骏医疗器械有限公司");
     * params.put("新密市中医院","河南天勤医疗器械有限公司");
     * params.put("新野县人民医院","江西亿永骏医疗器械有限公司");
     * params.put("信阳市人民医院","山南市启尚医疗器械供应链有限公司");
     * params.put("镇平县第二人民医院","河南沃景商贸有限公司");
     * params.put("焦作煤业（集团）有限责任公司中央医院","焦作市乐沣医学科技服务有限公司");
     * params.put("黄河三门峡医院","河南省国控医疗管理集团有限公司");
     * params.put("南阳市第二人民医院","郑州市讯诺医疗器械有限责任公司");
     * params.put("沁阳市人民医院","国药集团河南省医疗器械有限公司");
     * params.put("郸城县第二人民医院","国药集团河南省医疗器械有限公司");
     * params.put("新乡医学院第一附属医院","河南东沽医疗设备有限公司");
     * List<String> list = HNProductServiceImpl.getParam("", params);
     * HNProductServiceImpl.addSend(list);
     * Map<String,String> codeparams = new HashMap<>();
     * codeparams.put("HCY0736","河南富卓佰扬科技有限公司");
     * codeparams.put("HCY0748","山南市源畅医疗器械有限公司");
     * codeparams.put("HCY0744","河南仁医德医疗设备有限公司");
     * codeparams.put("HCY0363","国药集团平顶山医疗器械有限公司");
     * codeparams.put("HCY0311","郑州市讯诺医疗器械有限责任公司");
     * codeparams.put("HCY0375","河南琼琚科贸有限公司");
     * codeparams.put("HCY0740","河南泽邦医疗器械有限公司");
     * codeparams.put("HCY0512","国药控股河南医疗器械有限公司");
     * codeparams.put("HCY0725","河南天勤医疗器械有限公司");
     * codeparams.put("HCY0555","华润秉诚（河南）医疗器械有限公司");
     * List<String> codelist = HNProductServiceImpl.getParamByCode("", codeparams);
     * HNProductServiceImpl.addSend(codelist);
     */
}
