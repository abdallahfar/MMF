package org.MMF.dao;

import org.MMF.model.Income;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class IncomeDaoImpl implements IncomeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void Save(Income income) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(income);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Income> findBetweenDate(Date fromDate, Date toDate) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Income.class);
        criteria.add(Restrictions.between("transaction_date", fromDate, toDate));
        List<Income> result = criteria.list();
        session.close();
        return result;
    }


}
