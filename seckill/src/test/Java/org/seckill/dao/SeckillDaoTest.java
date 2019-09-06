package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * 配置spring和junit整合 junit启动时加载springIOC容器
 * spring-test, junit
 */

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

    //注入DAO实现类依赖
    @Autowired
    private SeckillDao seckillDao;

    @Test
    public void testQueryById() throws Exception{
        long id = 1012L;
        Seckill seckill = seckillDao.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
        /**
         * 1000元秒杀iPhone x
         * Seckill
         * {seckillId=1012,
         * name='1000元秒杀iPhone x',
         * number=100,
         * startTime=Mon Jul 15 08:00:00 CST 2019,
         * endTime=Tue Jul 16 08:00:00 CST 2019,
         * createTime=Mon Jul 01 23:41:21 CST 2019}
         */
    }

    @Test
    public void testQueryAll() throws Exception{
        List<Seckill> seckills = seckillDao.queryAll(0, 100);
        for(Seckill seckill : seckills){
            System.out.println(seckill);
        }
    }
    @Test
    public void testReduceNumber() throws Exception{
        Date killTime = new Date();
        int updateCount = seckillDao.reduceNumber(1012L, killTime);
        System.out.println("updateCount=" + updateCount);
    }
}