package dao.inter;

import entity.User;
import entity.UserSkill;

import java.util.List;

public interface UserDaoInter {
    List<User> getAll() ;
    boolean updateUser(User user) ;
    //User saveUser(User user);
    boolean removeUser(int id);
    User getById(int id);
    boolean addUser(User user);



}
