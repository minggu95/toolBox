package dto;

import lombok.Data;

import java.util.Date;

@Data
public class Violation {
    private Integer id;

    private Integer eID;

    private String badge;

    private Integer vioBeh;

    private Integer major;

    private Integer degree;

    private String remark;

    private Integer initializedBy;

    private Date opDate;

}