package cn.edu.xhu.app.util.dao;

/**
 * @IDE: Created by IntelliJ IDEA.
 * @Author: 千千寰宇
 * @Date: 2018/9/28  04:28:26
 * @Description: ...
 */
/**
 *
 * @author Zen Johnny
 * @date 2017年11月11日 下午5:19:40
 *
 */

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import cn.edu.xhu.app.util.Pager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class BaseDaoImpl<T> implements IBaseDao<T> {
    @Resource
    private static SessionFactory sessionFactory;
    private Class<T> clazz;

    static {
        sessionFactory = HibernateSessionFactory.getSessionFactory();
    }



    /**
     *
     */
    public BaseDaoImpl() {
        super();
        this.sessionFactory = sessionFactory;

        //使用反射技术得到T的真实类型
        //获取当前new的对象的泛型的父类
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        //获取第一个类型参数的真实类型
        this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
        System.out.println("[BaseDaoImpl#constructor] clazz--->"+clazz);
    }

    public BaseDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;

        //使用反射技术得到T的真实类型
        //获取当前new的对象的泛型的父类
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        //获取第一个类型参数的真实类型
        this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
        System.out.println("[BaseDaoImpl#constructor] clazz--->"+clazz);
    }

    /**
     * 获取当前可用的Session对象
     * @return
     */
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    /**
     * 为设参的hql创建Query的公共方法,args是可选的，非必选
     * @notice 无参数args时，必须设置为 new Object[]{},不能设置为null，否则出现空指针异常
     */
    protected Query createQueryWithParameters(String hql,Object[] args) {
        Query query = null;
    	//query = getSession().createQuery(hql);
        query = HibernateSessionFactory.getSession().createQuery(hql);

        System.out.println("[BaseDaoImpl#createQueryWithParameters] args:" + args);
        System.out.println("[BaseDaoImpl#createQueryWithParameters] query:" + query);

        if(args.length > 0) {
            for(int i = 0, size = args.length; i < size; i++) {
                query.setParameter(i, args[i]);
            }
        }

        return query;
    }

    /**
     * 创建hql的公共count聚集函数
     * @return hql:String
     */
    protected Integer countRows(String hql,Object[] args) {
        hql = hql.trim();

//    	System.out.println("[#countRows:test 01] hql:" + hql);

        String newHql = hql.trim().substring(0, hql.indexOf("from"));

//    	System.out.println("[#countRows:test 02] newHql:" + newHql);

        if(newHql == null || newHql.equals("")) {
            hql = "select count(*) " + hql;
            newHql = "select count(*)";
        }
        hql = hql.replace(newHql, "select count(*) ");
//    	System.out.println("[#countRows:test 03] hql:" + hql);
        hql = hql.replace("fetch", "");

        Query query = createQueryWithParameters(hql,args);
        //当确定返回的实例只有一个或者null时 用uniqueResult()方法,返回Long型
        return Integer.valueOf(query.uniqueResult().toString());
    }

    @Override
    public void save(T T) {
        getSession().save(T);
    }

    @Override
    public void save(List<T> Ts) {
        for(T T : Ts)
            getSession().save(T);
    }

    @Override
    public void update(T T) {
        getSession().update(T);
    }

    @Override
    public void update(List<T> Ts) {
        for(T T : Ts)
            getSession().update(T);
    }

    @Override
    public void delete(T T) {
        getSession().delete(T);
    }

    @Override
    public void delete(List<T> Ts) {
        for(T T : Ts)
            getSession().delete(T);
    }

    @Override
    public List<T> list(String hql, Object[] args) {
        return createQueryWithParameters(hql, args).list();
    }

    @Override
    public List<T> list(String hql, Object arg) {
        if(arg != null)
            return createQueryWithParameters(hql, new Object[]{arg}).list();
        else
            return createQueryWithParameters(hql, new Object[] {}).list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> list(String hql) {
        return createQueryWithParameters(hql, new Object[] {}).list();
    }

    @Override
    public Pager<T> find(String hql, Object[] args, int curPage) {
        return new Pager<T>(
                curPage, //当前页码
                10,//系统设置的，默认每页记录数量
                countRows(hql, args), //总记录数
                list(hql, args)//数据对象
        );
    }

    @Override
    public Pager<T> find(String hql, Object arg, int curPage) {
        if(arg != null)
            return find(hql, new Object[] {arg}, curPage);
        else
            return find(hql, new Object[] {}, curPage);
    }

    @Override
    public Pager<T> find(String hql,int curPage) {
        return find(hql, new Object[] {}, curPage);
    }

    @Override
    public Object findOne(String hql, Object[] args) {
        Query query = createQueryWithParameters(hql, args);
        return query.uniqueResult();
    }

    @Override
    public Object findOne(String hql, Object arg) {
        if(arg == null)
            return findOne(hql, new Object[] {});
        else
            return findOne(hql,new Object[]{ arg });
    }

    @Override
    public Object findOne(String hql) {
        return findOne(hql, new Object[] {});
    }

    @Override
    public void executeByHql(String hql, Object[] args) {
        createQueryWithParameters(hql, args).executeUpdate();
    }

    @Override
    public void executeByHql(String hql, Object arg) {
        executeByHql(hql,new Object[] {});
    }

    @Override
    public void executeByHql(String hql) {
        executeByHql(hql,new Object[] {});
    }

}
