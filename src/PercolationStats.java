/*
 * Author- Bhuvan mysore
 * date -  6/5/2015
 * Program-Percolation
 */
public class PercolationStats {
	  private int N,T;
      private double x[];
      private double mean,std;
      Percolation p;
	   public PercolationStats(int N, int T)     // perform T independent experiments on an N-by-N grid
	   {
		
		if(N<=0 || T<=0)
		{
		throw new java.lang.IllegalArgumentException();
		}
        this.N=N;
        this.T=T;
        this.x=new double[T];
				 
	   }
	   public double mean()                      // sample mean of percolation threshold
	   {
	
		for(int i=0;i<this.T;i++)
		{
		  Percolation p=new Percolation(this.N);
		  p.percolates();
		  this.x[i]=(double)p.count/(this.N*this.N);
		  
		} 
		 //this.mean=(double)sum1/(this.T-1);
		 
		 this.mean=StdStats.mean(x);
	     return mean;
	   }
	   
	   public double stddev()                    // sample standard deviation of percolation threshold
	   {
		   this.std=StdStats.stddev(this.x);
		   return std;
		   
		   
		   
	   }
	   public double confidenceLo()              // low  endpoint of 95% confidence interval
	   {
		   
		   double x1=(this.mean)-((double)(1.96*this.std)/Math.sqrt(this.T));
		   return x1;
		   
		   
	   }
	   public double confidenceHi()              // high endpoint of 95% confidence interval
	   {
		   double x2=(this.mean)+((double)(1.96*this.std)/Math.sqrt(this.T));
		   return x2;
		   
	   }
	   public static void main(String[] args)  
	   {
		   PercolationStats x1=new PercolationStats(Integer.parseInt((args[1])),Integer.parseInt(args[2]));
           System.out.println("mean = "+x1.mean());		   
           System.out.println("stddev="+x1.stddev());
           System.out.println("95% confidence interval is "+x1.confidenceLo()+","+x1.confidenceHi());
	   }
}
