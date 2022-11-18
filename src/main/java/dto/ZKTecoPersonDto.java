package dto;

import lombok.Data;

@Data
public class ZKTecoPersonDto {

    /// <summary>
    /// 人员编号，必填
    /// </summary>
    private String Pin;

    /// <summary>
    /// 部门编号
    /// </summary>
    private String DeptCode;

    /// <summary>
    /// 生日日期
    /// </summary>
    private String Birthday;

    /// <summary>
    /// 车牌号码
    /// </summary>
    private String CarPlate;

    /// <summary>
    /// 卡号
    /// </summary>
    private String CardNo;

    /// <summary>
    /// 证件号码
    /// </summary>
    private String CertNumber;

    /// <summary>
    /// 证件类型，2：二代身份证，3：护照，4：驾照，5：工作证，6：市民卡，7：驾驶证；1000：厦门社保卡，1001：港澳通行证；
    /// </summary>
    private String CertType;

    /// <summary>
    /// 邮箱地址，如 123@zkteco.com
    /// </summary>
    private String Email;

    /// <summary>
    /// 性别，M 男，F 女
    /// </summary>
    private String Gender;

    /// <summary>
    /// 人员离职日期，如：" 2019-06-10"
    /// </summary>
    private String HireDate;

    /// <summary>
    /// 是否发送邮件，true：发送； false：不发送
    /// </summary>
    private boolean IsSendMail;

    /// <summary>
    /// 性别，M 男，F 女
    /// </summary>
    private String MobilePhone;

    /// <summary>
    /// 姓名
    /// </summary>
    private String Name;

    /// <summary>
    /// 人员姓名，英文下才有用
    /// </summary>
    private String LastName;

    /// <summary>
    /// 人员照片，base64 格式
    /// </summary>
    private String PersonPhoto;

    /// <summary>
    /// 设备验证密码，如："123456"；
    /// </summary>
    private String PersonPwd;

    /// <summary>
    /// 社会安全号
    /// </summary>
    private String Ssn;

    /// <summary>
    /// 副卡，要使用该功能，需要在人事参数设置开启一人多卡，可以设置多个，多个用逗号隔开，如："987643，2233452"；
    /// </summary>
    private String SupplyCards;

    /// <summary>
    /// 门禁有效开始时间，如：2017-08-04 15:45:00；
    /// </summary>
    private String AccStartTime;

    /// <summary>
    /// 门禁有效结束时间，如：2017-08-04 23:59:59；
    /// </summary>
    private String AccEndTime;

    /// <summary>
    /// 门 禁 权 限 组 id 集 合 ， 
    /// 多 个 用 逗 号 隔 开 ， 
    /// 如 ：402856aa6c3c5063016c3cb3a0360005,402856aa6bff4b1a016bff5374800c0e,402856aa6c3baabb016c3bb37365000a；
    /// </summary>
    private String AccLevelIds;
}
