import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;

public aspect RuntimeLog {

    long startTime;
    long endTime;

    @Pointcut("execution(* *.sort(..))")
    private void timer(){}

    @Before("timer()")
    public void startTimer(JoinPoint jp){
        startTime = System.nanoTime();
        System.out.println("Running sort in " + jp.getSourceLocation().getFileName()
                + " with array size " + ((Integer[])jp.getArgs()[0]).length);
    }

    @After("timer()")
    public void stopTimer(JoinPoint jp){
        endTime = System.nanoTime();
        System.out.println("Function sort in " + jp.getSourceLocation().getFileName()
                + " took " + ((endTime - startTime) / 1000000) + " ms");
    }

}

