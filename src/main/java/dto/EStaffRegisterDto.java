package dto;

import lombok.Data;

@Data
public class EStaffRegisterDto {

    /**
     * 民族
     */
    private String nation;

    /**
     * 身份证号
     */
    private String certNo;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 出生
     */
    private String birthDay;

    /**
     * 地址
     */
    private String birthPlace;

    /**
     * 签发机关
     */
    private String signOrg;

    /**
     * 期限起始
     */
    private String certBeginDate;

    /**
     * 期限失效
     */
    private String certEndDate;

    /**
     * 图片
     */
    private String image;

    /**
     * 用户
     */
    private String InitializedBy;

    /**
     * 公司
     */
    private String compID;


}
