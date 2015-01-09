package org.stackbox.darkportal.mechanism.dto;

//获取认证状态返回结果DTO
public class ProductDateDTO {

	private Integer status_code;
	private Integer userId;
	private String start_date;
	private String end_date;
	
	public ProductDateDTO() {
		super();
	}
	
	public ProductDateDTO(Integer status_code, Integer userId,
			String start_date, String end_date) {
		super();
		this.status_code = status_code;
		this.userId = userId;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	public Integer getStatus_code() {
		return status_code;
	}
	public void setStatus_code(Integer status_code) {
		this.status_code = status_code;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	@Override
	public String toString() {
		return "ProductDateDTO [status_code=" + status_code + ", userId="
				+ userId + ", start_date=" + start_date + ", end_date="
				+ end_date + "]";
	}
	
	
}
