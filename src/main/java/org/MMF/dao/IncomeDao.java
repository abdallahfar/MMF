package org.MMF.dao;

import org.MMF.model.Income;

import java.util.Date;
import java.util.List;

public interface IncomeDao {
    void Save(Income income);
    List<Income> findBetweenDate(Date fromDate, Date toDate);
}
