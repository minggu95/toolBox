package ModeDataWebservice.testmain;


import ModeDataWebservice.webservicesProd.ModeDateService;
import ModeDataWebservice.webservicesProd.ModeDateServicePortType;


import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;
import org.json.XML;

public class CallModeDataSerivce {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CallModeDataSerivce c = new CallModeDataSerivce();
		c.getAllModeDataList();
	}

	public void getAllModeDataList(){
		ModeDateService modeDateService = null;
		try {
			modeDateService = new ModeDateService(new URL("https://fwtest.wison.com//services/ModeDateService?wsdl"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		ModeDateServicePortType client= modeDateService.getModeDateServiceHttpPort();
		/*
		 *
		@param modeId 表单ID
		@param pageNo 当前页数
		@param pageSize 每页记录数
		@param recordCount 记录总数（小于等于0时自动计算记录总数）
		@param userid 当前用户
		@param conditions 查询条件
		@param right （y/n） 是否受权限控制
		@param isReturnDetail （y/n） 是否返回明细表数据
		 */
		String modeData = "<ROOT><header><userid>801</userid><modeid>821</modeid><id /></header><search><condition /><right>n</right></search><data id=\"1022\"><handlers><modedatacreater>6068</modedatacreater><modedatacreatershow>张筱伊</modedatacreatershow><modedatacreatedate>2019-01-02</modedatacreatedate><modedatacreatetime>13:47:30</modedatacreatetime></handlers><maintable><field><filedname>displayOrder</filedname><filedlabel>显示顺序</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>filaName</filedname><filedlabel>文件名称</filedlabel><fileddbtype>varchar2(300)</fileddbtype><filedvalue>项目质量计划管理规定</filedvalue><fieldshowname>项目质量计划管理规定</fieldshowname></field><field><filedname>fileCode</filedname><filedlabel>文件编号</filedlabel><fileddbtype>varchar2(50)</fileddbtype><filedvalue>WOM-MS/MP-3QM-002</filedvalue><fieldshowname>WOM-MS/MP-3QM-002</fieldshowname></field><field><filedname>fileState</filedname><filedlabel>文件状态</filedlabel><fileddbtype>integer</fileddbtype><filedvalue>1</filedvalue><fieldshowname>修订</fieldshowname></field><field><filedname>fileType</filedname><filedlabel>文件类型</filedlabel><fileddbtype>integer</fileddbtype><filedvalue>2</filedvalue><fieldshowname>管理文件</fieldshowname></field><field><filedname>signDeps</filedname><filedlabel>会签部门</filedlabel><fileddbtype>varchar2(4000)</fileddbtype><filedvalue /><fieldshowname /></field><files><filedname>attachment</filedname><filedlabel>附件</filedlabel><fileddbtype>varchar2(4000)</fileddbtype><filedvalue>7680</filedvalue><file><filename>MP-3QM-002 Rev. A1项目质量计划管理规定Project？Quality？Plan？Regulations.pdf</filename><filecontent>/weaver/weaver.file.FileDownload?fileid=9471</filecontent><filecontenttype>http</filecontenttype></file><fieldshowname>7680</fieldshowname></files><field><filedname>applicant</filedname><filedlabel>申请人</filedlabel><fileddbtype>integer</fileddbtype><filedvalue>5086</filedvalue><fieldshowname>陆正兴</fieldshowname></field><field><filedname>nowVer</filedname><filedlabel>当前版本</filedlabel><fileddbtype>varchar2(50)</fileddbtype><filedvalue>A1</filedvalue><fieldshowname>A1</fieldshowname></field><field><filedname>applyDep</filedname><filedlabel>申请部门</filedlabel><fileddbtype>integer</fileddbtype><filedvalue>557</filedvalue><fieldshowname>质量部</fieldshowname></field><field><filedname>applyCom</filedname><filedlabel>申请公司</filedlabel><fileddbtype>int</fileddbtype><filedvalue>61</filedvalue><fieldshowname>惠生（南通）重工有限公司</fieldshowname></field></maintable></data><data id=\"1023\"><handlers><modedatacreater>6068</modedatacreater><modedatacreatershow>张筱伊</modedatacreatershow><modedatacreatedate>2019-01-02</modedatacreatedate><modedatacreatetime>13:47:30</modedatacreatetime></handlers><maintable><field><filedname>displayOrder</filedname><filedlabel>显示顺序</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>filaName</filedname><filedlabel>文件名称</filedlabel><fileddbtype>varchar2(300)</fileddbtype><filedvalue>项目营销合同变更控制程序</filedvalue><fieldshowname>项目营销合同变更控制程序</fieldshowname></field><field><filedname>fileCode</filedname><filedlabel>文件编号</filedlabel><fileddbtype>varchar2(50)</fileddbtype><filedvalue>WOM-MS/MP-3PM-030</filedvalue><fieldshowname>WOM-MS/MP-3PM-030</fieldshowname></field><field><filedname>fileState</filedname><filedlabel>文件状态</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>fileType</filedname><filedlabel>文件类型</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>signDeps</filedname><filedlabel>会签部门</filedlabel><fileddbtype>varchar2(4000)</fileddbtype><filedvalue /><fieldshowname /></field><files><filedname>attachment</filedname><filedlabel>附件</filedlabel><fileddbtype>varchar2(4000)</fileddbtype><filedvalue /><file><filename /><filecontent /><filecontenttype /></file><fieldshowname /></files><field><filedname>applicant</filedname><filedlabel>申请人</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>nowVer</filedname><filedlabel>当前版本</filedlabel><fileddbtype>varchar2(50)</fileddbtype><filedvalue>A0</filedvalue><fieldshowname>A0</fieldshowname></field><field><filedname>applyDep</filedname><filedlabel>申请部门</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>applyCom</filedname><filedlabel>申请公司</filedlabel><fileddbtype>int</fileddbtype><filedvalue /><fieldshowname /></field></maintable></data><data id=\"1024\"><handlers><modedatacreater>6068</modedatacreater><modedatacreatershow>张筱伊</modedatacreatershow><modedatacreatedate>2019-01-02</modedatacreatedate><modedatacreatetime>13:47:30</modedatacreatetime></handlers><maintable><field><filedname>displayOrder</filedname><filedlabel>显示顺序</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>filaName</filedname><filedlabel>文件名称</filedlabel><fileddbtype>varchar2(300)</fileddbtype><filedvalue>预处理检验作业标准（通用）</filedvalue><fieldshowname>预处理检验作业标准（通用）</fieldshowname></field><field><filedname>fileCode</filedname><filedlabel>文件编号</filedlabel><fileddbtype>varchar2(50)</fileddbtype><filedvalue>WOM-MS/TI-4QM-G-019</filedvalue><fieldshowname>WOM-MS/TI-4QM-G-019</fieldshowname></field><field><filedname>fileState</filedname><filedlabel>文件状态</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>fileType</filedname><filedlabel>文件类型</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>signDeps</filedname><filedlabel>会签部门</filedlabel><fileddbtype>varchar2(4000)</fileddbtype><filedvalue /><fieldshowname /></field><files><filedname>attachment</filedname><filedlabel>附件</filedlabel><fileddbtype>varchar2(4000)</fileddbtype><filedvalue /><file><filename /><filecontent /><filecontenttype /></file><fieldshowname /></files><field><filedname>applicant</filedname><filedlabel>申请人</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>nowVer</filedname><filedlabel>当前版本</filedlabel><fileddbtype>varchar2(50)</fileddbtype><filedvalue>A0</filedvalue><fieldshowname>A0</fieldshowname></field><field><filedname>applyDep</filedname><filedlabel>申请部门</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>applyCom</filedname><filedlabel>申请公司</filedlabel><fileddbtype>int</fileddbtype><filedvalue /><fieldshowname /></field></maintable></data><data id=\"1025\"><handlers><modedatacreater>6068</modedatacreater><modedatacreatershow>张筱伊</modedatacreatershow><modedatacreatedate>2019-01-02</modedatacreatedate><modedatacreatetime>13:47:30</modedatacreatetime></handlers><maintable><field><filedname>displayOrder</filedname><filedlabel>显示顺序</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>filaName</filedname><filedlabel>文件名称</filedlabel><fileddbtype>varchar2(300)</fileddbtype><filedvalue>恒温恒湿材料管理规定</filedvalue><fieldshowname>恒温恒湿材料管理规定</fieldshowname></field><field><filedname>fileCode</filedname><filedlabel>文件编号</filedlabel><fileddbtype>varchar2(50)</fileddbtype><filedvalue>WOM-MS/MF-3WH-009</filedvalue><fieldshowname>WOM-MS/MF-3WH-009</fieldshowname></field><field><filedname>fileState</filedname><filedlabel>文件状态</filedlabel><fileddbtype>integer</fileddbtype><filedvalue>1</filedvalue><fieldshowname>修订</fieldshowname></field><field><filedname>fileType</filedname><filedlabel>文件类型</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>signDeps</filedname><filedlabel>会签部门</filedlabel><fileddbtype>varchar2(4000)</fileddbtype><filedvalue /><fieldshowname /></field><files><filedname>attachment</filedname><filedlabel>附件</filedlabel><fileddbtype>varchar2(4000)</fileddbtype><filedvalue>9981</filedvalue><file><filename>MF-3WH-009 Rev.A1 恒温恒湿材料管理规定Regulations on Management of Air Condition Materials.doc</filename><filecontent>/weaver/weaver.file.FileDownload?fileid=12055</filecontent><filecontenttype>http</filecontenttype></file><fieldshowname>9981</fieldshowname></files><field><filedname>applicant</filedname><filedlabel>申请人</filedlabel><fileddbtype>integer</fileddbtype><filedvalue>4239</filedvalue><fieldshowname>成红华</fieldshowname></field><field><filedname>nowVer</filedname><filedlabel>当前版本</filedlabel><fileddbtype>varchar2(50)</fileddbtype><filedvalue>A1</filedvalue><fieldshowname>A1</fieldshowname></field><field><filedname>applyDep</filedname><filedlabel>申请部门</filedlabel><fileddbtype>integer</fileddbtype><filedvalue>555</filedvalue><fieldshowname>南通基地采购办公室</fieldshowname></field><field><filedname>applyCom</filedname><filedlabel>申请公司</filedlabel><fileddbtype>int</fileddbtype><filedvalue>61</filedvalue><fieldshowname>惠生（南通）重工有限公司</fieldshowname></field></maintable></data><data id=\"1026\"><handlers><modedatacreater>6068</modedatacreater><modedatacreatershow>张筱伊</modedatacreatershow><modedatacreatedate>2019-01-02</modedatacreatedate><modedatacreatetime>13:47:30</modedatacreatetime></handlers><maintable><field><filedname>displayOrder</filedname><filedlabel>显示顺序</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>filaName</filedname><filedlabel>文件名称</filedlabel><fileddbtype>varchar2(300)</fileddbtype><filedvalue>液态气化站事故专项应急预案</filedvalue><fieldshowname>液态气化站事故专项应急预案</fieldshowname></field><field><filedname>fileCode</filedname><filedlabel>文件编号</filedlabel><fileddbtype>varchar2(50)</fileddbtype><filedvalue>WOM-MS/TI-4FI-G-001</filedvalue><fieldshowname>WOM-MS/TI-4FI-G-001</fieldshowname></field><field><filedname>fileState</filedname><filedlabel>文件状态</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>fileType</filedname><filedlabel>文件类型</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>signDeps</filedname><filedlabel>会签部门</filedlabel><fileddbtype>varchar2(4000)</fileddbtype><filedvalue /><fieldshowname /></field><files><filedname>attachment</filedname><filedlabel>附件</filedlabel><fileddbtype>varchar2(4000)</fileddbtype><filedvalue /><file><filename /><filecontent /><filecontenttype /></file><fieldshowname /></files><field><filedname>applicant</filedname><filedlabel>申请人</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>nowVer</filedname><filedlabel>当前版本</filedlabel><fileddbtype>varchar2(50)</fileddbtype><filedvalue>A0</filedvalue><fieldshowname>A0</fieldshowname></field><field><filedname>applyDep</filedname><filedlabel>申请部门</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>applyCom</filedname><filedlabel>申请公司</filedlabel><fileddbtype>int</fileddbtype><filedvalue /><fieldshowname /></field></maintable></data><data id=\"1027\"><handlers><modedatacreater>6068</modedatacreater><modedatacreatershow>张筱伊</modedatacreatershow><modedatacreatedate>2019-01-02</modedatacreatedate><modedatacreatetime>13:47:30</modedatacreatetime></handlers><maintable><field><filedname>displayOrder</filedname><filedlabel>显示顺序</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>filaName</filedname><filedlabel>文件名称</filedlabel><fileddbtype>varchar2(300)</fileddbtype><filedvalue>起重机钢丝绳缠绕作业标准</filedvalue><fieldshowname>起重机钢丝绳缠绕作业标准</fieldshowname></field><field><filedname>fileCode</filedname><filedlabel>文件编号</filedlabel><fileddbtype>varchar2(50)</fileddbtype><filedvalue>WOM-MS/TS-4MP-C-002</filedvalue><fieldshowname>WOM-MS/TS-4MP-C-002</fieldshowname></field><field><filedname>fileState</filedname><filedlabel>文件状态</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>fileType</filedname><filedlabel>文件类型</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>signDeps</filedname><filedlabel>会签部门</filedlabel><fileddbtype>varchar2(4000)</fileddbtype><filedvalue /><fieldshowname /></field><files><filedname>attachment</filedname><filedlabel>附件</filedlabel><fileddbtype>varchar2(4000)</fileddbtype><filedvalue /><file><filename /><filecontent /><filecontenttype /></file><fieldshowname /></files><field><filedname>applicant</filedname><filedlabel>申请人</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>nowVer</filedname><filedlabel>当前版本</filedlabel><fileddbtype>varchar2(50)</fileddbtype><filedvalue>A0</filedvalue><fieldshowname>A0</fieldshowname></field><field><filedname>applyDep</filedname><filedlabel>申请部门</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>applyCom</filedname><filedlabel>申请公司</filedlabel><fileddbtype>int</fileddbtype><filedvalue /><fieldshowname /></field></maintable></data><data id=\"1028\"><handlers><modedatacreater>6068</modedatacreater><modedatacreatershow>张筱伊</modedatacreatershow><modedatacreatedate>2019-01-02</modedatacreatedate><modedatacreatetime>13:47:30</modedatacreatetime></handlers><maintable><field><filedname>displayOrder</filedname><filedlabel>显示顺序</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>filaName</filedname><filedlabel>文件名称</filedlabel><fileddbtype>varchar2(300)</fileddbtype><filedvalue>起重指挥作业指导书</filedvalue><fieldshowname>起重指挥作业指导书</fieldshowname></field><field><filedname>fileCode</filedname><filedlabel>文件编号</filedlabel><fileddbtype>varchar2(50)</fileddbtype><filedvalue>WOM-MS/TI-4ST-G-007</filedvalue><fieldshowname>WOM-MS/TI-4ST-G-007</fieldshowname></field><field><filedname>fileState</filedname><filedlabel>文件状态</filedlabel><fileddbtype>integer</fileddbtype><filedvalue>2</filedvalue><fieldshowname>作废</fieldshowname></field><field><filedname>fileType</filedname><filedlabel>文件类型</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>signDeps</filedname><filedlabel>会签部门</filedlabel><fileddbtype>varchar2(4000)</fileddbtype><filedvalue /><fieldshowname /></field><files><filedname>attachment</filedname><filedlabel>附件</filedlabel><fileddbtype>varchar2(4000)</fileddbtype><filedvalue>36603</filedvalue><file><filename>TI-4ST-G-007 Rev.A1 起重指挥作业指导书 Instruction of Lifting Operation.doc</filename><filecontent>/weaver/weaver.file.FileDownload?fileid=44074</filecontent><filecontenttype>http</filecontenttype></file><fieldshowname>36603</fieldshowname></files><field><filedname>applicant</filedname><filedlabel>申请人</filedlabel><fileddbtype>integer</fileddbtype><filedvalue>5294</filedvalue><fieldshowname>朱佳欢</fieldshowname></field><field><filedname>nowVer</filedname><filedlabel>当前版本</filedlabel><fileddbtype>varchar2(50)</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>applyDep</filedname><filedlabel>申请部门</filedlabel><fileddbtype>integer</fileddbtype><filedvalue>518</filedvalue><fieldshowname>结构部</fieldshowname></field><field><filedname>applyCom</filedname><filedlabel>申请公司</filedlabel><fileddbtype>int</fileddbtype><filedvalue>61</filedvalue><fieldshowname>惠生（南通）重工有限公司</fieldshowname></field></maintable></data><data id=\"1029\"><handlers><modedatacreater>6068</modedatacreater><modedatacreatershow>张筱伊</modedatacreatershow><modedatacreatedate>2019-01-02</modedatacreatedate><modedatacreatetime>13:47:30</modedatacreatetime></handlers><maintable><field><filedname>displayOrder</filedname><filedlabel>显示顺序</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>filaName</filedname><filedlabel>文件名称</filedlabel><fileddbtype>varchar2(300)</fileddbtype><filedvalue>质量手册</filedvalue><fieldshowname>质量手册</fieldshowname></field><field><filedname>fileCode</filedname><filedlabel>文件编号</filedlabel><fileddbtype>varchar2(50)</fileddbtype><filedvalue>WOM-MS/G-100-001</filedvalue><fieldshowname>WOM-MS/G-100-001</fieldshowname></field><field><filedname>fileState</filedname><filedlabel>文件状态</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>fileType</filedname><filedlabel>文件类型</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>signDeps</filedname><filedlabel>会签部门</filedlabel><fileddbtype>varchar2(4000)</fileddbtype><filedvalue /><fieldshowname /></field><files><filedname>attachment</filedname><filedlabel>附件</filedlabel><fileddbtype>varchar2(4000)</fileddbtype><filedvalue /><file><filename /><filecontent /><filecontenttype /></file><fieldshowname /></files><field><filedname>applicant</filedname><filedlabel>申请人</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>nowVer</filedname><filedlabel>当前版本</filedlabel><fileddbtype>varchar2(50)</fileddbtype><filedvalue>B3</filedvalue><fieldshowname>B3</fieldshowname></field><field><filedname>applyDep</filedname><filedlabel>申请部门</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>applyCom</filedname><filedlabel>申请公司</filedlabel><fileddbtype>int</fileddbtype><filedvalue /><fieldshowname /></field></maintable></data><data id=\"1030\"><handlers><modedatacreater>6068</modedatacreater><modedatacreatershow>张筱伊</modedatacreatershow><modedatacreatedate>2019-01-02</modedatacreatedate><modedatacreatetime>13:47:30</modedatacreatetime></handlers><maintable><field><filedname>displayOrder</filedname><filedlabel>显示顺序</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>filaName</filedname><filedlabel>文件名称</filedlabel><fileddbtype>varchar2(300)</fileddbtype><filedvalue>项目ITP(检验与试验计划)规定</filedvalue><fieldshowname>项目ITP(检验与试验计划)规定</fieldshowname></field><field><filedname>fileCode</filedname><filedlabel>文件编号</filedlabel><fileddbtype>varchar2(50)</fileddbtype><filedvalue>WOM-MS/MP-3QM-003</filedvalue><fieldshowname>WOM-MS/MP-3QM-003</fieldshowname></field><field><filedname>fileState</filedname><filedlabel>文件状态</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>fileType</filedname><filedlabel>文件类型</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>signDeps</filedname><filedlabel>会签部门</filedlabel><fileddbtype>varchar2(4000)</fileddbtype><filedvalue /><fieldshowname /></field><files><filedname>attachment</filedname><filedlabel>附件</filedlabel><fileddbtype>varchar2(4000)</fileddbtype><filedvalue /><file><filename /><filecontent /><filecontenttype /></file><fieldshowname /></files><field><filedname>applicant</filedname><filedlabel>申请人</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>nowVer</filedname><filedlabel>当前版本</filedlabel><fileddbtype>varchar2(50)</fileddbtype><filedvalue>A0</filedvalue><fieldshowname>A0</fieldshowname></field><field><filedname>applyDep</filedname><filedlabel>申请部门</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>applyCom</filedname><filedlabel>申请公司</filedlabel><fileddbtype>int</fileddbtype><filedvalue /><fieldshowname /></field></maintable></data><data id=\"1031\"><handlers><modedatacreater>6068</modedatacreater><modedatacreatershow>张筱伊</modedatacreatershow><modedatacreatedate>2019-01-02</modedatacreatedate><modedatacreatetime>13:47:30</modedatacreatetime></handlers><maintable><field><filedname>displayOrder</filedname><filedlabel>显示顺序</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>filaName</filedname><filedlabel>文件名称</filedlabel><fileddbtype>varchar2(300)</fileddbtype><filedvalue>喷砂检验作业标准（通用）</filedvalue><fieldshowname>喷砂检验作业标准（通用）</fieldshowname></field><field><filedname>fileCode</filedname><filedlabel>文件编号</filedlabel><fileddbtype>varchar2(50)</fileddbtype><filedvalue>WOM-MS/TI-4QM-G-020</filedvalue><fieldshowname>WOM-MS/TI-4QM-G-020</fieldshowname></field><field><filedname>fileState</filedname><filedlabel>文件状态</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>fileType</filedname><filedlabel>文件类型</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>signDeps</filedname><filedlabel>会签部门</filedlabel><fileddbtype>varchar2(4000)</fileddbtype><filedvalue /><fieldshowname /></field><files><filedname>attachment</filedname><filedlabel>附件</filedlabel><fileddbtype>varchar2(4000)</fileddbtype><filedvalue /><file><filename /><filecontent /><filecontenttype /></file><fieldshowname /></files><field><filedname>applicant</filedname><filedlabel>申请人</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>nowVer</filedname><filedlabel>当前版本</filedlabel><fileddbtype>varchar2(50)</fileddbtype><filedvalue>A0</filedvalue><fieldshowname>A0</fieldshowname></field><field><filedname>applyDep</filedname><filedlabel>申请部门</filedlabel><fileddbtype>integer</fileddbtype><filedvalue /><fieldshowname /></field><field><filedname>applyCom</filedname><filedlabel>申请公司</filedlabel><fileddbtype>int</fileddbtype><filedvalue /><fieldshowname /></field></maintable></data></ROOT>";
		System.out.println(client.getAllModeDataList(821, 1, 10, 0, 9652, "", "",""));
//		System.out.println(client.getAllModeDataCount(821, 801, "", ""));
//		modeData = client.getAllModeDataList(822, 1, 10, 0, 802, "", "Y","N");
//		System.out.println(client.getAllModeDataList(2561, 1, 10, 0, 3142, "", "N","N"));
//		modeData = client.getAllModeDataList(2561, 1, 10, 0, 3142, "", "","");
//		System.out.println(client.getAllModeDataList(2521, 1, 10, 0, 3141, "", "",""));
//		JSONObject xmlJSONObj = XML.toJSONObject(modeData);

//		System.out.println(xmlJSONObj);
	}
	
	/**
	 * 保存（新增、更新）
	 */
	public void addMoidfyModeData(){
		ModeDateService modeDateService = new ModeDateService();
		ModeDateServicePortType client= modeDateService.getModeDateServiceHttpPort();
		String modeid = "127";
		String khmc  ="测试客户1231111";
		String dataid = "1";
		String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		xml +="<ROOT>";
		xml +="<header>";
		xml +="<userid>1</userid>";//用户id
		xml +="<modeid>"+modeid+"</modeid>";//模块id
		xml +="<id>"+dataid+"</id>";//billid 如果是新增则值为空   如果有数据则为修改
		xml +="</header>";
		xml +="<search>";
		xml +="<condition />";
		xml +="<right>Y</right>";//是否验证权限
		xml +="</search>";
		xml +="<data id=\"\">";
		xml +="<maintable>";
		xml +="<field>";
		xml +="<filedname>name</filedname>";//数据库名称
		xml +="<filedlabel>名称</filedlabel>";//字段名称
		xml +="<fileddbtype>varchar(256)</fileddbtype>";//数据库类型
		xml +="<filedvalue>"+khmc+"</filedvalue>";//字段的值
		xml +="<fieldshowname>名称</fieldshowname>";
		xml +="</field>";
		xml +="<files>";
		xml +="<filedname>file1</filedname>";//数据库名称
		xml +="<file>";
		xml +="<filename>w.doc</filename>";//附件名字
		xml +="<filecontent>http://www.badiu.com/1.zip</filecontent>";//附件url
		xml +="</file>";
		xml +="<file>";
		xml +="<filename>w2.doc</filename>";//附件名字
		xml +="<filecontent>http://www.badiu.com/2.zip</filecontent>";//附件url
		xml +="</file>";
		xml +="</files>";
		xml +="</maintable>";
		xml +="<detail>";
		xml +="<detailtable id='0'>";//id为明细表序号  第一个从0开始
		/* row元素
		 * action有3个选项  1.add新增  2.update修改 3.delete删除
		 * id为数据的id字段的值  当action为 update/delete时有效
		 * */
		xml +="<row id='1' action='add'>";
		xml +="<field>";
		xml +="<filedname>no</filedname>";//数据库名称
		xml +="<filedlabel>编号</filedlabel>";//字段名称
		xml +="<fileddbtype>varchar(256)</fileddbtype>";//数据库类型
		xml +="<filedvalue>"+khmc+"</filedvalue>";//字段的值
		xml +="<fieldshowname>编号</fieldshowname>";
		xml +="</field>";
		xml +="<field>";
		xml +="<filedname>name</filedname>";//数据库名称
		xml +="<filedlabel>名称</filedlabel>";//字段名称
		xml +="<fileddbtype>varchar(256)</fileddbtype>";//数据库类型
		xml +="<filedvalue>"+khmc+"</filedvalue>";//字段的值
		xml +="<fieldshowname>名称</fieldshowname>";
		xml +="</field>";
		xml +="<files>";
		xml +="<filedname>file1</filedname>";//数据库名称
		xml +="<file>";
		xml +="<filename>w.doc</filename>";//附件名字
		xml +="<filecontent>http://www.badiu.com/1.zip</filecontent>";//附件url
		xml +="</file>";
		xml +="<file>";
		xml +="<filename>w2.doc</filename>";//附件名字
		xml +="<filecontent>http://www.badiu.com/2.zip</filecontent>";//附件url
		xml +="</file>";
		xml +="</files>";
		xml +="</row>";
		xml +="</detailtable>";
		xml +="</detail>";
		xml +="</data>";
		xml +="</ROOT>";
		System.out.println(client.saveModeData(xml));
	}
	
	/**
	 * 删除表单数据
	 */
	public void deleteModeDateService(){
		ModeDateService modeDateService = new ModeDateService();
		ModeDateServicePortType client= modeDateService.getModeDateServiceHttpPort();
		/**
		 @param modeId 表单ID
		 @param Id 数据ID
		 @param userId 用户ID
		 @param right （y/n） 是否受权限控制 
		 * */
		System.out.println(client.deleteModeDataById(127, 1, 1, "Y"));
		
	}
	
	/**
	 * 获取表单数据总数
	 */
	public void getAllModeDataCount(){
		ModeDateService modeDateService = new ModeDateService();
		ModeDateServicePortType client= modeDateService.getModeDateServiceHttpPort();
		/*
		 * @param modeId 表单ID
		   @param userId 用户ID
		   @param conditions 查询条件
		   @param right （y/n） 是否受权限控制 
		 * */
		System.out.println(client.getAllModeDataCount(127, 1, "", "Y"));
	}
	
	/**
	 * 获取表单内容
	 */
	public void getModeDataByID(){
		ModeDateService modeDateService = new ModeDateService();
		ModeDateServicePortType client= modeDateService.getModeDateServiceHttpPort();
		/*
		 @param modeId 表单ID
		 @param Id 数据ID
		 @param userId 用户ID
		 @param right （y/n） 是否受权限控制
	     @param isReturnDetail （y/n） 是否返回明细表数据 
		 * */
		System.out.println(client.getModeDataByID(127, 3, 1,"Y", "Y"));
	}

}
