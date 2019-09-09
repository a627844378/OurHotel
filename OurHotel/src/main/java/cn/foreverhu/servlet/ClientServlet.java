package cn.foreverhu.servlet;


import cn.foreverhu.service.ClientService;
import cn.foreverhu.service.impl.ClientServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.BeanUtil;
import com.lagos.Contor.BaseServlet;
import com.lagos.Model.Client;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/client1/*")
public class ClientServlet extends BaseServlet {
    private ClientService clientService = new ClientServiceImpl();
    public void checkClientLogin(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Map<String, String[]> map = request.getParameterMap();
        System.out.println("checkClientLogin 执行了！");
        Client client = new Client();
        client.setClient_telephone(request.getParameter("client_telephone").trim());
        client.setClient_password(request.getParameter("client_password").trim());
        String checkCode = request.getParameter("checkCode").trim();
        String realCode = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        Client client1 = clientService.findByTelephone(client);
        request.getSession().setAttribute("client", client1);
        if (!realCode.equalsIgnoreCase(checkCode) || "".equals(checkCode)) {
            response.getWriter().write("验证码错误");
            return;
        }

        boolean flag = clientService.checkClientLogin(client);
        System.out.println(flag);
        if (!flag) {
            response.getWriter().write("密码错误！");
        }else {
            response.getWriter().write("index.html");
        }
        return;
    }

    public void registerClient(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("registerClient 执行了！");
        Map<String, String[]> map = request.getParameterMap();
        Client client = new Client();
        BeanUtils.populate(client, map);
        System.out.println(client);
        boolean flag = clientService.addClient(client);
        System.out.println(flag);
        if (flag) {
            response.getWriter().write("注册成功！");
        }else{
            response.getWriter().write("注册失败！");
        }
        return;
    }

    public void getClientInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        Client client = (Client) request.getSession().getAttribute("client");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(client);
        System.out.println("getClientUser: "+json);
        response.getWriter().write(json);
    }

    public void updateClient(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        Client client = (Client) request.getSession().getAttribute("client");
        String client_address = request.getParameter("client_address").trim();
        String client_password = request.getParameter("client_password").trim();
        String client_sex = request.getParameter("client_sex");
        client.setClient_password(client_password);
        client.setClient_address(client_address);
        client.setClient_sex(client_sex);
        System.out.println("修改后：--------------------------"+client);
        boolean flag = clientService.updateClient(client);
        if (flag) {
            response.getWriter().write("修改信息成功！");
        }else{
            response.getWriter().write("修改信息失败！");
        }
        return;
    }
}
