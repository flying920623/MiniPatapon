package game.minipatapon.automachine;

public class SwitchArg<T> {
	private T arg;
	public SwitchArg(T _arg){
		arg = _arg;
		
	}
	
   public T GetArg(){
	   return arg;
   }
}
