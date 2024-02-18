public class WoodBlockFactory implements Factory{
	
  	// resourceBin is able to refer to a resource, but doesn't refer to anything yet.
  	// The "weight" of this bin refers to how much of a resource we're storing. 
	private Resource resourceBin;

    public WoodBlockFactory(){
      
      	// Initially, the weight is 0, meaning we don't have any of the resource in stock.
    	resourceBin = new Resource(0, ResourceType.WOOD);
    }
  

	public void takeResource(Object object) {

      // Check if object is null, throw an exception
       if(object == null){
          throw new IllegalArgumentException("Object is null.");
       }      
      
      // Check if object is not a resource, throw an exception
      // null will never be a Resource
       if((object instanceof Resource) == false){
       	 throw new IllegalArgumentException("Not a resource.");
       }
      
        Resource givenResource = (Resource) object;
      

      	        if(givenResource.getType() != ResourceType.WOOD){
          throw new IllegalArgumentException("Resource must be wood.");
        }
      
      
      	// Add the weight of the given resource to our bin.
        resourceBin.addSubWeight(givenResource.getWeight());
    }
      	// Must return a block, or fail, (or return null)
  		//     v
        public Block produceBlock(){
          if (resourceBin.getWeight() < Constant.WEIGHT_WOODBLOCK){
          	throw new IllegalStateException("Not enough wood to make a block.");
          }
          resourceBin.addSubWeight(-Constant.WEIGHT_WOODBLOCK);
          return new WoodBlock();
          
        }
        
    	public void displayInventory(){
        	System.out.println("Woodblock Factory Inventory:" + resourceBin.getWeight());  
        
        }
  
}