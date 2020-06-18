package org.MMF.service;

import org.MMF.model.Income;

import java.util.Date;
import java.util.List;

public interface IncomeService {
    void Save(Income income);
    List<Income> findBetweenDate(Date fromDate, Date toDate);
}
