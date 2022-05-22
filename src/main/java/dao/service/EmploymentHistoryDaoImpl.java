package dao.service;

import dao.inter.AbstractDAO;
import dao.inter.EmploymentHistoryInter;
import dao.inter.UserSkillDaoInter;
import entity.EmploymentHistory;
import entity.Skill;
import entity.User;
import entity.UserSkill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryInter {

        private EmploymentHistory getEmploymentHistory(ResultSet rs) throws Exception{
            String header= rs.getString("header");
            String jobDescribe=rs.getString("jobDescription");
            Date beginDate=rs.getDate("begin_date");
            Date endDate=rs.getDate("end_date");
            int userIdd= rs.getInt("user_id");

            return new EmploymentHistory(null,header,beginDate,endDate,jobDescribe,new User(userIdd));}

    @Override
    public List<EmploymentHistory> getAllEmploymentHistoryByUserId(int id) {
        List<EmploymentHistory> employmentHistories=new ArrayList<>();
        try(Connection c=connect();){
            PreparedStatement statement= c.prepareStatement("select * from resumeapp.employment_history where user_id=?;");
            statement.setInt(1,id);
            statement.execute();
            ResultSet rs=statement.getResultSet();
            while(rs.next()){

                employmentHistories.add(getEmploymentHistory(rs));
            }}
        catch (Exception ex){
            ex.printStackTrace();
        }
        return employmentHistories;
    }
}
