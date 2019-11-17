public class AD {
   // Attributes
   private int id;
   private String stateCode;
   private byte[] text;
   private boolean empty;
  
   // Constructors
   public AD(int id, String state, byte[] text, boolean empty) {
      this.id = id;
      this.stateCode = state;
      this.text = text;
      this.empty = empty;
   }
    
   // Getters
   public int getID() { return this.id; }
   public String getStateCode() { return this.stateCode; }
   public byte[] getText() { return this.text; }
   public boolean getEmpty() { return this.empty; }
}