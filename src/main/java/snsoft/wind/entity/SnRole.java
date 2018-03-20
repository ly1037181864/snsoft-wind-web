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
 * <p>创建日期：2018年3月6日 下午8:13:25</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.entity.SnRole</p>
 * @version 1.0
 */
@Entity
@Table(name = "role")
public class SnRole implements Serializable
{
	private static final long serialVersionUID = -5471815518038002296L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	/** 主键 */
	private Long id;
	@Column()
	/** 角色 */
	private String name;
	@Column()
	/** 排序 */
	private Integer sort;
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

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Integer getSort()
	{
		return sort;
	}

	public void setSort(Integer sort)
	{
		this.sort = sort;
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
