package cn.edu.xhu.app.util.dao;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/27  21:51:15
 * @Description: ...
 */
/**
 *
 * @author Zen Johnny
 * @date 2017年11月11日 下午12:59:50
 *
 */

import cn.edu.xhu.app.util.Pager;

import java.util.List;

public interface IBaseDao<T> {
    /**
     * add a T
     * @param T T
     */
    public void save(T T);

    /**
     * add  Ts
     */
    public void save(List<T> Ts);

    /**
     * update a T
     */
    public void update(T T);

    /**
     * update Ts
     */
    public void update(List<T> Ts);

    /**
     * delete a T
     */
    public void delete(T T);

    /**
     * delete Ts
     */
    public void delete(List<T> Ts);

    /**
     * 通过hql获取一组对象，不进行分页
     */
    public List<T> list(String hql, Object[] args);
    public List<T> list(String hql, Object arg);
    public List<T> list(String hql);


    /**
     * 通过hql获取一组对象，进行分页
     */
    public Pager<T> find(String hql, Object[] args, int curPage);
    public Pager<T> find(String hql, Object arg, int curPage);
    public Pager<T> find(String hql, int curPage);

    /**
     * 通过hql获取一个对象
     */
    public Object findOne(String hql, Object[] args);
    public Object findOne(String hql, Object arg);
    public Object findOne(String hql);

    /**
     * 通过hql更细一组对象
     */
    public void executeByHql(String hql,Object[] args);
    public void executeByHql(String hql,Object arg);
    public void executeByHql(String hql);

}