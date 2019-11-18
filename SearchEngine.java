public class SearchEngine {
   // Attributs
   ADRepos adDatabase = new ADRepos();
   
   // Constructors
   public SearchEngine(ADRepos database) {
      this.adDatabase = database;
   }
   
   // Methods
   public void find(String key, SearchResult result) {
   }
}