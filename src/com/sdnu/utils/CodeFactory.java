package com.sdnu.utils;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CodeFactory {
	private int height = 25;
	private int width = 60;
	private int lineNum = 40;
	private int stringNum = 4;
	private Random random = new Random();
	private String randomString = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	private Font getFont() {
		Font font = new Font("宋体", Font.CENTER_BASELINE, 18);
		return font;
	}

	private Color getColor() {
		Color color = new Color(random.nextInt(255), random.nextInt(255),
				random.nextInt(255));
		return color;
	}

	private void drawLine(Graphics gh) {
		int x = random.nextInt(width);
		int y = random.nextInt(height);
		int x1 = random.nextInt(13);
		int y1 = random.nextInt(15);
		gh.drawLine(x, y, x + x1, y + y1);
	}

	private String drawData(Graphics gh, String data, int num) {
		gh.setFont(getFont());
		gh.setColor(getColor());
		String randData = String.valueOf(randomString.charAt(random
				.nextInt(randomString.length())));
		data = data + randData;
		gh.drawString(randData, num * 13, 10);
		return data;
	}

	public void getRandCode(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession();
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_BGR);
		Graphics gh = image.getGraphics();
		gh.fillRect(0, 0, width, height);
		gh.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 18));
		gh.setColor(new Color(210,210,210));
		for (int i = 0; i < lineNum; i++) {
			drawLine(gh);
		}
		gh.translate(3, 10);
		String data = "";
		for (int i = 0; i < stringNum; i++) {
			data = drawData(gh, data, i);
		}
		session.setAttribute("data", data);
		gh.dispose();
		try {
			ImageIO.write(image, "JPEG", response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
