package org.codetrials.server.service.dao;

import junit.framework.TestCase;

import java.util.List;

public class MySqlBundleDAOTest extends TestCase {

    public void testGetAllBundlesDescriptions() throws Exception {
        int a = new MySqlBundleDAO().addBundle("title", null);
    }
}