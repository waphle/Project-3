import java.util.HashMap; 
import java.util.Vector;

public class SearchEngine {

   // Attributs
   ADRepos adDatabase = new ADRepos();
   
   // Constructors
   public SearchEngine(ADRepos database) {
      this.adDatabase = database;
   }
   
   // Methods
   public boolean find(String key, SearchResult result) {
      if (key.isEmpty()) {
         return true;
      }
      
      int keyLength = key.length();
      byte[] keyBytes = key.toLowerCase().trim().getBytes();      
      int numADs = this.adDatabase.getADRepos().size();
      int numStates = result.getStateCodes().size();
      HashMap<String, Integer> matchCountMap = result.getStateCountMap();
      
      // Check result object's sanity
      if (numStates != Constants.NUMBER_OF_STATES) {
          return false;
      }
      
      // Go through the whole ad database
      for (int i = 0; i < numADs; i++) {
         AD ad = this.adDatabase.getADRepos().get(i);
         
         // Skip ad with empty description   
         if (ad.getEmpty()) {
            continue;
         }
         
         // Do linear search for the time being. Will update it with a more
         // efficient search method...
         String state = ad.getStateCode();
         byte[] text = ad.getText();
         int textLength = ad.getText().length;
         
         // Moving along the string of the text bytes...
         boolean foundMatch = false;
         for (int k = 0; k < textLength - keyLength; k++) {
            // to check if the byte patten of the key matches the current substring of the same length in the text string
            boolean matched = true; // Assume a match be found at first
            for (int n = 0; n < keyLength; n++) {
               if (keyBytes[n] != text[n]) {
                  matched = false; // This breaks the asscumpption of the search finding a match
                  break;
               }
            }
            
            // If the current substring doesn't match the key, then move to the next substring by shifting 
            // the search pointer one byte to the right and check the match again in the next iteration...
            if (!matched) {
               continue;
            }
            // If a match has really been found, then quit the current search process
            else {
               foundMatch = true;
               break;
            }
         }
         
         // Update the match map with the current search result, then go to the next ad
         if (foundMatch) {
            int count = matchCountMap.get(state);
            count++;
            matchCountMap.replace(state, count);
         }
      }
      
      // Search is done here, so output the search result
      result.set(matchCountMap);
      return true;
   }
}