public class StoneBlockFactory implements Factory{
	
  	// resourceBin is able to refer to a resource, but doesn't refer to anything yet.
  	// The "weight" of this bin refers to how much of a resource we're storing. 
	private Resource resourceBin;

    public StoneBlockFactory(){
      
      	// Initially, the weight is 0, meaning we don't have any of the resource in stock.
    	resourceBin = new Resource(0, ResourceType.STONE);
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
      

      	// TODO: Make sure the given resource is of type STONE.
        if(givenResource.getType() != ResourceType.STONE){
          throw new IllegalArgumentException("Resource must be stone.");
        }
      
      
      	// Add the weight of the given resource to our bin.
        resourceBin.addSubWeight(givenResource.getWeight());
    }
      	// Must return a block, or fail, (or return null)
  		//     v
        public Block produceBlock(){

          if (resourceBin.getWeight() < Constant.WEIGHT_STONEBLOCK){
          	throw new IllegalStateException("Not enough stone to make a block.");
          }
          resourceBin.addSubWeight(-Constant.WEIGHT_STONEBLOCK);
          return new StoneBlock();
          
        }
        
    	public void displayInventory(){
        	System.out.println("Stoneblock Factory Inventory:" + resourceBin.getWeight());  
        
        }
  
}