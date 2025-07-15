package com.westbank.service;

import com.westbank.dao.StaffDao;
import com.westbank.domain.Role;
import com.westbank.domain.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {

    private final StaffDao staffDao;

    @Autowired
    public StaffServiceImpl(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    public List<Staff> findAll() {
        return staffDao.findAll();
    }

    public Staff getStaffById(String staffId) {
        return staffDao.getStaffById(staffId);
    }

    public List<Role> findAllRoles() {
        return staffDao.getAllRoles();
    }

    public Staff authenticateStaff(String id, String password) {
        return staffDao.authenticateStaff(id, password);
    }
}
