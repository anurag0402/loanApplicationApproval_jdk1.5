package com.westbank.dao;

import com.westbank.domain.Address;
import com.westbank.domain.Customer;
import com.westbank.web.form.ApplicationForm;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@Primary
public class CustomerDaoImpl implements CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Customer updateCustomerProfile(Long customerId, ApplicationForm form) {
        Customer customer = getCustomerById(customerId);
        if (form != null && customer != null) {
            customer.setPersonalId(form.getBorrowerPersonalId());
            customer.setTitle(form.getBorrowerTitle());
            customer.setFirstName(form.getBorrowerFirstName());
            customer.setLastName(form.getBorrowerLastName());
            customer.setDateOfBirth(form.getBorrowerDateOfBirth());

            customer.setMaritalStatus(form.getBorrowerMaritalStatus());
            customer.setNumberOfChildren(form.getBorrowerNumberOfChildren());

            customer.setPhone(form.getBorrowerPhone());
            customer.setMobilePhone(form.getBorrowerMobilePhone());

            Address a = new Address();
            a.setStreet(form.getBorrowerStreet());
            a.setCity(form.getBorrowerCity());
            a.setState(form.getBorrowerState());
            a.setZipcode(form.getBorrowerZipcode());
            a.setCountry(form.getBorrowerCountry());
            customer.setAddress(a);

            customer.setEmail(form.getBorrowerEmail());
            customer.setIncome(form.getBorrowerIncome());
            customer.setOccupation(form.getBorrowerOccupation());
            customer.setLengthOfService(form.getBorrowerLengthOfService());

            String newPin = form.getNewPin();
            String newPinAgain = form.getNewPinAgain();
            if (newPin != null && !newPin.isEmpty()
                    && newPin.equals(newPinAgain)) {
                customer.setPin(newPin);
            }
            save(customer);
        }
        return customer;
    }

    /**
     * Authenticates a {@link Customer} based on his email and pin
     *
     * @param email -- the customer's email
     * @param pin   -- the customer's personal identification number (PIN)
     * @return the corresponding {@link Customer} object if successful,
     * otherwise <code>null</code>
     */
    public Customer authenticateCustomer(String email, String pin) {
        TypedQuery<Customer> query = entityManager.createQuery(
                "select c from Customer as c where c.email = :email and c.pin=:pin",
                Customer.class);
        query.setParameter("email", email);
        query.setParameter("pin", pin);
        try {
            return query.getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    public void deleteCustomer(Customer customer) {
        if (customer != null) {
            Customer foundCustomer = entityManager.find(Customer.class, customer.getCustomerId());
            entityManager.remove(foundCustomer);
        }
    }

    public void deleteCustomer(Long customerId) {
        final Customer customer = new Customer();
        customer.setCustomerId(customerId);
        deleteCustomer(customer);
    }

    public List<Customer> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> criteriaQuery = builder.createQuery(Customer.class);
        Root<Customer> root = criteriaQuery.from(Customer.class);
        criteriaQuery.select(root);
        TypedQuery<Customer> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }

    public Customer getCustomerById(Long customerId) {
        if (customerId == null) {
            // Optionally log a warning here
            return null;
        }
        return entityManager.find(Customer.class, customerId);
    }

    public void save(Customer customer) {
        if (customer != null) {
            entityManager.persist(customer);
        }
    }
}