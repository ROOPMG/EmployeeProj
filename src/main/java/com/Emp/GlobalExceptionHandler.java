package com.Emp;

import java.time.LocalDateTime;



import javax.servlet.http.HttpServletRequest;

 

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

 

import com.Emp.exception.AdminAlreadyExistException;
import com.Emp.exception.AdminIdNotFoundException;
import com.Emp.exception.EmployeeAlreadyExistsException;
import com.Emp.exception.EmployeeDoesNotExistsException;
import com.Emp.exception.ErrorInformation;
import com.Emp.exception.NoAdminFoundException;

 

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(AdminAlreadyExistException.class)
    public @ResponseBody ErrorInformation AdminAlreadyExistsExceptionInfo(AdminAlreadyExistException e,HttpServletRequest req) {
        ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
        return erinfo;
}

@ExceptionHandler(AdminIdNotFoundException.class)
public @ResponseBody ErrorInformation AdminIdNotFoundException(AdminIdNotFoundException e,HttpServletRequest req) {
    ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
    return erinfo;
}
@ExceptionHandler(EmployeeAlreadyExistsException.class)
public @ResponseBody ErrorInformation EmployeeAlreadyExistsException(EmployeeAlreadyExistsException e,HttpServletRequest req) {
    ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
    return erinfo;

 

}

 

@ExceptionHandler(EmployeeDoesNotExistsException.class)
public @ResponseBody ErrorInformation EmployeeDoesNotExistsException(EmployeeDoesNotExistsException e,HttpServletRequest req) {
    ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
    return erinfo;

 

}

 

@ExceptionHandler(NoAdminFoundException.class)
public @ResponseBody ErrorInformation NoAdminFoundException(NoAdminFoundException e,HttpServletRequest req) {
    ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
    return erinfo;

 

}
@ExceptionHandler(com.Emp.exception.ResourceDBException.class)
public @ResponseBody ErrorInformation ResourceDBException(com.Emp.exception.ResourceDBException e,HttpServletRequest req) {
     ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
     return erinfo;
}

 

 

 

 

 

 

 

}
/*import java.time.LocalDateTime;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.Emp.exception.AdminAlreadyExistException;
import com.Emp.exception.AdminIdNotFoundException;
import com.Emp.exception.EmployeeAlreadyExistsException;
import com.Emp.exception.EmployeeDoesNotExistsException;
import com.Emp.exception.ErrorInformation;
import com.Emp.exception.NoAdminFoundException;
@ControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(AdminAlreadyExistException.class)
 public @ResponseBody ErrorInformation AdminAlreadyExistsExceptionInfo(AdminAlreadyExistException e,HttpServletRequest req) {
 ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
 return erinfo;
}
@ExceptionHandler(AdminIdNotFoundException.class)
public @ResponseBody ErrorInformation AdminIdNotFoundException(AdminIdNotFoundException e,HttpServletRequest req) {
	ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
 return erinfo;
}
@ExceptionHandler(EmployeeAlreadyExistsException.class)
public @ResponseBody ErrorInformation EmployeeAlreadyExistsException(EmployeeAlreadyExistsException e,HttpServletRequest req) {
 ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
return erinfo;
}
@ExceptionHandler(EmployeeDoesNotExistsException.class)
public @ResponseBody ErrorInformation EmployeeDoesNotExistsException(EmployeeDoesNotExistsException e,HttpServletRequest req) {
 ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
return erinfo;
}
@ExceptionHandler(NoAdminFoundException.class)
public @ResponseBody ErrorInformation NoAdminFoundException(NoAdminFoundException e,HttpServletRequest req) {
ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
 return erinfo;
}
@ExceptionHandler(com.Emp.exception.ResourceDBException.class)
public @ResponseBody ErrorInformation ResourceDBException(com.Emp.exception.ResourceDBException e,HttpServletRequest req) {
 ErrorInformation erinfo = new ErrorInformation(LocalDateTime.now(),e.getMessage(),req.getRequestURI());
 return erinfo;
}     



}*/
