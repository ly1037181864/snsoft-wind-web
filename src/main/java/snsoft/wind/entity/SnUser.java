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
 * <p>创建日期：2018年3月6日 下午8:03:49</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.entity.SnUser</p>
 * @version 1.0
 */
@Entity
@Table(name = "user")
public class SnUser implements Serializable
{
	private static final long serialVersionUID = -5638124756724901875L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column()
	/** 主键ID */
	private Long id;
	@Column()
	/** 登录名称 */
	private String loginName;
	@Column()
	/** 密码 */
	private String password;
	@Column()
	/** 邮箱 */
	private String email;
	@Column()
	/** 0、普通用户 1、管理员 */
	private Integer type;
	@Column()
	/** 0、禁用 1、正常 */
	private Integer status;
	@Column()
	/** 创建时间 */
	private Date crTime;
	@Column()
	/** 最后登录时间 */
	private Date lastTime;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getLoginName()
	{
		return loginName;
	}

	public void setLoginName(String loginName)
	{
		this.loginName = loginName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Integer getType()
	{
		return type;
	}

	public void setType(Integer type)
	{
		this.type = type;
	}

	public Integer getStatus()
	{
		return status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public Date getCrTime()
	{
		return crTime;
	}

	public void setCrTime(Date crTime)
	{
		this.crTime = crTime;
	}

	public Date getLastTime()
	{
		return lastTime;
	}

	public void setLastTime(Date lastTime)
	{
		this.lastTime = lastTime;
	}
}
