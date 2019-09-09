package com.lagos.room.RoomService;

import com.lagos.Service.CorderService;
import com.lagos.Service.Iml.CorderServiceImpl;
import org.junit.Test;

public class CorderServiceTest {
    CorderService corderService=new CorderServiceImpl();

    @Test
    public void test(){
        System.out.println(corderService.deleteUseLessCorder());
    }
}
