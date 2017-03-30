package fr.pizzeria.aspect;

import java.sql.Date;
import java.time.LocalDate;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.pizzeria.model.Performance;
import fr.pizzeria.repo.PerformanceRepository;

@Component
@Aspect
public class AspectDaoPerformance {
	@Autowired
	private PerformanceRepository performanceRepository;

	@Around("execution(* fr.pizzeria.dao.PizzaDaoJPA.*(..))")
	private Object onDaoMethodExecution(ProceedingJoinPoint pjp) throws Throwable {
		Date ldtStart = Date.valueOf(LocalDate.now());
		long start = System.currentTimeMillis();
		Object retVal = pjp.proceed();
		long stop = System.currentTimeMillis();
		long duree = stop - start;
		performanceRepository.save(new Performance(pjp.getSignature().toString(), ldtStart, duree));
		return retVal;
	}

}
