import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;


import com.alibaba.fastjson.JSONObject;
import org.apache.axis.AxisFault;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

public class test{
    /**
     * 接口地址
     */
    private static final String address = "http://192.168.1.1:8080//services/WebService";

    /**
     * targetNamespace
     */
    private static final String targetNamespace = "http://localhost/services/HoauWorkflowService";
    /**
     * @throws UnsupportedEncodingException
     *
     * 根据 接口方法和参数调用HR系统WebService
     * @param method	方法名
     * @param params	JSON
     * @return
     * @throws
     */
    public static String getWebservice(String method,String params) throws UnsupportedEncodingException{
        String result = "";
        JSONObject resultObj = new JSONObject();
        try {
            //校验方法名
            URL url = new URL(address);
            Service service = new Service();
            Call call = (Call)service.createCall();
            call.setTargetEndpointAddress(url);
            call.setUseSOAPAction(true);
            call.setSOAPActionURI("");
            call.setEncodingStyle("UTF-8");//编码格式
            call.setTimeout(10000);//超时设置
            call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
            call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
            call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
            call.setOperationName(new javax.xml.namespace.QName(targetNamespace, method));
            call.addParameter("json", XMLType.XSD_STRING, ParameterMode.IN);
            call.setReturnType(XMLType.XSD_STRING);

            result = (String)call.invoke(new Object[]{params});
            System.out.println("+++调用接口返回的数据++++："+result);
        } catch (ServiceException e) {
            resultObj.put("result", "1");
            resultObj.put("message", "接口访问异常！");
            return resultObj.toString();
        }catch(AxisFault e1){
            resultObj.put("result", "1");
            resultObj.put("message", "接口访问异常！");
            return resultObj.toString();
        }catch (RemoteException e) {
            resultObj.put("result", "1");
            resultObj.put("message", "接口访问异常！");
            return resultObj.toString();
        }catch(MalformedURLException e1){
            resultObj.put("result", "1");
            resultObj.put("message", "地址转换异常！");
            return resultObj.toString();
        }

        return result;
    }

}

