package com.qf.hzx.service;

import com.qf.hzx.entity.TFilm;

import java.util.List;

public interface TFilmService {

    //获取首页展示的数据
    List<TFilm> getTFilmAll();
}
