import java.util.Random;


public class Representation_test {
	int rprsntn[];
	int n; //number of collection points
	int k; //number of vehicles
	public Representation_test(int n,int k){
		rprsntn=new int [n*k];
		this.n=n;
		this.k=k;
	}
	public void init(){
		double random;
		for(int i=0;i<n*k;i++){
			random= Math.random();
			if(random<0.5) rprsntn[i]=0;
			else rprsntn[i]=1;
		}
		for(int i=0;i<n*k;i++){
			System.out.print(i+1);
		}
		System.out.println();
		for(int i=0;i<n*k;i++){
			System.out.print(rprsntn[i]);
		}
		
	}

}
