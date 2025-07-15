package com.westbank.dao;

import com.westbank.config.SpringTestConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { SpringTestConfiguration.class, com.westbank.config.PersistenceConfiguration.class })
class AgencyDaoTest {

    @Autowired
    private AgencyDao agencyDao;

    @Test
    @Transactional
    void findAll() {
        assertTrue(true);
    }
}