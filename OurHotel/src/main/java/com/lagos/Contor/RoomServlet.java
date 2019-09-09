package com.lagos.Contor;

import com.google.gson.Gson;
import com.lagos.Dao.RoomHistoryDao;
import com.lagos.Model.Corder;
import com.lagos.Model.HistoryRoom;
import com.lagos.Model.Room;
import com.lagos.Service.CorderService;
import com.lagos.Service.Iml.CorderServiceImpl;
import com.lagos.Service.Iml.RoomHistoryServiceImpl;
import com.lagos.Service.Iml.RoomServiceImpl;
import com.lagos.Service.RoomHistoryService;
import com.lagos.Service.RoomService;
import jdk.nashorn.internal.ir.RuntimeNode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/room/*")
public class RoomServlet extends BaseServlet {

    Gson gson=new Gson();
    RoomService roomService=new RoomServiceImpl();


    /**
     * 根据corder_id生成historyRoom并添加
     * 根据corder_id删除订单
     * 根据room_num改变房间状态
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void checkout(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        //获取id
        int corder_id=Integer.parseInt(request.getParameter("corder_id"));
        RoomHistoryService roomHsService=new RoomHistoryServiceImpl();
        boolean flag=false;
        //生成房间历史并添加
        HistoryRoom historyRoom = roomHsService.generateHistoryRoom(corder_id);
        flag=roomHsService.addRoomHistory(historyRoom);
        CorderService corderService=new CorderServiceImpl();
        //删除订单
        flag=corderService.deleteCorder(corder_id);
        //改变房间信息
        System.out.println(historyRoom.getRoom_num()+"===");
        flag=roomService.updateRoomStatus2(historyRoom.getRoom_num(),"N");
        response.getWriter().print(flag);
    }

    /**
     * 添加房间
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        Room room=new Room();
        room.setRoom_describe(request.getParameter("room_describe"));
        room.setRoom_status(request.getParameter("room_status"));
        room.setRoom_price(Double.parseDouble(request.getParameter("room_price")));
        room.setRoom_type(request.getParameter("room_type"));
        room.setRoom_num(request.getParameter("room_num"));
        roomService=new RoomServiceImpl();
        response.getWriter().print( roomService.addRoom(room));
    }

    /**
     * 查看所有房间信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findAllRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(gson.toJson(roomService.findAllRoom()));
    }

    /**
     * 获取所有空房间
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findAllEmptyRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(gson.toJson(roomService.findAllEmptyRoom()));
    }

    public void findRoomByNum(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        Room room_num = roomService.findRoomByNum(request.getParameter("room_num"));
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(gson.toJson(room_num));
    }
}
