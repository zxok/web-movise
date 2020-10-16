package com.qf.hzx.dao;

import com.qf.hzx.dao.impl.TFilmDaoImpl;
import com.qf.hzx.entity.TFilm;
import org.junit.Test;

import java.util.List;

/**
 * @program: maven-demo
 * @author: hzx
 * @since: JDK 1.8
 * @create: 2020-10-15 20:00
 **/
public class TFilmDaoTest {

    TFilmDao tFilmDao = new TFilmDaoImpl();

    @Test
    public void getTFileAllTest() {
        List<TFilm> list = tFilmDao.getTFilmAll();
        System.out.println(list);
    }
}
