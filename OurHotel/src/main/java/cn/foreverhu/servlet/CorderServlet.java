package cn.foreverhu.servlet;


import cn.foreverhu.service.CorderService;
import cn.foreverhu.service.RoomService;
import cn.foreverhu.service.impl.CorderServiceImpl;
import cn.foreverhu.service.impl.RoomServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagos.Contor.BaseServlet;
import com.lagos.Model.Client;
import com.lagos.Model.Corder;
import com.lagos.Model.Room;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/corder1/*")
public class CorderServlet extends BaseServlet {
    private CorderService corderService = new CorderServiceImpl();

    public void checkIn(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException, ParseException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String corder_st_date = request.getParameter("corder_st_date");
        String corder_ed_date = request.getParameter("corder_ed_date");
        System.out.println(corder_st_date +"---------"+ corder_ed_date);
        Corder corder = new Corder();
        corder.setCorder_st_date(format.parse(corder_st_date));
        corder.setCorder_ed_date(format.parse(corder_ed_date));
        Client client = (Client)session.getAttribute("client");
        if (client == null) {
            response.getWriter().write("请先登录后再预定入住！");
            return;
        }
        Room room = (Room) session.getAttribute("room");

        RoomService roomService = new RoomServiceImpl();
        corder.setClient_telephone(client.getClient_telephone());
        corder.setRoom_id(room.getRoom_id());
        boolean flag= corderService.addCorder(corder);
        if (flag) {
            room.setRoom_status("Y");
            System.out.println(room+"====================================");
            boolean flag2 = roomService.chageRoomStatus(room);
            if (flag2) {
                response.getWriter().write("预定成功，欢迎您的入住");
                return;
            }else{
                response.getWriter().write("服务器正忙，请稍后再试");
                return;
            }
        }else{
            response.getWriter().write("您已经预定了该房间，不能重复预定");
        }
        return;
    }

    public void checkClient(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("client");
        if (client == null) {
            response.getWriter().write("您还未登录，如果想查询订单请先登录！");
            return;
        }else{
            response.getWriter().write("show_orders.html");
        }

    }

    public void showOrder(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute("client");
        List<Corder> corders = corderService.findByTelephone(client);
        if (corders.size() <= 0) {
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("您还没有订单");
            return;
        }
        RoomService roomService = new RoomServiceImpl();
        List<Room> rooms = new ArrayList<Room>();
        for (Corder corder : corders) {
            Room room = roomService.findByRoomId(corder.getRoom_id());
            rooms.add(room);
        }
        Map map = new HashMap();
        map.put("client", client);
        map.put("corders", corders);
        map.put("rooms", rooms);
        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        mapper.setDateFormat(format);
        String json = mapper.writeValueAsString(map);
        String date = mapper.writeValueAsString(corders.get(0).getCorder_st_date());
        System.out.println("asdlasjdlkj:"+date+"hello:"+corders.get(0).getCorder_st_date());
        System.out.println("订单查询" + json);
        response.getWriter().write(json);
        return;
    }
}


