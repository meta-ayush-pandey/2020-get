import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class Main {

	public static void main(String[] args) {
		int noOfProcess;
		
		
		Scanner sc =new Scanner(System.in);
		System.out.println("enter no of processes");
		noOfProcess=sc.nextInt();
		System.out.println("enter arrival time and brust time of processes");
		int time[][]= new int[noOfProcess][2];
		for(int i=0;i<noOfProcess;i++)
		{
			for(int j=0;j<2;j++)
			{	
				time[i][j]=sc.nextInt();
			
			}
		}
		JobScheduler processes = new JobScheduler(time);
		int completionTime[]=processes.completionTime();
		int turnAroundTime[]=processes.turnAroundTime();
		int waitingTime[]=processes.waitingTime();
		double averageWaitingTime=processes.averageWaitingTime();
		int maxWaitingTime=processes.maxWaitingTime();
		
		System.out.println("pid\tcompletion time  turnaroundtime   waiting time");
		for(int i=0;i<noOfProcess;i++)
		{
			System.out.println(i+1+"\t\t"+completionTime[i]+"\t\t"+turnAroundTime[i]+"\t\t"+waitingTime[i]);
			
		}
		System.out.println("the average waiting time is"+averageWaitingTime);
		System.out.println("the max waiting time is"+maxWaitingTime);

	}

}
