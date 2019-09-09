package cn.foreverhu.service.impl;

import cn.foreverhu.dao.AdminDao;
import cn.foreverhu.dao.impl.AdminDaoImpl;
import cn.foreverhu.service.AdminService;
import com.lagos.Model.Admin;

public class AdminServiceImpl implements AdminService {
    private AdminDao adminDao = new AdminDaoImpl();
    @Override
    public boolean checkAdminCheck(Admin admin) {
        Admin admin2 = adminDao.findByNum(admin.getAdmin_num());
        if (admin2 == null) {
            return false;
        }
        String username = admin.getAdmin_num();
        String password = admin.getAdmin_password();
        if(admin2.getAdmin_num().equals(username) && admin2.getAdmin_password().equals(password)){
            return true;
        }
        return false;
    }
}
