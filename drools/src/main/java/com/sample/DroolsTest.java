package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This class is to demonstrate the launching of rules based on some input and interfacing with agents.
 * 
 * @author Massoud Maher
 * @version 0.1
 */
public class DroolsTest {
	

    public static final void main(String[] args) {

    	try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");

            // Read in input list and check for relevance
        	GeneListInputAgent test_input = new GeneListInputAgent("epidermal_test.txt");
        	kSession.insert(test_input);
        	
            kSession.fireAllRules();
        } 
        catch (Throwable t) {
            t.printStackTrace();
        }
        
        GeneListInputAgent input = new GeneListInputAgent("gene_list.txt");
        System.out.print(input.getArray().toString());
    }
   
    /*
    public static class Message {

        public static final int HELLO = 0;
        public static final int GOODBYE = 1;

        private String message;

        private int status;

        public String getMessage() {
            return this.message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatus() {
            return this.status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

    }
    */

}
