package dao.inter;

import entity.Skill;

import java.sql.Connection;
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
            statement.execute("select name from resumeapp.skill");
            ResultSet resultSet=statement.getResultSet();
            while(resultSet.next()){
                skills.add(getSkill(resultSet));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return skills;
    }
}
