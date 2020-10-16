package com.qf.hzx.servlet;

import com.qf.hzx.entity.TFilm;
import com.qf.hzx.resp.BaseResponseEntity;
import com.qf.hzx.service.TFilmService;
import com.qf.hzx.service.impl.TFilmServiceImpl;
import com.qf.hzx.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.temporal.TemporalField;
import java.util.List;


/**
 *
 * 协议号 + ip地址+端口 必须一致才不会跨域
 *
 *
 * get select
 * put update
 * delete
 * http://localhost:8080/api/user/register
 * post 请求 insert
 * Jackson
 * Fastjson
 * 写符合企业规范的代码
 */
@WebServlet("/ServletIndex")
public class ServletIndex extends HttpServlet {
    // 后期该代码需要优化
    private TFilmService tFilmService = new TFilmServiceImpl();
    /**
     *  返回首页数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException      返回json数据
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 解析成list对象
         * 要解析的json字符串
         */
        /*List<User> users = JSONObject.parseArray("", User.class);
        User user1 = JSONObject.parseObject("", User.class);
        result=JSONObject.toJSONString(entity);*/

        //将该对象转换json
        List<TFilm> list = tFilmService.getTFilmAll();
        BaseResponseEntity<List<TFilm>> entity = BaseResponseEntity.success(list);
        ResponseUtils.responseToJson(resp, entity);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //doPost(req, resp);
        //将该对象转换json
        List<TFilm> list = tFilmService.getTFilmAll();
        BaseResponseEntity<List<TFilm>> entity = BaseResponseEntity.success(list);
        ResponseUtils.responseToJson(resp, entity);
    }
}
