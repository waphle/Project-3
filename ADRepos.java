import java.util.Scanner;
import java.util.*;

public class ADRepos {
   // Atrributes
   ArrayList<AD> adRops = new ArrayList<AD>();
   
   // Constructors
   public ADRepos() {};
   
   // Getters and setters
   public ArrayList<AD> getADRepos() { return adRops; }
   
   // Methods
   public boolean loadADs(String fileName) throws Exception {
   
      if (fileName.isEmpty()) {
         System.out.println("Input file name is empty.");
         return false;
      }
      
      java.io.File file = new java.io.File(fileName);
      Scanner fileInput = new Scanner(file, "UTF-8");

      // Load all ads from the data file into the database
      int count = 0;
      while (fileInput.hasNext()) {
         String line = fileInput.nextLine();
         
         // Drop the first line that is the header line of the csv file
         if (count == 0) {
            count++;
            continue;
         }
         
         AD ad = new AD();
            
         // Read each of a piece of ad and put its fields into an AD object
         // Get id
         int startPos = 0;
         int delimPos = line.indexOf(Constants.AD_FIELD_DELIMITER, startPos);
         int id = Integer.parseInt(line.substring(0, delimPos));
         ad.setID(id);
         startPos = delimPos + 1;
         
         // Get state code
         delimPos = line.indexOf(Constants.AD_FIELD_DELIMITER, startPos);
         String stateCode = line.substring(startPos, delimPos);
         ad.setStateCode(stateCode);
         startPos = delimPos + 1;
         
         // Get text   
         delimPos = line.lastIndexOf("\""); // Get the position of the last '"' character in the description string
         // The data file was not created perfectly sanitarily: some description text may not always end with '"' char.
         // In these defect cases, we need to handle the end position alternatively
         if (delimPos == startPos) 
         {
            delimPos = line.length();
         } 
         String sText = line.substring(startPos, delimPos); // Note the last '"' char is exclusive
         if (sText.charAt(0) == '\"')
            sText = sText.substring(1); // Remove the first '"' char in the description string
         byte[] text = sText.getBytes();
         ad.setText(text);
         
         // Get Empty
         ad.setEmpty(sText.isEmpty());
         
         // Save ad into the Ad repository
         adRops.add(ad);
         
         count++;
      }
      
      return true; // Loading file is successful
   }
}