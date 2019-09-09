package com.lagos.Contor;

import com.google.gson.Gson;
import com.lagos.Model.Corder;
import com.lagos.Service.CorderService;
import com.lagos.Service.Iml.CorderServiceImpl;
import com.lagos.Service.Iml.RoomServiceImpl;
import com.lagos.Service.RoomService;
import com.lagos.Utils.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/corder/*")
public class CorderServlet extends BaseServlet {
    CorderService corderService = new CorderServiceImpl();
    Gson gson = new Gson();

    /**
     * 查看所有订单信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findAllCorder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(gson.toJson(corderService.findAllCorder()));
    }

    /**
     * 根据电话号码查看订单信息
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findCorderByTel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String telephone = request.getParameter("client_telephone");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(gson.toJson(corderService.findCorderByTel(telephone)));
    }

    /**
     * 添加订单
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void addCorder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Corder corder = new Corder();
        corder.setClient_telephone(request.getParameter("client_telephone"));
        if (request.getParameter("room_id")==""){

        }else {
            corder.setRoom_id(Integer.parseInt(request.getParameter("room_id")));
        }
        corder.setCorder_st_date(DateUtil.toDate(request.getParameter("corder_st_date")));
        corder.setCorder_ed_date(DateUtil.toDate(request.getParameter("corder_ed_date")));
        boolean b = corderService.addCorder(corder);
        response.setContentType("text/html;charset=utf-8");
        if (b){
            response.getWriter().write("添加成功");
        }else {
            response.getWriter().write("添加失败");
        }
        RoomService  roomService=new RoomServiceImpl();
        roomService.updateRoomStatus(corder.getRoom_id()+"","N");
    }

    /**
     * 住房
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void checkin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Corder corder = new Corder();
        corder.setClient_telephone(request.getParameter("client_telephone"));
        if (request.getParameter("room_id")==""){

        }else {
            corder.setRoom_id(Integer.parseInt(request.getParameter("room_id")));
        }
        corder.setCorder_st_date(DateUtil.toDate(request.getParameter("corder_st_date")));
        corder.setCorder_ed_date(DateUtil.toDate(request.getParameter("corder_ed_date")));
        boolean b = corderService.addCorder(corder);
        response.setContentType("text/html;charset=utf-8");
        if (b){
            response.getWriter().write("入住成功");
        }else {
            response.getWriter().write("入住失败");
        }
        RoomService  roomService=new RoomServiceImpl();
        roomService.updateRoomStatus(corder.getRoom_id()+"","Y");
    }



        /**
         * 根据corder_id删除订单
         *
         * @param request
         * @param response
         * @throws ServletException
         * @throws IOException
         */
    public void deleteCorder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean flag = corderService.deleteCorder(Integer.parseInt(request.getParameter("corder_id")));
        response.sendRedirect("http://localhost:8080/OurHotel_war/order-list.html");
    }

    /**
     * 对比入住结束时间删除无效订单并加入历史表
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void deleteUseLessCorder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write(corderService.deleteUseLessCorder());
    }

    /**
     * 修改订单信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void updateCorder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Corder corder = new Corder();
        corder.setCorder_id(Integer.parseInt(request.getParameter("corder_id")));
        corder.setClient_telephone(request.getParameter("clietn_telephone"));
        corder.setRoom_id(Integer.parseInt(request.getParameter("room_id")));
        corder.setCorder_st_date(DateUtil.toDate(request.getParameter("corder_st_date")));
        corder.setCorder_ed_date(DateUtil.toDate(request.getParameter("corder_ed_date")));
        response.getWriter().print(corderService.updateCorder(corder));
    }

}