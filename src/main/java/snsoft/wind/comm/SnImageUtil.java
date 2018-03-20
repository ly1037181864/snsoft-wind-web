package snsoft.wind.comm;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * <p>项目标题： TODO</p>
 * <p>项目功能： </p>
 * <p>所属模块： TODO</p>
 * <p>开发平台：Window10</p>
 * <p>开发工具：Eclipse</p>
 * <p>jar包:TODO</p>
 * <p>创建日期：2018年3月19日 上午11:41:25</p>
 * <p>项目作者：刘友</p>
 * <p>类全名：snsoft.wind.comm.SnImageUtil</p>
 * @version 1.0
 */
public class SnImageUtil
{
	// 验证码字符集
	private static final char[] chars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
			'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
			'V', 'W', 'X', 'Y', 'Z' };
	// 字符数量
	private static final int SIZE = 4;
	// 干扰线数量
	private static final int LINES = 5;
	// 宽度
	private static final int WIDTH = 100;
	// 高度
	private static final int HEIGHT = 40;
	// 字体大小
	private static final int[] FONT_SIZE = { 27, 28, 29, 30 };

	/**
	 * 生成随机验证码及图片
	 */
	public static Object[] createImage()
	{
		StringBuffer sb = new StringBuffer();
		// 1.创建空白图片
		BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		// 2.获取图片画笔
		Graphics graphic = image.getGraphics();
		// 3.设置画笔颜色
		graphic.setColor(Color.WHITE);
		// 4.绘制矩形背景
		graphic.fillRect(0, 0, WIDTH, HEIGHT);
		// 5.画随机字符
		Random ran = new Random();
		for (int i = 0; i < SIZE; i++)
		{
			// 取随机字符索引
			int n = ran.nextInt(chars.length);
			// 设置随机颜色
			graphic.setColor(Color.BLACK);
			// 设置字体大小
			graphic.setFont(new Font(null, Font.BOLD + Font.ITALIC, FONT_SIZE[ran.nextInt(4)]));
			// 画字符
			graphic.drawString(chars[n] + "", i * WIDTH / SIZE, 30);
			// 记录字符
			sb.append(chars[n]);
		}
		// 6.画干扰线
		for (int i = 0; i < LINES; i++)
		{
			// 设置随机颜色
			graphic.setColor(getRandomColor());
			// 随机画线
			graphic.drawLine(ran.nextInt(WIDTH), ran.nextInt(HEIGHT), ran.nextInt(WIDTH), ran.nextInt(HEIGHT));
		}
		// 添加噪点
		float yawpRate = 0.05f;// 噪声率
		int area = (int) (yawpRate * WIDTH * HEIGHT);
		for (int i = 0; i < area; i++)
		{
			int x = ran.nextInt(WIDTH);
			int y = ran.nextInt(HEIGHT);
			int rgb = getRandomIntColor();
			image.setRGB(x, y, rgb);
		}
		// 7.返回验证码和图片
		return new Object[] { sb.toString(), image };
	}

	private static int getRandomIntColor()
	{
		int[] rgb = getRandomRgb();
		int color = 0;
		for (int c : rgb)
		{
			color = color << 8;
			color = color | c;
		}
		return color;
	}

	private static int[] getRandomRgb()
	{
		Random ran = new Random();
		int[] rgb = new int[3];
		for (int i = 0; i < 3; i++)
		{
			rgb[i] = ran.nextInt(255);
		}
		return rgb;
	}

	/**
	 * 随机取色
	 */
	public static Color getRandomColor()
	{
		Random ran = new Random();
		Color color = new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(256));
		return color;
	}

	public static void main(String[] args) throws IOException
	{
		Object[] objs = createImage();
		BufferedImage image = (BufferedImage) objs[1];
		// /home/soft01/1.png
		OutputStream os = new FileOutputStream("f:/1.png");
		ImageIO.write(image, "png", os);
		os.close();
	}
}
