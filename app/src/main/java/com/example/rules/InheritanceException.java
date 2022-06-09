package com.example.rules;

import android.os.Build;

import androidx.annotation.RequiresApi;

public class InheritanceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InheritanceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequiresApi(api = Build.VERSION_CODES.N)
	public InheritanceException(String message, Throwable cause, boolean enableSuppression,
								boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InheritanceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InheritanceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public InheritanceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
}
