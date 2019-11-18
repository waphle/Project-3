import java.util.HashMap; 
import java.util.Vector;

public class SearchResult {
      
   // Attributes
   HashMap<String, Integer> stateCountMap = new HashMap<String, Integer>();
   Vector<String> stateCodes = new Vector<String>();
   Vector<Integer> matchCounts = new Vector<Integer>();
   
   // Constructors
   public SearchResult() {
      stateCodes.clear();
      matchCounts.clear();
      stateCountMap.clear();
      for (int i = 0; i < Constants.STATE_NAME_CODES.length; i++) {
         stateCodes.add(Constants.STATE_NAME_CODES[i]);
         matchCounts.add(0);
         stateCountMap.put(Constants.STATE_NAME_CODES[i], 0);
      }
   }
   
   // Methods
   public void set(HashMap<String, Integer> resultMap) {
      stateCountMap = (HashMap<String, Integer>)resultMap.clone();
      matchCounts.clear();
      for (int i = 0; i < stateCodes.size(); i++) {
         matchCounts.add(resultMap.get(stateCodes.get(i)));
      } 
   }
   
   // Getters and setters
   public HashMap<String, Integer> getStateCountMap() { return this.stateCountMap; }
   public Vector<String> getStateCodes() { return this.stateCodes; }
   public Vector<Integer> getMatchCounts() { return this.matchCounts; }
   public void setStateCountMap(HashMap<String, Integer> stateCountMap) { this.stateCountMap = stateCountMap; }
   public void setStateCodes(Vector<String> stateCodes) { this.stateCodes = stateCodes; }   
   public void setMatchCounts(Vector<Integer> matchCounts) { this.matchCounts = matchCounts; }   
}