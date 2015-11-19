package com.sample;

import java.util.Arrays;
import java.util.List;

public interface Common {
	public static enum GeneGroupType {
		EPIDERMAL, MYOCYTE_ENHANCER, CALMODULIN_1
	}

	public static enum PathwayType {
		ANGIOTENSIN
	}

	// Genes involved in epidermal growth factor receptor
	public static final List<String> GENE_EPIDERMAL_GROWTH_FACTOR_RECEPTOR = 
			Arrays.asList("NM_005228", "NM_201284", "NM_201282", "NM_201283");

	// Genes involved in myocyte enhancer 2c 
	public static final List<String> GENE_MYOCYTE_ENHANCER_2C =
			Arrays.asList("NM_002397", "NM_001193350", "NM_001193347", "NM_001131005", "NM_001193348", "NM_001193349");
	
	// Genes involved in calmodulin 1
	public static final List<String> GENE_CALMODULIN_1 =
			Arrays.asList("NM_006888");
	
	public static final List<List<String>> ALL_GENE_LISTS = 
			Arrays.asList(GENE_EPIDERMAL_GROWTH_FACTOR_RECEPTOR, GENE_MYOCYTE_ENHANCER_2C, GENE_CALMODULIN_1);
}
