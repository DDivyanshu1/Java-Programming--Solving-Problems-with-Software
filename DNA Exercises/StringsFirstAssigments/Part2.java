
public class Part2 {
    public String findSimpleGene(String dna, String startCodon, String stopCodon) {
        int startIndex = dna.indexOf(startCodon);
        if(startIndex == -1)return "";
        
        int stopIndex = dna.indexOf(stopCodon, startIndex + 3);
        if(stopIndex == -1) return "";
        
        int strandLength = stopIndex - startIndex;
        String strand = dna.substring(startIndex, stopIndex + 3);
        
        if(strandLength % 3 == 0){
            return strand.equals(strand.toUpperCase()) ? strand : strand.toLowerCase();
        } 
        
        return "";
    }
    
    public void testSimpleGene() {

        // DNA with no ATG
        String dna = "ATTGAAGGGTAGTAACGTAA";
        System.out.println("DNA strand is " + dna);
        String gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is: " + gene);
        
        // DNA with no TAA
        dna = "ATGGACCGGTAGTCACGTAG";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is: " + gene);
        
        // DNA with no ATG or TAA
        dna = "ATCGACCGGTAGTCACGTAC";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is: " + gene);
        
        // DNA with ATG, TAA and the substring between them multiple of 3
        dna = "CGTGAAATGCGTASTGTTAA";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, "ATG", "TAA");
        System.out.println("Gene is: " + gene);
        
        // DNA with ATG, TAA and the substring between them not multiple of 3
        //dna = "CGTGAATGCCGTGASTGTAA";
        dna = "cgtgaatgccgtgastgtaa";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleGene(dna, "atg", "taa");
        System.out.println("Gene is: " + gene);
        
        System.out.println("------------------");
    }
}
