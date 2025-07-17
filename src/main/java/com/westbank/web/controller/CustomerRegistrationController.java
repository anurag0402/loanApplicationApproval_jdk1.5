package com.westbank.web.controller;

import com.westbank.domain.Address;
import com.westbank.domain.Customer;
import com.westbank.domain.MaritalStatus;
import com.westbank.service.CustomerService;
import com.westbank.web.Constants;
import com.westbank.web.form.CustomerRegistrationForm;
import com.westbank.web.validator.CustomerRegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/register.html")
public class CustomerRegistrationController {
    private static final String THIS_VIEW = "customer/register";
    private static final String LOGIN_VIEW = "redirect:/login.html?registered=true";
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerRegistrationValidator validator;
    @ModelAttribute("registrationForm")
    public CustomerRegistrationForm setupForm() {
        return new CustomerRegistrationForm();
    }
    @InitBinder
    protected void initBinder(javax.servlet.http.HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
        final DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        final CustomDateEditor editor = new CustomDateEditor(df, false);
        binder.registerCustomEditor(java.util.Date.class, editor);
    }
    @RequestMapping(method = RequestMethod.GET)
    public String showForm(HttpSession session) {
        session.setAttribute(Constants.SESSION_NAV, Constants.NAV_SIGNUP);
        session.removeAttribute(Constants.SESSION_PROCESS_STATUS);
        session.removeAttribute(Constants.SESSION_PROCESS_STATUS_KEY);
        return THIS_VIEW;
    }
    @RequestMapping(method = RequestMethod.POST)
    public String processRegistration(@ModelAttribute("registrationForm") CustomerRegistrationForm form, BindingResult result, HttpSession session) {
        validator.validate(form, result);
        if (result.hasErrors()) {
            return THIS_VIEW;
        }
        // Check for unique email
        List<Customer> allCustomers = customerService.findAll();
        for (Customer c : allCustomers) {
            if (c.getEmail() != null && c.getEmail().equalsIgnoreCase(form.getEmail())) {
                result.rejectValue("email", "registration.email.exists", new String[]{"Email"}, null);
                return THIS_VIEW;
            }
        }
        // Create and save new Customer
        Customer customer = new Customer();
        customer.setTitle(form.getTitle());
        customer.setFirstName(form.getFirstName());
        customer.setLastName(form.getLastName());
        customer.setDateOfBirth(form.getDateOfBirth());
        customer.setMaritalStatus(form.getMaritalStatus());
        customer.setNumberOfChildren(form.getNumberOfChildren());
        customer.setOccupation(form.getOccupation());
        customer.setIncome(form.getIncome());
        customer.setLengthOfService(form.getLengthOfService());
        customer.setPhone(form.getPhone());
        customer.setMobilePhone(form.getMobilePhone());
        customer.setEmail(form.getEmail());
        customer.setPin(form.getNewPin());
        Address address = new Address();
        address.setStreet(form.getStreet());
        address.setCity(form.getCity());
        address.setState(form.getState());
        address.setZipcode(form.getZipcode());
        address.setCountry(form.getCountry());
        customer.setAddress(address);
        customerService.save(customer);
        session.setAttribute(Constants.SESSION_PROCESS_STATUS, Constants.PROCESS_STATUS_OK);
        session.setAttribute(Constants.SESSION_PROCESS_STATUS_KEY, Constants.MSG_SIGNUP_OK);
        return LOGIN_VIEW;
    }
} 