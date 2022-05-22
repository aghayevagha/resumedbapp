package main;

import dao.inter.*;
import dao.service.CountryDaoImpl;

public class Main {
    public static void main(String[] args) throws Exception {
      //  UserDaoInter userDaoInter=Context.instanceUserDAO();
      //  UserSkillDaoInter userSkillDaoInter=Context.instanceUserSkillDAO();
       EmploymentHistoryInter employmentHistoryInter=Context.EmploymentHistoryDao();
       // System.out.println(userDaoInter.getById(1));
        System.out.println(employmentHistoryInter.getAllEmploymentHistoryByUserId(1));



    }


    }

