package com.qf.hzx.service.impl;

import com.qf.hzx.dao.TFilmDao;
import com.qf.hzx.dao.impl.TFilmDaoImpl;
import com.qf.hzx.entity.TFilm;
import com.qf.hzx.service.TFilmService;

import java.util.List;

/**
 * @program: maven-demo
 * @author: hzx
 * @since: JDK 1.8
 * @create: 2020-10-15 19:34
 **/
public class TFilmServiceImpl implements TFilmService {

    TFilmDao tFilmDao = new TFilmDaoImpl();

    @Override
    public List<TFilm> getTFilmAll() {
        return tFilmDao.getTFilmAll();
    }
}
