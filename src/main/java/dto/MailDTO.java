package dto;

import lombok.Data;

import java.util.List;

@Data
public class MailDTO {

    private String subject;

    private String text;

    private List<String> receiverMailAddress;

    private String sendMailAddress;

    private String sendPWD;
}
