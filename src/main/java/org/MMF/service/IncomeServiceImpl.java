package org.MMF.service;

import org.MMF.dao.IncomeDao;
import org.MMF.model.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IncomeServiceImpl implements IncomeService {
    @Autowired
    private IncomeDao incomeDao;

    @Override
    public void Save(Income income) {
        incomeDao.Save(income);
    }

    @Override
    public List<Income> findBetweenDate(Date fromDate, Date toDate) {
        return incomeDao.findBetweenDate(fromDate, toDate);
    }


}
