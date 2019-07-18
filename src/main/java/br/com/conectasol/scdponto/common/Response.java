package br.com.conectasol.scdponto.common;

public class Response {

	private Long id;
	private String msg;
	private boolean status;
	private String url;

	public Response(Long id) {
		this.id = id;
		this.status = true;
	}

	public Response(String msg) {
		this.msg = msg;
		this.status = false;
	}

	public Response(Long id, String msg, boolean status) {
		super();
		this.msg = msg;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
