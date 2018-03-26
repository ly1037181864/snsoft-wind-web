package snsoft.wind.comm;

import java.security.MessageDigest;

import com.baomidou.kisso.common.encrypt.base64.Base64;

/**
 * <p>标题： TODO</p>
 * <p>功能： </p>
 * <p>所属模块： TODO</p>
 * <p>版权： Copyright © 2018 SNSOFT</p>
 * <p>公司: 北京南北天地科技股份有限公司</p>
 * <p>创建日期：2018年3月26日 下午6:12:13</p>
 * <p>类全名：snsoft.wind.comm.SnSaltEncoderUtil</p>
 * 作者：liuyou
 * 初审：
 * 复审：
 * 监听使用界面:
 * @version 8.0
 */
public class SnSaltEncoderUtil
{
	/**
	 * 将传入的src加密处理
	 * @param src 明文字符串
	 * @return 加密后的字符串结果
	 * @throws Exception 
	 */
	public static String md5(String src)
	{
		try
		{
			//将字符串信息采用MD5处理
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] output = md.digest(src.getBytes());
			//将MD5处理结果利用Base64转成字符串
			String s = Base64.toBase64String(output);
			return s;
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}
}
