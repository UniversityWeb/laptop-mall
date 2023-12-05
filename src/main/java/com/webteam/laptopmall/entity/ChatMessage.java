package com.webteam.laptopmall.entity;

import com.webteam.laptopmall.entity.user.User;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "chat_messages")
public class ChatMessage {
    public enum EType {
        TEXT, NOTIFICATION
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message", columnDefinition = "TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String msg;

    @Enumerated(EnumType.STRING)
    private EType type;

    @Column(name = "sending_time")
    private Timestamp sendingTime;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id")
    private User receiver;

    public ChatMessage() {
    }

    public ChatMessage(Long id, String msg, EType type, Timestamp sendingTime, User sender, User receiver) {
        this.id = id;
        this.msg = msg;
        this.type = type;
        this.sendingTime = sendingTime;
        this.sender = sender;
        this.receiver = receiver;
    }

    public ChatMessage(String msg, EType type, Timestamp sendingTime, User sender, User receiver) {
        this.msg = msg;
        this.type = type;
        this.sendingTime = sendingTime;
        this.sender = sender;
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", type=" + type +
                ", sendingTime=" + sendingTime +
                ", senderId=" + sender.getId() +
                ", receiverId=" + receiver.getId() +
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

    public EType getType() {
        return type;
    }

    public void setType(EType type) {
        this.type = type;
    }

    public Timestamp getSendingTime() {
        return sendingTime;
    }

    public void setSendingTime(Timestamp sendingTime) {
        this.sendingTime = sendingTime;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
}
