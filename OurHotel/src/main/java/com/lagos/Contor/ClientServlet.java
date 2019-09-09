package com.lagos.Contor;

import com.google.gson.Gson;
import com.lagos.Model.Client;
import com.lagos.Service.ClientService;
import com.lagos.Service.Iml.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/client/*")
public class ClientServlet extends BaseServlet {
    Gson gson = new Gson();
    ClientService clientService = new ClientServiceImpl();

    /**
     * 查询所有用户
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findAllClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(gson.toJson(clientService.findAllClient()));
    }

    /**
     * 根据电话号码寻找客户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void findClientByTelephone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response .setContentType("text/html;charset=utf-8");
        response.getWriter().write(gson.toJson(clientService.findClientByTel(request.getParameter("client_telephone"))));
    }



        /**
         * 添加客户信息
         * @param request
         * @param response
         * @throws ServletException
         * @throws IOException
         */
    public void addClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Client client=new Client();
        client.setClient_no(request.getParameter("client_no"));
        response.setContentType("text/html;charset=utf-8");
        //用身份证验证年龄
        if (clientService.checkClientAge(client.getClient_no())){
            client.setClient_address(request.getParameter("client_address"));
            if (request.getParameter("client_age")==""){

            }else {
                client.setClient_age(Integer.parseInt(request.getParameter("client_age")));
            }
            client.setClient_name(request.getParameter("client_name"));
            client.setClient_password(request.getParameter("client_password"));
            client.setClient_sex(request.getParameter("client_sex"));
            client.setClient_telephone(request.getParameter("client_telephone"));
            boolean b = clientService.addClient(client);
            response.getWriter().write(gson.toJson(b));
        }else {
            System.out.println(3);
            response.getWriter().write(gson.toJson(false));
        }
    }
    //删除客户
    public void deleteClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("client_telephone"));
        boolean flag = clientService.deleteClient(request.getParameter("client_telephone"));
        response.setContentType("text/html;charset=utf-8");
        if (flag){
            response.getWriter().write("删除成功");
        }else {
            response.getWriter().write("删除失败");
        }
        response.sendRedirect("http://localhost:8080/OurHotel_war/member-list.html");
    }

    /**
     * 更新客户
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void updateClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Client client=new Client();
        client.setClient_no(request.getParameter("client_no"));
        client.setClient_address(request.getParameter("client_address"));
        if (request.getParameter("client_age")==""||request.getParameter("client_id")==""){

        }else {
            client.setClient_id(Integer.parseInt(request.getParameter("client_id")));
            client.setClient_age(Integer.parseInt(request.getParameter("client_age")));
        }
        client.setClient_name(request.getParameter("client_name"));
        client.setClient_password(request.getParameter("client_password"));
        client.setClient_sex(request.getParameter("client_sex"));
        client.setClient_telephone(request.getParameter("client_telephone"));
        boolean b = clientService.updateClient(client);
        response.setContentType("text/html;charset=utf-8");
        if (b){
            response.getWriter().write("修改成功");
        }else {
            response.getWriter().write("修改失败");
        }
    }
}