
package com.collegemangement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TeacherIdNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleTeacherException(TeacherIdNotFoundException tx, WebRequest request) {
        ErrorMessage er = new ErrorMessage(HttpStatus.NOT_FOUND, tx.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }

    @ExceptionHandler(BatchNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleBatchesException(BatchNotFoundException ex, WebRequest request) {
        ErrorMessage er = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }

    @ExceptionHandler(CoursesNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleCoursesException(CoursesNotFoundException ex, WebRequest request) {
        ErrorMessage er = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }

    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleDepartmentException(DepartmentNotFoundException ex, WebRequest request) {
        ErrorMessage er = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleStudentException(StudentNotFoundException ex, WebRequest request) {
        ErrorMessage er = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleGlobalException(Exception ex, WebRequest request) {
        ErrorMessage er = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(er);
    }
}
