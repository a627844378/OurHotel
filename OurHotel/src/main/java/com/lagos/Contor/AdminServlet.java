package com.lagos.Contor;

import com.google.gson.Gson;
import com.lagos.Model.Statis;
import com.lagos.Service.ClientService;
import com.lagos.Service.CorderService;
import com.lagos.Service.Iml.ClientServiceImpl;
import com.lagos.Service.Iml.CorderServiceImpl;
import com.lagos.Service.Iml.RoomHistoryServiceImpl;
import com.lagos.Service.Iml.RoomServiceImpl;
import com.lagos.Service.RoomHistoryService;
import com.lagos.Service.RoomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/admin/*")
public class AdminServlet extends BaseServlet {
    Gson gson=new Gson();

    /**
     * 统计总数
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void statisAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomService roomService=new RoomServiceImpl();
        RoomHistoryService roomHistoryService=new RoomHistoryServiceImpl();
        CorderService corderService=new CorderServiceImpl();
        ClientService clientService=new ClientServiceImpl();
        Statis statis=new Statis();
        statis.setRoom(roomService.findAllRoom().size());
        statis.setRoomHistory(roomHistoryService.findAllRoomHistory().size());
        statis.setCorder(corderService.findAllCorder().size());
        statis.setClient(clientService.findAllClient().size());
        response.getWriter().write(gson.toJson(statis));
    }
}