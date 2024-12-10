package com.BackEnd.Features.MailService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
@Getter @Setter
@Data
public class MeetingDetails {
    private String id;
    private String topic;
    private String start_time;
    private int duration;
    private String join_url;
    private String uuid;
    private String Pmail;
    private String Dmail;
    private String Pname;
    private String Dname;
}