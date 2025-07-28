package com.westbank.dao;

import com.westbank.domain.Role;
import com.westbank.domain.Staff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class StaffDaoImpl implements StaffDao {

    private static Logger log = LoggerFactory.getLogger(StaffDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Authenticates a {@link Staff} based on his ID and password
     *
     * @param staffId  -- the staff's ID
     * @param password -- the staff's password
     * @return the corresponding {@link Staff} if successful, otherwise
     * <code>null</code>
     */
    @Transactional(readOnly = true)
    public Staff authenticateStaff(String staffId, String password) {
        try {
            TypedQuery<Staff> query = entityManager.createQuery(
                    "select s from Staff as s left join fetch s.role where s.staffId = :staffId and s.password=:password",
                    Staff.class);
            query.setParameter("staffId", staffId);
            query.setParameter("password", password);
            return query.getSingleResult();
        } catch (Exception e) {
            log.error("Authentication failed for staffId: " + staffId, e);
            return null;
        }
    }

    @Transactional
    public void deleteStaff(Staff staff) {
        if (staff != null) {
            deleteStaffById(staff.getStaffId());
        }
    }

    @Transactional
    public void deleteStaffById(String staffId) {
        Staff found = getStaffById(staffId);
        if (found != null) {
            entityManager.remove(found);
        }
    }

    @Transactional(readOnly = true)
    public List<Staff> findAll() {
        // Use JOIN FETCH to eagerly load the role collection
        TypedQuery<Staff> query = entityManager.createQuery(
                "select distinct s from Staff s left join fetch s.role",
                Staff.class);
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public List<Staff> getCreditBrokers() {
        return getStaffByRole(Role.CREDIT_BROKER);
    }

    @Transactional(readOnly = true)
    public List<Staff> getManagers() {
        return getStaffByRole(Role.MANAGER);
    }

    @Transactional(readOnly = true)
    public List<Staff> getPostProcessingClerks() {
        return getStaffByRole(Role.POST_PROCESSING_CLERK);
    }

    @Transactional(readOnly = true)
    public List<Staff> getSupervisors() {
        return getStaffByRole(Role.SUPERVISOR);
    }

    @Transactional(readOnly = true)
    public Staff getStaffById(String staffId) {
        Staff staff = entityManager.find(Staff.class, staffId);
        if (staff != null) {
            // Initialize the role collection while session is active
            staff.getRole().size();
        }
        return staff;
    }

    @Transactional(readOnly = true)
    public List<Staff> getStaffByRole(String roleId) {
        return getStaffByRole(new Role(roleId));
    }

    @Transactional(readOnly = true)
    public List<Staff> getStaffByRole(Role role) {
        List<Staff> staff = new ArrayList<Staff>();
        if (role != null) {
            try {
                TypedQuery<Staff> query = entityManager.createQuery(
                        "select distinct s from Staff s left join fetch s.role r where r = :role",
                        Staff.class);
                query.setParameter("role", role);
                staff = query.getResultList();
            } catch (DataAccessException e) {
                log.error("Cannot retrieve staff: " + e.getMessage());
            }
        }
        return staff;
    }

    @Transactional
    public void save(Staff staff) {
        if (staff != null) {
            if (staff.getStaffId() != null && entityManager.find(Staff.class, staff.getStaffId()) != null) {
                entityManager.merge(staff);
            } else {
                entityManager.persist(staff);
            }
        }
    }

    @Transactional(readOnly = true)
    public List<Role> getAllRoles() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Role> criteriaQuery = builder.createQuery(Role.class);
        Root<Role> root = criteriaQuery.from(Role.class);
        criteriaQuery.select(root);
        TypedQuery<Role> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}