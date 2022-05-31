package main;

import dao.inter.CountryDaoInter;
import dao.inter.EmploymentHistoryInter;
import dao.inter.SkillDaoInter;
import dao.inter.UserDaoInter;
import dao.inter.UserSkillDaoInter;
import dao.service.CountryDaoImpl;
import dao.service.EmploymentHistoryDaoImpl;
import dao.service.SkillDaoImpl;
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
 public static CountryDaoInter instanceCountryDao(){
        return new CountryDaoImpl();
        
    }
 public static SkillDaoInter instanceSkillDao(){
     return new SkillDaoImpl();
 }
}
