package com.chenx.handler;

import com.chenx.common.bean.Result;
import com.chenx.common.commonConst.ResultCode;
import com.chenx.common.exception.*;
import org.apache.log4j.Logger;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.xml.ws.http.HTTPException;
import java.util.logging.LogManager;

/*  捕捉全部的异常 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger = Logger.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(BindException.class)
    public Result bindException(BindException e) {
        logger.error(e.getClass());
        Result result = new Result();
        result.setResultCode(ResultCode.PARAM_IS_BLANK);
        result.setMessage(e.getMessage());
        return result;

    }

    @ExceptionHandler({NoHandlerFoundException.class})
    public Result httpException(HTTPException e) {
        logger.error(e.getMessage());
        Result result = new Result();
        result.setResultCode(ResultCode.SUCCESS);
        result.setMessage(e.getMessage());
        return result;

    }

    @ExceptionHandler(ParamException.class)
    public Result paramException(ParamException e) {
        logger.error(e.getMessage());
        Result result = new Result();
        result.setResultCode(e.getCode());
        return result;
    }

    @ExceptionHandler(UserException.class)
    public Result UserException(UserException e) {
        logger.error(e.getMessage());
        Result result = new Result();
        result.setResultCode(e.getCode());
        return result;
    }

    @ExceptionHandler(DataException.class)
    public Result DataException(DataException e) {
        Result result = new Result();
        result.setResultCode(e.getCode());
        return result;
    }

    @ExceptionHandler(SystemException.class)
    public Result SystemException(SystemException e) {
        Result result = new Result();
        result.setResultCode(e.getCode());
        return result;
    }

    @ExceptionHandler(AuthorityException.class)
    public Result AuthorityException(AuthorityException e) {
        Result result = new Result();
        result.setResultCode(e.getCode());
        return result;
    }
}
