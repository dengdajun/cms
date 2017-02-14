package com.davinci.core.exception;

/**
 * Created by YoungMan on 2017/2/14.
 */
public class RedirectnException extends Throwable{
	private static final long serialVersionUID = -31682103271271470L;


	public RedirectnException() {
        super();
    }

    public RedirectnException(String message) {
        super(message);
    }


    public RedirectnException(String message, Throwable cause) {
        super(message, cause);
    }


    public RedirectnException(Throwable cause) {
        super(cause);
    }


    protected RedirectnException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
