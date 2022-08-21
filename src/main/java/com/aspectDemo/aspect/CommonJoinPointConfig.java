package com.aspectDemo.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {

	@Pointcut("execution(* com.aspectDemo.data.*.*(..))")
	public void dataLayerExecution(){}

	@Pointcut("execution(* com.aspectDemo.business.*.*(..))")
	public void businessLayerExecution(){}

	// chain PointCuts with logical expression
	@Pointcut("dataLayerExecution() || businessLayerExecution()")
	public void allLayerExecution(){}

	// every bean that contain the expression 'dao'
	@Pointcut("bean(*dao*)")
	public void beanContainingDao(){}

	@Pointcut("within(com.aspectDemo.data..*)")
	public void dataLayerExecutionWithWithin(){}

	@Pointcut("@annotation(com.aspectDemo.aspect.TrackTime)")
	public void trackTimeAnnotation(){}
}
