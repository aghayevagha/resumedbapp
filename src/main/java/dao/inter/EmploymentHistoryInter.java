package dao.inter;

import entity.EmploymentHistory;

import java.util.List;

public interface EmploymentHistoryInter {
    List<EmploymentHistory> getAllEmploymentHistoryByUserId(int id);
}
