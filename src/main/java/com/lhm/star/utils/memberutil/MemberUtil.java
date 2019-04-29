/**
 * 
 */
package com.lhm.star.utils.memberutil;



import com.lhm.star.utils.common.CreateNo;
import com.lhm.star.utils.common.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liyang
 * @version 1.0 2019年3月7日
 */
public class MemberUtil {

	/**
	 * 获取会员uuid
	 · KH（客户）+年份后两位+月份+日期+六位随机数字（不重复）
	 · 时间取于生成客户ID的时间
	 * @return
	 */
	public static String getMemberUuid() {
		String kh = "KH"+ DateUtil.formatTimeForYyMmDd();
		return CreateNo.getInstance().GenerateNo(kh, 6);
	}

	/**
	 * 初始化会员昵称
	 *
	 * @return
	 */
	public static String getMemberNickname(String nickname) {
		return CreateNo.getInstance().GenerateNo(nickname, 6);
	}
	/**
	 * 获取检测档案ID    JCDA（检测档案）+客户ID的随机八位数字+六位数字
	 *
	 * @return
	 */
	public static String getArchivesId(String memberUuid) {
		String jcda = "JCDA"+memberUuid.substring(memberUuid.length()-8);
		return CreateNo.getInstance().GenerateNo(jcda, 6);
	}



}
