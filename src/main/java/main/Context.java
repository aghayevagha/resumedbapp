package main;

import dao.inter.EmploymentHistoryInter;
import dao.inter.UserDaoInter;
import dao.inter.UserSkillDaoInter;
import dao.service.EmploymentHistoryDaoImpl;
import dao.service.UserDaoImpl;
import dao.service.UserSkillDaoImpl;
import entity.EmploymentHistory;

public class Context {
    public static UserDaoInter instanceUserDAO(){
        return new UserDaoImpl();
    }
    public static UserSkillDaoInter instanceUserSkillDAO(){
        return new UserSkillDaoImpl();
    }
    public static EmploymentHistoryInter EmploymentHistoryDao(){
        return new EmploymentHistoryDaoImpl();
    }

}
