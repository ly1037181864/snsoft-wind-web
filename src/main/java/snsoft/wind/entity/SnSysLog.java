package snsoft.wind.entity;

import java.io.Serializable;
import java.util.Date;

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
 * <p>创建日期：2018年3月6日 下午8:07:19</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.entity.SnSysLog</p>
 * @version 1.0
 */
@Entity
@Table(name = "sys_log")
public class SnSysLog implements Serializable
{
	private static final long serialVersionUID = -2830028839062786645L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	/** 主键 */
	private Long id;
	@Column()
	/** 用户ID */
	private Long uid;
	@Column()
	/** 日志内容 */
	private String content;
	@Column()
	/** 用户操作 */
	private String operation;
	@Column()
	/** 创建时间 */
	private Date crTime;

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

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getOperation()
	{
		return operation;
	}

	public void setOperation(String operation)
	{
		this.operation = operation;
	}

	public Date getCrTime()
	{
		return crTime;
	}

	public void setCrTime(Date crTime)
	{
		this.crTime = crTime;
	}
}
