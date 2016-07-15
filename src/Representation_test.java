import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;


public class Representation_test {
	int rprsntn[];
	int n; //number of collection points
	int k; //number of vehicles
	double adj_mat[][];
	public Representation_test(int k,int n){
		rprsntn=new int [n*k];
		adj_mat= new double[n+1][n+1];
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
		constraint_check();
		//if(adjust!=0){
			
		//}
		
		for(int i=0;i<n*k;i++){
			System.out.print(i+1);
		}
		System.out.println();
		for(int i=0;i<n*k;i++){
			System.out.print(rprsntn[i]);
		}
		
	}
	public void input(){
		Scanner scn = null;
		try {
			scn = new Scanner(new BufferedReader(new FileReader("E:/New folder/PSO_test/src/test_input.txt")));
			 for(int i = 0; i < k+1; i++){
				
			     for(int j = 0; j < k+1; j++){
			         adj_mat[i][j] = scn.nextFloat(); 
			        // System.out.print(adj_mat[i][j]);
			       //System.out.print(" ");
			     }
			     
			   // System.out.println();
			  
			     }
				
		
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		 
	}
	public void fitness_asses(){
		double best=999999;
		double cost=0;int cust=0,veh=0;
		int start=0;
			for(int j=1;j<=n*k;j++){
				if(rprsntn[j-1]==1)
				{
					cust=j-((j-1)/n)*n;
					veh=(j-1)/n +1;
					
					System.out.print("cust:"+cust);
					System.out.print(" ");
					System.out.print("veh:"+veh);
				
					System.out.print(" ");
					
					cost+=adj_mat[start][cust-1];
					
					start=cust;
					
				}
			}
			cost+=adj_mat[start][0];
			if(cost<best) best=cost;
			System.out.println(cost);
			//return best/cost as fitness ? 
			//how to determine best_so_far
			//How to ensure the constraints
		
	}
	public void constraint_check()
	{
		int count[]=new int[n];
	    
		for(int i=0;i<k;i++){
			for(int j=0;j<n;j++){
				count[j]+=rprsntn[j+i*n];
			
			}
		}
		for(int j=0;j<n;j++){
			if((count[j])<1){
				if(rprsntn[j]==0) rprsntn[j]=1;
				else rprsntn[j+k]=1;
			}
			else if(count[j]>1){
				if(rprsntn[j]==1) rprsntn[j]=0;
				else rprsntn[j+k]=1;
			}
		}
			
		
	}

}
