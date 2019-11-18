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
      int numStates = result.getsStateCodes().size();
      Vector<Integer> matchCounts = result.getMatchCounts();
      
      // Check result object's sanity
      if (numStates != Constants.NUMBER_OF_STATES ||
          numStates != matchCounts.size()) {
          return false;
      }
      
      for (int i = 0; i < numStates; i++) {
         String state = result.getsStateCodes().get(i);
         for (int j = 0; j < numADs; j++) {
            AD ad = this.adDatabase.getADRepos().get(j);
            
            if (ad.getEmpty()) {
               continue;
            }
            
            // Do linear search for the time being. Will update it with a more
            // efficient search method...
            byte[] text = ad.getText();
            int textLength = ad.getText().length;
            boolean foundMatch = true;
            for (int k = 0; k < textLength - keyLength; k++) {
               // Check if the keyBytes match the current substring of bytes in the text
               for (int n = 0; n < keyLength; n++) {
                  if (keyBytes[n] != text[n]) {
                     foundMatch = false;
                     break;
                  }
               }
               
               if (!foundMatch) {
                  continue;
               }
               else {
                  break;
               }
            }
            
            if (foundMatch) {
               int count = matchCounts.get(i);
               count++;
               matchCounts.set(i, count);
            }
         }
      }
      
      // Output search result
      result.setMatchCounts(matchCounts);
      return true;
   }
}