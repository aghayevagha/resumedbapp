package dao.service;

import dao.inter.AbstractDAO;
import dao.inter.CountryDaoInter;
import entity.Country;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter {
    List<Country> countries=new ArrayList<>();
    public static Country getCountry(ResultSet rs) throws Exception{

        String name= rs.getString("name");
        return new Country(null,null,name);
    }
    @Override
    public List<Country> getAllCountries() {
        try(Connection c=connect();){
            Statement statement=c.createStatement();
            statement.execute("select name from resumeapp.country;");
            ResultSet rs=statement.getResultSet();
            while(rs.next()){
            countries.add(getCountry(rs));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return countries;
    }
}
