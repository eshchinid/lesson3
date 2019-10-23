package com.example.lesson3.JDBC.repository;

import com.example.lesson3.JDBC.model.PersonJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
import java.util.UUID;

@Repository
public class PersonJDBCRepository {

    private final RowMapper<PersonJDBC> rowMapper;
    private final JdbcTemplate template;


    @Autowired
    PersonJDBCRepository(DataSource dataSource)
    {
        this.template = new JdbcTemplate(dataSource);
        this.rowMapper = BeanPropertyRowMapper.newInstance(PersonJDBC.class);

    }


    public List<PersonJDBC> findAll(){
        return template.query("select * from public.persons", rowMapper);
    }

    public PersonJDBC getById(UUID id){
        String sql = String.format("select id, name, email, phone from public.persons where id='%s'", id);
        return DataAccessUtils.singleResult(template.query(sql, rowMapper));
    }

    public UUID create(PersonJDBC personJDBC){
        try {
            String sql = String.format("INSERT INTO public.persons (name, email, phone) VALUES('%s', '%s', '%s') returning id",
                    personJDBC.getName(), personJDBC.getEmail(), personJDBC.getPhone());
            UUID id = template.queryForObject(sql, null, UUID.class);
            return id;
        }catch (Exception e){
            return null;
        }
    }


    public Boolean update(PersonJDBC personJDBC){
        try {
            String sql = String.format("UPDATE public.persons SET name='%s', email='%s', phone='%s' where id=%s", personJDBC.getName(), personJDBC.getEmail(), personJDBC.getPhone());
            template.execute(sql);
            return true;
        }catch (Exception e){
            return false;
        }
    }


    public Boolean delete(UUID id){
        try {
            String sql = String.format("DELETE FROM public.persons where id='%s'", id);
            template.execute(sql);
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
