package webserviceClient;

import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import org.apache.axis.client.Stub;
import org.apache.axis.message.SOAPHeaderElement;
import webservice.*;

public class clientMain {

    public static void main(String[] arg0) {
        try {
            EASLoginProxy proxy =new EASLoginProxyService().getEASLogin();
            WSContext wsContext = proxy.login("user", "kduser1", "eas", "wison0223", "l2", 2);
        if(wsContext.getSessionId() == null){
            //登录失败
            System.out.println("返回sessionId为空，登录失败");
        }else {
            System.out.println("登录成功，返回sessionId:"+wsContext.getSessionId());
            WSBillInterfaceFacadeSrvProxy proxyWS= null;
            proxyWS = new WSBillInterfaceFacadeSrvProxyService().getWSBillInterfaceFacade();
            //业务接口调用时，设置登录返回的session在soap头
            String namespace = "http://login.WebService.bos.kingdee.com"; //命名空间
            String prefix = "cti";  //前缀
            SOAPElement sessionHeaderElm = SOAPFactory.newInstance().createElement("Header",prefix,namespace); //Header标签
            SOAPElement sessionIdElm = null;  //SessionId标签
            sessionIdElm = SOAPFactory.newInstance().createElement("SessionId",prefix,namespace);
            sessionIdElm.addTextNode(wsContext.getSessionId());  //内容
            sessionHeaderElm.addChildElement(sessionIdElm);
            SOAPHeaderElement soapHeaderElement = new SOAPHeaderElement(sessionHeaderElm);
            ((Stub) proxyWS).setHeader(soapHeaderElement);
//				((Stub) proxyWS).setHeader("http://login.WebService.bos.kingdee.com","SessionId", wsContext.getSessionId().toString() );
            String importBillData = proxyWS.importBillData("project","[{\n" +
                    "\tnumber:\"002\",\n" +
                    "\tname:\"test\",\n" +
                    "\tdescription:\"测试项目\",\n" +
                    "\tstate:\"启用\",\n" +
                    "\tcompany:\"HSJT\",\n" +
                    "\tparentNumber:\"\",\n" +
                    "\tisLeaf:\"1\",\n" +
                    "\tgroupName:\"项目\",\n" +
                    "\tclosestatues:\"Close\",\n" +
                    "\tprestartdate:\"2021-02-08\",\n" +
                    "\tstartdate:\"2021-02-08\"\n" +
                    "}]");
            System.out.println(importBillData);
        }
        } catch (SOAPException e) {
            e.printStackTrace();
        }

    }
}
