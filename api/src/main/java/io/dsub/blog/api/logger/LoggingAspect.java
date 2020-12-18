package io.dsub.blog.api.logger;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.Duration;
import java.time.Instant;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
    public void restControllersAllMethod(){};

//    @Around("restControllersAllMethod()")
//    public Object executionTimeLogger(ProceedingJoinPoint joinPoint) throws Throwable {
//        long start = System.currentTimeMillis();
//        try {
//            return joinPoint.proceed(joinPoint.getArgs());
//        } finally {
//            long timeTook = System.currentTimeMillis() - start;
//
//            log.debug("Request took {}ms", timeTook);
//
//        }
//    }


    @Around("restControllersAllMethod()")
    public Object executionTimeLogger(ProceedingJoinPoint joinPoint) throws Throwable {

        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        String params = stringifyMap.apply(request.getParameterMap());

        if (!params.isBlank()) {
            params = "[" + params + "]";
        }
        Instant start = Instant.now();
        try {
            return joinPoint.proceed(joinPoint.getArgs());
        } finally {
            Instant finish = Instant.now();
            long executedTime = Duration.between(start, finish).toMillis();

            log.debug("Request: {} {}{} < {} ({}ms)",
                    request.getMethod(),
                    request.getRequestURI(),
                    params,
                    request.getRemoteHost() + ":" + request.getRemotePort(),
                    executedTime);
        }
    }


    private final Function<Map<String, String[]>, String> stringifyMap = map ->
            map.entrySet().stream()
                    .map(entry -> String.format(
                            "%s >> %s", entry.getKey(), String.join(",", entry.getValue())))
                    .collect(Collectors.joining(", "));
}

