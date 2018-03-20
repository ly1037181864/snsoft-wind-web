package snsoft.wind.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月6日 下午8:15:05</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.entity.SnPermission</p>
 * @version 1.0
 */
@Entity
@Table(name = "permission")
public class SnPermission implements Serializable
{
	private static final long serialVersionUID = -3565239461169087334L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	/** 主键 */
	private Long id;
	@Column()
	/** 上级ID */
	private Long pid;
	@Column()
	/** 标题 */
	private String title;
	@Column()
	/** 类型 0、菜单 1、功能 */
	private Integer type;
	@Column()
	/** 状态 0、正常 1、禁用 */
	private Integer state;
	@Column()
	/** 排序 */
	private Integer sort;
	@Column()
	/** 地址 */
	private String url;
	@Column()
	/** 权限编码 */
	private String permCode;
	@Column()
	/** 图标 */
	private String icon;
	@Column()
	/** 描述 */
	private String description;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getPid()
	{
		return pid;
	}

	public void setPid(Long pid)
	{
		this.pid = pid;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Integer getType()
	{
		return type;
	}

	public void setType(Integer type)
	{
		this.type = type;
	}

	public Integer getState()
	{
		return state;
	}

	public void setState(Integer state)
	{
		this.state = state;
	}

	public Integer getSort()
	{
		return sort;
	}

	public void setSort(Integer sort)
	{
		this.sort = sort;
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

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}
