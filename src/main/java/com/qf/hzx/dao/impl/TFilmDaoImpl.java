package com.qf.hzx.dao.impl;

import com.qf.hzx.dao.TFilmDao;
import com.qf.hzx.entity.TFilm;
import com.qf.hzx.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: maven-demo
 * @author: hzx
 * @since: JDK 1.8
 * @create: 2020-10-15 19:27
 **/
public class TFilmDaoImpl implements TFilmDao {
    @Override
    public List<TFilm> getTFilmAll() {
        Connection conn = DBUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<TFilm> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement("select name,type_name,on_decade from t_film");
            rs = ps.executeQuery();
            while (rs.next()) {
                TFilm tFilm = new TFilm();
                tFilm.setName(rs.getString(1));
                tFilm.setTypeName(rs.getString(2));
                tFilm.setOnDecade(rs.getString(3));
                list.add(tFilm);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtils.closeAll(conn,ps,rs);
        }

        return list;
    }
}
