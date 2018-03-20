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
 * <p>创建日期：2018年3月6日 下午7:54:54</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.entity.SnUserRole</p>
 * @version 1.0
 */
@Entity
@Table(name = "user_role")
public class SnUserRole implements Serializable
{
	private static final long serialVersionUID = -7058734217759450484L;
	/** 主键 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	private Long id;
	/** 用户ID */
	@Column()
	private Long uid;
	/** 角色ID */
	@Column()
	private Long rid;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getUid()
	{
		return uid;
	}

	public void setUid(Long uid)
	{
		this.uid = uid;
	}

	public Long getRid()
	{
		return rid;
	}

	public void setRid(Long rid)
	{
		this.rid = rid;
	}
}
