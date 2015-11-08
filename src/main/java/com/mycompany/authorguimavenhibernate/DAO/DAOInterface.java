/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.authorguimavenhibernate.DAO;

import com.mycompany.authorguimavenhibernate.pojos.Person;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Pavel
 */
public interface DAOInterface {

    public void addPerson(Person person) throws SQLException;

    public void updatePerson(Person person) throws SQLException;

    public List<Person> findbyLogin(String login) throws SQLException;

    public List findAll() throws SQLException;

    public void deletePerson(Person person) throws SQLException;
}
