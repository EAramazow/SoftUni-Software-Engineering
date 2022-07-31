package bg.softuni.aopdemo.sample2;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Aspect
@Component
@ConditionalOnProperty(
        value = "sample2.enabled",
        havingValue = "true"
)
public class Sample2Aspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(Sample2Aspect.class);

    @Pointcut("execution (* bg.softuni.aopdemo.IncredibleMachine.concat(..))")
    void onConcat() {}

    @Around(value = "onConcat() && args(a, b)")
    public String onConcat(ProceedingJoinPoint pjp, String a, String b) throws Throwable {
        LOGGER.info("The on concat method was called with args [{}] and [{}].", a, b);

        var modifiedA = "(" + a + ")";
        var modifiedB = "(" + b + ")";

        var result = pjp.proceed(new Object[]{modifiedA, modifiedB});

        var modifiedResult = "[" + result + "]";

        return modifiedResult;
    }
}
