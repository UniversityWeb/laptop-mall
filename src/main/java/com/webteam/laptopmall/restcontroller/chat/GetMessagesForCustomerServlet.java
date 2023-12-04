package com.webteam.laptopmall.restcontroller.chat;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.webteam.laptopmall.dto.ChatMessageDTO;
import com.webteam.laptopmall.service.chatmessage.MessageService;
import com.webteam.laptopmall.service.chatmessage.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/get-messages-for-customer")
public class GetMessagesForCustomerServlet extends HttpServlet {

    private static final Logger log = Logger.getLogger(GetMessagesForCustomerServlet.class.getName());
    private MessageService messageService;

    @Override
    public void init() throws ServletException {
        super.init();
        messageService = new MessageServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sender = req.getParameter("username");

        String jsonMsgs = getMsgsForCustomer(sender);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter pw = resp.getWriter();
        pw.println(jsonMsgs);
        pw.close();
    }

    private String getMsgsForCustomer(String username) {
        List<ChatMessageDTO> msgs = messageService.getMessagesForCustomer(username);
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(msgs);
        } catch (Exception e) {
            log.severe(e.getMessage());
            return "";
        }
    }
}
