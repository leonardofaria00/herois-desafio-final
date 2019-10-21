package com.stefanini.desafio.api;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

public class BaseAPI {
	@Context
	protected HttpServletRequest request;

	public HttpServletRequest getHttpRequest() {
		return request;
	}
}
