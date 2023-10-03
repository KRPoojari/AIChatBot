package com.rest.responseModel;

public class ResponseEntity {
    private String result;
	private String message;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

	public void setMessage(String message) {
		this.message=message;
		// TODO Auto-generated method stub
		
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
}
