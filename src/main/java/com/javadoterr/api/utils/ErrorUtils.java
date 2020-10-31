package com.javadoterr.api.utils;

import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class ErrorUtils {

	public static String customErrors(List<ObjectError> errors) {
		JSONObject jsonObject = new JSONObject();
		try {
			String errorMessage = "";
			jsonObject.put("status", "failure");
			jsonObject.put("title", "Field Errors");
			for (ObjectError objectError : errors) {
				if (objectError instanceof FieldError) {
					FieldError fieldError = (FieldError) objectError;
					errorMessage += "<b>" +MethodsUtils.convertString(fieldError.getField()) + " : </b>" + fieldError.getDefaultMessage() + "</b>";
				}

			}
			jsonObject.put("message", errorMessage);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		return jsonObject.toString();
	}

}
