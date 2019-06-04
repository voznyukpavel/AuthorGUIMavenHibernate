/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.authorguimavenhibernate.util;

import com.mycompany.authorguimavenhibernate.DAO.DAOClass;
import com.mycompany.authorguimavenhibernate.DAO.DAOInterface;

/**
 *
 * @author Pavel
 */
public class Factory {

    private static DAOInterface daointerface = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public DAOInterface getPersonDAO() {
        if (daointerface == null) {
            daointerface = new DAOClass();
        }
        return daointerface;
    }

}
