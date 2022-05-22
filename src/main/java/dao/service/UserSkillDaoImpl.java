package dao.service;

import dao.inter.AbstractDAO;
import dao.inter.UserDaoInter;
import dao.inter.UserSkillDaoInter;
import entity.Country;
import entity.Skill;
import entity.User;
import entity.UserSkill;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {

        private UserSkill getUserSkill(ResultSet rs) throws Exception{
            int id=rs.getInt("id");
            int userId=rs.getInt("user_id");
            int skillId =rs.getInt("user_id");
            String skillName=rs.getString("skill_name");
            int power=rs.getInt("power");
            return new UserSkill(id,new User(userId),new Skill(skillId,skillName),power);
        }

    @Override
    public List<UserSkill> getAllSkillByUserId(int id) {
        List<UserSkill> userSkills=new ArrayList<>();
        try(Connection c=connect();){
            PreparedStatement statement= c.prepareStatement("select u.*,s.id as skill_id, s.name as skill_name from resumeapp.user_skill us " +
                    "left join user u on us.user_id=u.id " +
                    "left join skill s on us.skill_id=s.id " +
                    "where us.user_id=?;");
            statement.setInt(1,id);
            ResultSet rs=statement.getResultSet();
            while(rs.next()){
             userSkills.add(getUserSkill(rs));
            }}
        catch (Exception ex){
            ex.printStackTrace();
        }
        return userSkills;
    }
}
