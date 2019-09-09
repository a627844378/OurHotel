package cn.foreverhu.service.impl;

import cn.foreverhu.dao.CorderDao;
import cn.foreverhu.dao.impl.CorderDaoImpl;
import cn.foreverhu.service.CorderService;
import com.lagos.Model.Client;
import com.lagos.Model.Corder;

import java.util.List;

public class CorderServiceImpl implements CorderService {
    private CorderDao corderDao = new CorderDaoImpl();

    @Override
    public boolean addCorder(Corder corder) {
        boolean flag = true;
        List<Corder> corders = corderDao.findByTelephone(corder.getClient_telephone());
        for (Corder corder1 : corders) {
            if (corder1.getRoom_id() == corder.getRoom_id()) {
                return  false;
            }
        }
        try {
            corderDao.addCorder(corder);
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }

        return flag;
    }

    @Override
    public List<Corder> findByTelephone(Client client) {
        List<Corder> corders = corderDao.findByTelephone(client.getClient_telephone());
        return corders;
    }
}
