/*
 * Copyright 2009 the original author or authors.
 * Copyright 2009 SorcerSoft.org.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sorcer.test.eval;

import java.rmi.RemoteException;

import sorcer.core.context.ServiceContext;
import sorcer.service.Context;
import sorcer.service.ContextException;
import sorcer.service.EvaluationException;
import sorcer.vfe.Var;

public class Response {

	public double R2;
	private Double dv = 6.0;
	public String name = "Mike";
	private Context context;
	
	{
		context = new ServiceContext();
		try {
			context.putValue("person/first/name", "Mike");
			context.putValue("person/last/name", "Sobolewski");
		} catch (ContextException e) {
			e.printStackTrace();
		}
	}
	
	/** This method demonstrates the use of the MethodEvaluator class with a
	 * signature of two double types
	 * @param x1
	 * @param x2
	 * @return double
	 */
	public double calculate(double x1, double x2) {
		R2 = -5*x1 -5*x2;
		return R2;
	}

	/** This method demonstrates the use of the MethodEvaluator class with 
	 * no forma parameters
	 * @return double
	 */
	public double calculate() {
		double x1 = 1.0, x2 = 1.0;
		R2 = -5*x1 -5*x2;
		return R2;
	}
	
	/** This method demonstrates the use of the MethodEvaluator class using the 
	 * default signature 
	 * @param x1
	 * @param x2
	 * @return double
	 */
	public double calculateVars(Var x1, Var x2) {
		try {
			R2 = -5*(Double)x1.getValue() -5*(Double)x2.getValue();
		} catch (EvaluationException e) {
			e.printStackTrace();
		}
		return R2;
	}
	
	public double getR2() {
		return R2;
	}
	public void setDv(Double dv) {
		 this.dv= dv;
	}
	public Double getDv() {
		 return this.dv;
	}
}
