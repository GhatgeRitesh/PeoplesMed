package com.BackEnd.Features.MailService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
@Getter @Setter
public class MeetingDetails {
    private String id;
    private String topic;
    private String start_time;
    private int duration;
    private String join_url;
    private String uuid;

    private String mail;
    @Override
    public String toString() {
        return "MeetingDetails{" +
                "id='" + id + '\'' +
                ", topic='" + topic + '\'' +
                ", start_time='" + start_time + '\'' +
                ", duration=" + duration +
                ", join_url='" + join_url + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}