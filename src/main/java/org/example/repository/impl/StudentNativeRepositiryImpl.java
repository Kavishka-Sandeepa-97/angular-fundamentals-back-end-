package org.example.repository.impl;

import org.example.repository.StudentNativeRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collections;

@Repository
public class StudentNativeRepositiryImpl implements StudentNativeRepositiry {
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public boolean removeStudent(int id){
        return namedParameterJdbcTemplate.update("delete from Student where id=:id",
                Collections.singletonMap("id",id))>0;
    }

}
