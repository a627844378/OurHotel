package com.lagos.room.RoomService;

import com.lagos.Service.ClientService;
import com.lagos.Service.Iml.ClientServiceImpl;
import org.junit.Test;

public class ClientServiceTest {
    ClientService clientService =new ClientServiceImpl();
    @Test
    public void test(){
        System.out.println(clientService.checkClientAge("510107199803220877"));
    }
}
