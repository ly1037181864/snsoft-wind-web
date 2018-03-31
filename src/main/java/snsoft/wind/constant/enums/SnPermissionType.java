package snsoft.wind.constant.enums;

import com.baomidou.framework.common.IEnum;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月7日 上午10:00:36</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.common.enums.SnPermissionType</p>
 * @version 1.0
 */
public enum SnPermissionType implements IEnum
{
	MENU(0, "菜单"), OPERATION(1, "功能");
	private final int key;
	private final String desc;

	SnPermissionType(final int key, final String desc)
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
