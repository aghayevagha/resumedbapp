package dao.inter;

import entity.User;
import entity.UserSkill;

import java.util.List;

public interface UserSkillDaoInter {

    List<UserSkill> getAllSkillByUserId(int id);


}
