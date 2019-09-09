package cn.foreverhu.servlet;

import cn.foreverhu.service.ImgService;
import cn.foreverhu.service.RoomService;
import cn.foreverhu.service.impl.ImgServiceImpl;
import cn.foreverhu.service.impl.RoomServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lagos.Contor.BaseServlet;
import com.lagos.Model.Img;
import com.lagos.Model.Room;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet("/room1/*")
public class RoomServlet extends BaseServlet {
    private RoomService roomService = new RoomServiceImpl();
    private ImgService imgService = new ImgServiceImpl();
    public void getAllNullRoom(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        List<Room> rooms = roomService.findAllNullRoom();
        for (Room room : rooms) {
            List<Img> imgs = imgService.findByRoomId(room);
            room.setRoom_imgId(imgs);
        }
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(rooms);
        System.out.println("hahahahahhahaha:"+json);
        response.getWriter().write(json);
        return;
    }

    public void getRoomByType(HttpServletRequest request, HttpServletResponse response) throws IOException{
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        String s = request.getParameter("room_type");
        Room room = new Room();
        room.setRoom_type(s);
        System.out.println(room.getRoom_type());
        List<Room> rooms = roomService.findByType(room);
        for (Room room1 : rooms) {
            List<Img> imgs = imgService.findByRoomId(room1);
            room1.setRoom_imgId(imgs);
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(rooms);
        System.out.println(json+"hello -");
        response.getWriter().write(json);
    }

    public void toRoom(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String room_id = request.getParameter("room_id");
        System.out.println("room_id "+ room_id);
        Room room = roomService.findByRoomId(Integer.parseInt(room_id));
        List<Img> imgs = imgService.findByRoomId(room);
        room.setRoom_imgId(imgs);
        request.getSession().setAttribute("room", room);
        response.sendRedirect(request.getContextPath()+"/show_room.html");
    }

    public void showRoom(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        Room room = (Room) request.getSession().getAttribute("room");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(room);
        System.out.println("ROom Info : " + json);
        response.getWriter().write(json);
        return;
    }


}
