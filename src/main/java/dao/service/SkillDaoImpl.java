package dao.service;

import dao.inter.AbstractDAO;
import dao.inter.SkillDaoInter;
import entity.Skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {
    private Skill getSkill(ResultSet rs) throws Exception{
        String name=rs.getString("name");
        return new Skill(null,name);
    }
    @Override
    public List<Skill> getAllSkill()  {
        List<Skill> skills=new ArrayList<>();
        try(Connection c=connect();){
            Statement statement=c.createStatement();
            statement.execute("select * from resumeapp.skill");
            ResultSet resultSet=statement.getResultSet();
            while(resultSet.next()){
                skills.add(getSkill(resultSet));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return skills;
    }

    @Override
    public boolean addSkill(Skill skill){
        try(Connection c=connect();){
            PreparedStatement statement= c.prepareStatement("insert into resumeapp.skill(name) values(?)",Statement.RETURN_GENERATED_KEYS);
            
          //  statement.setInt(1,skill.getId());
            statement.setString(1,skill.getName());
           boolean b=statement.execute();
           ResultSet geneKeys=statement.getGeneratedKeys();
           if(geneKeys.next()){
               skill.setId(geneKeys.getInt(1));
           }
           return b;
          }
        catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    }
    

