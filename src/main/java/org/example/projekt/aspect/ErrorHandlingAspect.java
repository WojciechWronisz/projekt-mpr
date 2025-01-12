package org.example.projekt.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ErrorHandlingAspect {

    @Around("execution(* org.example.projekt.controllers.*.*(..))")
    public Object handleControllerErrors(ProceedingJoinPoint joinPoint) {
        try {
            return joinPoint.proceed();
        } catch (Exception ex) {
            log.error("Błąd w kontrolerze: {}", ex.getMessage(), ex);
            return ResponseEntity
                    .status(500)
                    .body("Wystąpił błąd: " + ex.getMessage());
        } catch (Throwable e) {

        }
        return null;
    }
}
