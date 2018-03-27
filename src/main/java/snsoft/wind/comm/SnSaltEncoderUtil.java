package snsoft.wind.comm;

import java.security.MessageDigest;

import com.baomidou.kisso.common.encrypt.Byte2Hex;
import com.baomidou.kisso.common.encrypt.SaltEncoder;

import snsoft.wind.constant.SnBaseConstant;

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
	 * 盐值
	 */
	private String salt;

	/**
	 * 算法
	 */
	private String algorithm;

	protected SnSaltEncoderUtil()
	{
		/* 保护 */
	}

	public SnSaltEncoderUtil(String salt, String algorithm)
	{
		this.salt = salt;
		this.algorithm = algorithm;
	}

	/**
	 * 
	 * <p>
	 * md5 盐值加密字符串
	 * </p>
	 * 
	 * @param salt
	 * 				盐值
	 * @param rawText
	 *				需要加密的字符串
	 * @return
	 */
	public static String md5SaltEncode(String salt, String rawText)
	{
		return new SaltEncoder(salt, SnBaseConstant.ALGORITHM).encode(rawText);
	}

	/**
	 * 
	 * <p>
	 * 判断md5 盐值加密内容是否正确
	 * </p>
	 * 
	 * @param salt
	 * 				盐值
	 * @param encodeText
	 * 				加密后的文本内容
	 * @param rawText
	 * 				加密前的文本内容
	 * @return
	 */
	public static boolean md5SaltValid(String salt, String encodeText, String rawText)
	{
		return new SaltEncoder(salt, SnBaseConstant.ALGORITHM).isValid(encodeText, rawText);
	}

	/**
	 * 
	 * <p>
	 * 字符串盐值加密
	 * </p>
	 * 
	 * @param rawText
	 *            需要加密的字符串
	 * @return
	 */
	public String encode(String rawText)
	{
		try
		{
			MessageDigest md = MessageDigest.getInstance(algorithm);
			//加密后的字符串  
			return Byte2Hex.byte2Hex(md.digest(mergeRawTextAndSalt(rawText).getBytes(SnBaseConstant.ENCODING)));
		} catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * <p>
	 * 判断加密内容是否正确
	 * </p>
	 * 
	 * @param encodeText
	 * 				加密后的文本内容
	 * @param rawText
	 * 				加密前的文本内容
	 * @return
	 */
	public boolean isValid(String encodeText, String rawText)
	{
		return this.encode(rawText).equals(encodeText);
	}

	/**
	 * 
	 * <p>
	 * 合并混淆盐值至加密内容
	 * </p>
	 * 
	 * @param rawText
	 * 				需要加密的字符串
	 * @return
	 */
	private String mergeRawTextAndSalt(String rawText)
	{
		if (rawText == null)
		{
			rawText = "";
		}

		if (this.salt == null || "".equals(this.salt))
		{
			return rawText;
		} else
		{
			StringBuffer mt = new StringBuffer();
			mt.append(rawText);
			mt.append(SnBaseConstant.CUT_SYMBOL);
			mt.append(this.salt);
			return mt.toString();
		}
	}

	public String getSalt()
	{
		return salt;
	}

	public void setSalt(String salt)
	{
		this.salt = salt;
	}

	public String getAlgorithm()
	{
		return algorithm;
	}

	public void setAlgorithm(String algorithm)
	{
		this.algorithm = algorithm;
	}
}
