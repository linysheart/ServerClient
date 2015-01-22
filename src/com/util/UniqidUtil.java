package com.util;

import java.util.HashSet;
import java.util.Set;

/**
 * 唯一值生成工具类
 * @author 
 * @version[1.0]
 */
public class UniqidUtil {
	
	// 计数器，每次生成递增 1
	static protected long counter = 0L;
	
	/**
	 * 生成唯一
	 * 
	 * @return
	 */
	synchronized static public String createPrimaryKey() {
	    long mod = (counter++)%1000;
	    String pre = "";
	    if(mod > 100){
	        pre += ("0" + mod);
	    }
	    else if(mod < 10)
	        pre += ("000" + mod);
	    else
	        pre += ("00" + mod);
		return "" + System.currentTimeMillis() + pre;
	}
	/**
	 * 生成唯一的15位数字
	 * @param args
	 * void
	 * @throws
	 */
	synchronized static public String create15PrimaryKey() {
	    
        return "" + System.currentTimeMillis() + (counter ++)+(int)(Math.random()*10);
    }
	public static void main(String[] args) {
        System.out.println(create15PrimaryKey());
        Set<String> set = new HashSet<String>();
        Long t = System.currentTimeMillis()+1000;
        Long sum = 0L;
        while(true){
            if(System.currentTimeMillis()>=t){
                break;
            }
            sum ++;
//            String s = UniqidUtil.createPrimaryKey();
//            System.out.println(s);
//            if(set.contains(s)){
//                System.out.println(set);
//                break;
//            }
//            set.add(s);
        }
        System.out.println(sum);
    }
}
