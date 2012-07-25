package org.springframework.samples.petclinic.hibernate.support;

import java.util.Properties;

import javax.transaction.Transaction;
import javax.transaction.TransactionManager;

import org.hibernate.HibernateException;
import org.hibernate.transaction.TransactionManagerLookup;

/**
 * Transaction lookup support for Hibernate 3.3 in JBoss AS7
 * @author: Ryan Bradley
 */
public class JBossAs7TransactionManagerLookup implements TransactionManagerLookup {

    @Override
    public String getUserTransactionName() {
        return "java:jboss/UserTransaction";
    }

    protected String getName() {
        return "java:jboss/TransactionManager";
    }

	@Override
	public TransactionManager getTransactionManager(Properties props)
			throws HibernateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getTransactionIdentifier(Transaction transaction) {
		// TODO Auto-generated method stub
		return transaction;
	}
}
