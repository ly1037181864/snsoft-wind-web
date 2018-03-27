package snsoft.wind.dao;

import java.util.List;

import snsoft.wind.entity.SnSysLog;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月6日 下午8:27:02</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.dao.ISnSysLogDao</p>
 * @version 1.0
 */
public interface ISnSysLogDao extends ISnSuperDao<SnSysLog>
{
	/**分页查询
	 * @param size
	 * @param index
	 * @return
	 */
	public List<SnSysLog> queryByPage(int index, int size);
}
