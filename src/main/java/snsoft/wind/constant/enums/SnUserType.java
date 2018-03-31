package snsoft.wind.constant.enums;

import com.baomidou.framework.common.IEnum;

/**
 * <p>标题： TODO</p>
 * <p>功能： </p>
 * <p>所属模块： TODO</p>
 * <p>版权： Copyright © 2018 SNSOFT</p>
 * <p>公司: 北京南北天地科技股份有限公司</p>
 * <p>创建日期：2018年3月27日 下午5:17:38</p>
 * <p>类全名：snsoft.wind.constant.enums.SnUserType</p>
 * 作者：liuyou
 * 初审：
 * 复审：
 * 监听使用界面:
 * @version 8.0
 */
public enum SnUserType implements IEnum
{
	MEMBER(0, "普通用户"), ADMIN(1, "管理员");
	private final int key;
	private final String desc;

	SnUserType(final int key, final String desc)
	{
		this.key = key;
		this.desc = desc;
	}

	@Override
	public int key()
	{
		return this.key;
	}

	@Override
	public String desc()
	{
		return this.desc;
	}
}
