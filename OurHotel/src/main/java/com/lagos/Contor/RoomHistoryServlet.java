package com.lagos.Contor;

import com.google.gson.Gson;
import com.lagos.Model.HistoryRoom;
import com.lagos.Service.Iml.RoomHistoryServiceImpl;
import com.lagos.Service.RoomHistoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/roomhistory/*")
public class RoomHistoryServlet extends BaseServlet {
    Gson gson=new Gson();
    /**
     * 查找所有历史信息
     */
    RoomHistoryService roomHistoryService=new RoomHistoryServiceImpl();
    public void getAllRoomHs(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(gson.toJson(roomHistoryService.findAllRoomHistory()));
    }

    public void findRoomHyByInf(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<HistoryRoom> client_telephone = roomHistoryService.findRoomHyByInf(request.getParameter("client_telephone"));
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(gson.toJson(client_telephone));
    }
}