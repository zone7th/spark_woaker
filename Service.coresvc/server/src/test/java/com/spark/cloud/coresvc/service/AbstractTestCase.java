package com.spark.cloud.coresvc.service;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=true)
@Transactional
@ContextConfiguration(locations = "classpath:/META-INF/spring/applicationContext.xml")
public abstract class AbstractTestCase {
	protected final Logger log = LoggerFactory.getLogger(getClass());
}
