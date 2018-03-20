package snsoft.wind.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import snsoft.wind.comm.SnImageUtil;

/**
 * <p>
 * 验证码服务
 * </p>
 *
 * @author hubin
 * @Date 2016-01-06
 */
@Controller
@RequestMapping("/captcha")
public class SnCaptchaController extends SnBaseController
{
	/**
	 * 生成图片
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping("/image")
	public void image() throws IOException
	{
		// 生成验证码图片
		Object[] objs = SnImageUtil.createImage();
		// 将验证码存入session
		HttpSession session = request.getSession();
		session.setAttribute("imgcode", objs[0]);
		// 将图片输出给浏览器
		response.setContentType("image/png");
		// 通过response获取的流，是输出给浏览器的。
		OutputStream os = response.getOutputStream();
		ImageIO.write((BufferedImage) objs[1], "png", os);
		os.close();
	}
}
