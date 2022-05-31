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
            int usId=rs.getInt("us_id");
            int skillId =rs.getInt("skill_id");
            String skillName=rs.getString("skill_name");
            int power=rs.getInt("power");
            return new UserSkill(usId,new User(id),new Skill(skillId,skillName),power);
        }

    @Override
    public List<UserSkill> getAllSkillByUserId(int id) {
        List<UserSkill> userSkills=new ArrayList<>();
        try(Connection c=connect();){
            PreparedStatement statement= c.prepareStatement("select u.*,us.id as us_id ,s.id as skill_id, s.name as skill_name,us.power as power "
                    + " from resumeapp.user_skill us"
                    + " left join resumeapp.user u on us.user_id=u.id "
                    + "left join resumeapp.skill s on us.skill_id=s.id "
                    + "where us.user_id=?;");
            statement.setInt(1,id);
            statement.execute();
            ResultSet rs=statement.getResultSet();
            while(rs.next()){
             userSkills.add(getUserSkill(rs));
            }}
        catch (Exception ex){
            ex.printStackTrace();
        }
        return userSkills;
    }

    @Override
    public boolean deleteUserSkill(int id) {
         try(Connection c=connect();){
            PreparedStatement statement= c.prepareStatement("delete from resumeapp.user_skill where id=?");
            statement.setInt(1,id);
           return  statement.execute();
           
          }
        catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean addUserSkill(UserSkill us) {
        try(Connection c=connect();){
            PreparedStatement statement= c.prepareStatement("insert into user_skill(user_id,skill_id,power) values(?,?,?)");
            
            statement.setInt(1,us.getUser().getId());
            statement.setInt(2,us.getSkill().getId());
            statement.setInt(3,us.getPower());
           return  statement.execute();
           
          }
        catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    
}
