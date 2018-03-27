package snsoft.wind.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import snsoft.wind.dao.ISnSysLogDao;
import snsoft.wind.entity.SnSysLog;
import snsoft.wind.service.ISnSysLogService;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月7日 上午9:33:33</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.springwind.service.impl.SnSysLogServiceImpl</p>
 * @version 1.0
 */
@Service("sn-SnSysLogService")
public class SnSysLogServiceImpl implements ISnSysLogService
{
	@Resource(name = "sn-SnSysLogDao")
	ISnSysLogDao snSysLogDao;

	@Override
	public void deleteById(Long id)
	{
		SnSysLog log = new SnSysLog();
		log.setId(id);
		snSysLogDao.delete(log);
	}

	@Override
	public List<SnSysLog> selectByPage(int index, int size)
	{
		return snSysLogDao.queryByPage(index, size);
	}
}
