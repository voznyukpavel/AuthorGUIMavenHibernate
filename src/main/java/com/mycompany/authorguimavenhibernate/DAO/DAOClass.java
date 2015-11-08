 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.authorguimavenhibernate.DAO;

import com.mycompany.authorguimavenhibernate.pojos.Person;
import com.mycompany.authorguimavenhibernate.util.HibernateUtil;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

/**
 *
 * @author Pavel
 */
public class DAOClass implements DAOInterface {

    @Override
    public void addPerson(Person person) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O Add", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void updatePerson(Person person) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(person);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O updateStudent", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public List<Person> findbyLogin(String login) throws SQLException {
        Session session = null;

        List<Person> persons = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria crit = session.createCriteria(Person.class);
            persons = crit.add(Expression.like("login", login + "%")).list();

        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return persons;
    }

    @Override
    public List findAll() throws SQLException {
        Session session = null;
        List<Person> persons = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            persons = session.createCriteria(Person.class).list();
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O getAllStudents()", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return persons;
    }

    @Override
    public void deletePerson(Person person) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(person);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O deleteStudent", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
