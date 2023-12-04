package com.webteam.laptopmall.dto;

import com.webteam.laptopmall.entity.ChatMessage;

import java.sql.Timestamp;

public class ChatMessageDTO {
    private Long id;
    private String msg;
    private ChatMessage.EType type;
    private Timestamp sendingTime;
    private UserDTO sender = new UserDTO();
    private UserDTO receiver = new UserDTO();

    public ChatMessageDTO() {
    }

    public ChatMessageDTO(Long id, String msg, ChatMessage.EType type,
                          Timestamp sendingTime, UserDTO sender, UserDTO receiver) {
        this.id = id;
        this.msg = msg;
        this.type = type;
        this.sendingTime = sendingTime;
        this.sender = sender;
        this.receiver = receiver;
    }

    public ChatMessageDTO(String msg, ChatMessage.EType type,
                          Timestamp sendingTime, UserDTO sender, UserDTO receiver) {
        this.msg = msg;
        this.type = type;
        this.sendingTime = sendingTime;
        this.sender = sender;
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "ChatMessageDTO{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", type=" + type +
                ", sendingTime=" + sendingTime +
                ", sender=" + sender +
                ", receiver=" + receiver +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ChatMessage.EType getType() {
        return type;
    }

    public void setType(ChatMessage.EType type) {
        this.type = type;
    }

    public Timestamp getSendingTime() {
        return sendingTime;
    }

    public void setSendingTime(Timestamp sendingTime) {
        this.sendingTime = sendingTime;
    }

    public UserDTO getSender() {
        return sender;
    }

    public void setSender(UserDTO sender) {
        this.sender = sender;
    }

    public UserDTO getReceiver() {
        return receiver;
    }

    public void setReceiver(UserDTO receiver) {
        this.receiver = receiver;
    }
}
