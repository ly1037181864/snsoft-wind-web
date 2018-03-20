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
 * <p>创建日期：2018年3月6日 下午8:10:15</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.entity.SnRolePermission</p>
 * @version 1.0
 */
@Entity
@Table(name = "role_permission")
public class SnRolePermission implements Serializable
{
	private static final long serialVersionUID = 4194321487935824513L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	/** 主键 */
	private Long id;
	@Column()
	/** 角色ID */
	private Long rid;
	@Column()
	/** 权限ID */
	private Long pid;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getRid()
	{
		return rid;
	}

	public void setRid(Long rid)
	{
		this.rid = rid;
	}

	public Long getPid()
	{
		return pid;
	}

	public void setPid(Long pid)
	{
		this.pid = pid;
	}
}
