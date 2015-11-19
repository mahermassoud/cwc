package com.sample;

import java.util.Collection;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.Agenda;
import org.kie.api.runtime.rule.AgendaGroup;
import org.kie.api.runtime.rule.FactHandle;

/**
 * This class is to demonstrate the launching of rules based on some input and interfacing with agents.
 * 
 * @author Massoud Maher
 * @version 0.1
 */
public class DroolsTest implements Common {
	
    public static final void main(String[] args) {
    	
    	try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");
        	Agenda agenda = kSession.getAgenda();

            // Read in input list and check for relevance -- store input files into drools/target/com/sample
        	GeneListInputAgent epidermal_input = new GeneListInputAgent("epidermal_test.txt");
        	GeneListInputAgent myocyte_input = new GeneListInputAgent("myocyte_enhancer_2c_test.txt");
        	GeneListInputAgent calmodulin_input = new GeneListInputAgent("calmodulin_1_test.txt");
        	
        	// Focus agenda on collecting gene groups
        	AgendaGroup geneCollectionAgenda = agenda.getAgendaGroup("Gene collection");
        	geneCollectionAgenda.setFocus();

        	// Alternate firing and adding to simulate conversation
        	kSession.insert(epidermal_input);
        	System.out.println("___________________________Firing rules with epidermal___________________________");
            kSession.fireAllRules();
            
            printAllFacts(kSession);

        	kSession.insert(myocyte_input);
        	System.out.println("************************************************************************************************************************************");
        	System.out.println("___________________________Firing rules with epidermal and myocyte___________________________");

        	geneCollectionAgenda.setFocus();
            kSession.fireAllRules();
            kSession.fireAllRules();
        	geneCollectionAgenda.setFocus();

        	kSession.insert(calmodulin_input);
        	System.out.println("************************************************************************************************************************************");
        	System.out.println("___________________________Firing rules with epidermal and myocyte and calmodulin___________________________");
            kSession.fireAllRules();
            
            // Now that all input is added, focus agenda on finding relevant pathways
        	System.out.println("___________________________Firing rules pathway discovery focus________________________________________");
        	AgendaGroup pathwayDiscoveryAgenda = agenda.getAgendaGroup("Pathway discovery");
        	pathwayDiscoveryAgenda.setFocus();

            kSession.fireAllRules();
            printAllFacts(kSession);
            
        	System.out.println("___________________________Testing logical retraction, epidermal and angiotensin should be gone___________________________");
        	FactHandle epidermalFactHandle = kSession.getFactHandle(epidermal_input);
        	kSession.delete(epidermalFactHandle);
        	pathwayDiscoveryAgenda.setFocus();
            kSession.fireAllRules();
        	
            kSession.fireAllRules();
            printAllFacts(kSession);
            
        } 
        catch (Throwable t) {
            t.printStackTrace();
        }
        
    }
    
    /**
     * Helper method to print all facts/objects in KieSession
     * 
     * @param KieSession session whose objects are being printed
     */
    private static void printAllFacts(KieSession session) {
    	Collection<? extends Object> facts = session.getObjects();
    
    	System.out.println("___________Facts in session:___________");
    	for(Object fact: facts) {
    		System.out.println(fact.toString());
    	}
    	System.out.println("___________End facts___________");
    }
   
}







