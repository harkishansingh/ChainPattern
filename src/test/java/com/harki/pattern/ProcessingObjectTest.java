package com.harki.pattern;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.harki.pattern.service.HeaderTextProcessing;
import com.harki.pattern.service.ProcessingObject;
import com.harki.pattern.service.ProcessingObjectUsingJava8;
import com.harki.pattern.service.SpellCheckerProcessing;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class ProcessingObjectTest {
	@Autowired
	private ProcessingObjectUsingJava8 processinObject;

	@Test
	public void testProcessingObject() {
		ProcessingObject<String> p1 = new HeaderTextProcessing();
		ProcessingObject<String> p2 = new SpellCheckerProcessing();
		p1.setSuccessor(p2);

		String result = p1.handle("Aren't labdas really sexy??");
		Assert.assertEquals(result, "From Harki: Aren't lambdas really sexy??");
	}

	@Test
	public void testProcessingObjectUsingJava8() {
		String result = processinObject.pipeline.apply("Aren't labdas really sexy??");
		Assert.assertEquals(result, "From Harki: Aren't lambdas really sexy??");
	}
}
