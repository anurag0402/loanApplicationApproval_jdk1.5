package com.westbank.service;

import com.westbank.dao.StaffDao;
import com.westbank.domain.Role;
import com.westbank.domain.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StaffServiceImpl implements StaffService {

    private final StaffDao staffDao;

    @Autowired
    public StaffServiceImpl(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    @Transactional(readOnly = true)
    public List<Staff> findAll() {
        List<Staff> staffList = staffDao.findAll();
        // Initialize lazy collections within transaction context
        for (Staff staff : staffList) {
            initializeRoles(staff);  // Ensure roles are initialized
        }
        return staffList;
    }

    @Transactional(readOnly = true)
    public Staff getStaffById(String staffId) {
        Staff staff = staffDao.getStaffById(staffId);
        // Initialize lazy collections if staff exists
        if (staff != null) {
            initializeRoles(staff);  // Initialize roles for the staff
        }
        return staff;
    }

    @Transactional(readOnly = true)
    public List<Role> findAllRoles() {
        return staffDao.getAllRoles();
    }

    @Transactional(readOnly = true)
    public Staff authenticateStaff(String id, String password) {
        Staff staff = staffDao.authenticateStaff(id, password);
        // Initialize lazy collections for authenticated staff
        if (staff != null) {
            initializeRoles(staff);  // Initialize roles for authenticated staff
        }
        return staff;
    }

    // Helper method to initialize roles lazily loaded from database
    private void initializeRoles(Staff staff) {
        if (staff.getRole() != null) {
            staff.getRole().size();  // Triggers lazy loading
        }
    }
}
