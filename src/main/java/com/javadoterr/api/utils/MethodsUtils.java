package com.javadoterr.api.utils;

import org.springframework.data.domain.Page;
import org.springframework.ui.Model;

public class MethodsUtils {

	public static void pageModel(Model model, Page<?> pages) {

		int current = pages.getNumber() + 1;
		int begin = Math.max(1, current - 3);
		int end = Math.min(begin + 3, pages.getTotalPages());

		model.addAttribute("end", end);
		model.addAttribute("begin", begin);
		model.addAttribute("current", current);
		model.addAttribute("totalPages", pages.getTotalPages());
		model.addAttribute("totalElements", pages.getTotalElements());
		model.addAttribute("size", pages.getSize());

	}

	public static String convertString(String text) {
		String formattedText = "";
		for (Character character : text.toCharArray()) {

			if (Character.isUpperCase(character)) {
				formattedText = formattedText + " " + character;
			} else {
				formattedText = formattedText + character;
			}
			formattedText = formattedText.substring(0, 1).toUpperCase()
					+ formattedText.substring(1, formattedText.length());
		}

		return formattedText.trim();

	}

}
