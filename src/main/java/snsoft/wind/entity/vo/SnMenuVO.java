package snsoft.wind.entity.vo;

import java.io.Serializable;
import java.util.List;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月6日 下午8:17:13</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.entity.vo.SnMenuVO</p>
 * @version 1.0
 */
public class SnMenuVO implements Serializable
{
	private static final long serialVersionUID = -4933376825948485216L;
	/** 主键 */
	private Long id;
	/** 标题 */
	private String title;
	/** 地址 */
	private String url;
	/** 权限编码 */
	private String permCode;
	/** 图标 */
	private String icon;
	private List<SnMenuVO> mvList;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getPermCode()
	{
		return permCode;
	}

	public void setPermCode(String permCode)
	{
		this.permCode = permCode;
	}

	public String getIcon()
	{
		return icon;
	}

	public void setIcon(String icon)
	{
		this.icon = icon;
	}

	public List<SnMenuVO> getMvList()
	{
		return mvList;
	}

	public void setMvList(List<SnMenuVO> mvList)
	{
		this.mvList = mvList;
	}
}
