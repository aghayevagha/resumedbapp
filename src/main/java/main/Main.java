package main;

import dao.inter.*;
import dao.service.CountryDaoImpl;

public class Main {
    public static void main(String[] args) throws Exception {
       UserSkillDaoInter us=Context.instanceUserSkillDAO();
        System.out.println(us.getAllSkillByUserId(1));


    }


    }

