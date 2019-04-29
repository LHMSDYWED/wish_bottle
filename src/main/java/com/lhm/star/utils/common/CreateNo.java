package com.lhm.star.utils.common;

import java.util.Random;
import java.util.UUID;

/**
 * @author liyang
 * @version 1.0 2019年3月7日
 */
public class CreateNo {

	private SnowflakeIdWorkerTwo idWorker = null;
    /**
     * 私有构造器
     */
    private CreateNo(){
    	idWorker = new SnowflakeIdWorkerTwo(new Random().nextInt(1023) + 1);
    };

    private static CreateNo order=null;

    /**
     * 单例模式--懒汉模式
     * @return
     */
    public static synchronized CreateNo getInstance() {
        if (order == null) {
            order = new CreateNo();
        }
        return order;
    }


   /**
    * 
    * @param pre 前缀
    * @param size 生成位数(除前缀)，1~49之间
    * @return
    */
    public synchronized String GenerateNo(String pre,int size) {
    	
    	if(size > 49 || size < 1)
    		return pre;
        StringBuilder sb=new StringBuilder();
        sb.append(UUID.randomUUID().toString().replace("-", ""));
        sb.append(idWorker.nextId());
        return pre + sb.toString().substring(49-size);
    }

    /**
     * 编号转换成生成时间
     * @param no
     * @return
     */
    public String convert(String no)
    {
    	long id = Long.parseLong(no.substring(no.length() -17));
    	return idWorker.transTimeToFormat(idWorker.expId(id)[2]);
    }

//    public static void main(String[] args) {
////    	for (int i = 0; i < 10; i++) {
////    		System.out.println(CreateNo.getInstance().GenerateNo("81107",18));
////		}
//    	System.out.println(CreateNo.getInstance().convert("72942599898820608"));
//    }

}
