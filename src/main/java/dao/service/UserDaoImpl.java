package dao.service;

import entity.Country;
import entity.Skill;
import entity.User;
import entity.UserSkill;
import dao.inter.AbstractDAO;
import dao.inter.UserDaoInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDAO implements UserDaoInter {
    private User getUser(ResultSet rs) throws Exception{
            int id=rs.getInt("id");
            String name=rs.getString("name");
            String surname=rs.getString("surname");
            String email=rs.getString("email");
            String phone=rs.getString("phone");
            Date birthDate=rs.getDate("birthdate");
            String profileDesc=rs.getString("profileDescription");
            int birthPlaceId=rs.getInt("birthplace_id");
            int nationalityId=rs.getInt("nationality_id");
            String birthPlaceStr=rs.getString("birthplace");
            String nationalityStr=rs.getString("nationality");
            
            Country nationality=new Country(nationalityId,null,nationalityStr);
            Country birthPlace=new Country(birthPlaceId,birthPlaceStr,null);
            return new User(id,name,surname,email,phone,profileDesc,birthDate,birthPlace,nationality);
        }
        private UserSkill getUserSkill(ResultSet rs) throws Exception{
            int id=rs.getInt("id");
            int userId=rs.getInt("user_id");
            int skillId =rs.getInt("user_id");
            String skillName=rs.getString("skill_name");
            int power=rs.getInt("power");
            return new UserSkill(id,new User(userId),new Skill(skillId,skillName),power);
        }
    @Override
    public List<User> getAll()  {
        List<User> users=new ArrayList<>();
        try(Connection c=connect();){

        Statement statement= c.createStatement();
        statement.execute("SELECT u.*,c.name as birthplace,n.nationality as nationality " +
                "FROM resumeapp.user u " +
                "left join resumeapp.country n " +
                "on u.nationality_id=n.id " +
                "left join resumeapp.country c " +
                "on u.birthplace_id=c.id;");
        ResultSet rs=statement.getResultSet();
        while(rs.next()){
            User u=getUser(rs);
            users.add(u);
        }}
        catch (Exception ex){
            ex.printStackTrace();
        }
        return users;
    }

    @Override
    public boolean updateUser(User user) {
        try (Connection c=connect();){
            PreparedStatement statement = c.prepareStatement("update user set name=? ,surname=?,email=?,phone=?,profileDescription=?,birthdate=?,birthplace_id=? where id=?");
            statement.setString(1,user.getName());
            statement.setString(2,user.getSurname());
            statement.setString(3,user.getEmail());
            statement.setString(4,user.getPhone());
            statement.setString(5,user.getProfileDesc());
            statement.setDate(6, new java.sql.Date(user.getBirthDate().getTime()));
            statement.setInt(7,user.getBirthPlace().getId());
            statement.setInt(9,user.getId());
            return statement.execute();
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public boolean removeUser(int id) {
        try(Connection c=connect();) {

            Statement statement = c.createStatement();
            boolean b=statement.execute("delete from user where id="+id);
            return b;
        }catch (Exception ex){
            return false;
        }
    }

    @Override
    public User getById(int id) {
        User user=null;
        try(Connection c=connect();){

            Statement statement= c.createStatement();
            statement.execute("SELECT u.*,c.name as birthplace,n.nationality as nationality FROM resumeapp.user u left join resumeapp.country n on u.nationality_id=n.id left join resumeapp.country c on u.birthplace_id=c.id where u.id="+id);
            ResultSet rs=statement.getResultSet();
            while(rs.next()){
                user=getUser(rs);
            }}
        catch (Exception ex){
            ex.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean addUser(User user) {
        try (Connection c=connect();){
            PreparedStatement statement = c.prepareStatement("insert into user(name,surname,email,phone,profileDescription) values(?,?,?,?,?)") ;
            statement.setString(1,user.getName());
            statement.setString(2,user.getSurname());
            statement.setString(3,user.getEmail());
            statement.setString(4,user.getPhone());
            statement.setString(5,user.getProfileDesc());

            return statement.execute();
        }catch (Exception ex){
            return false;
        }
    }


}
