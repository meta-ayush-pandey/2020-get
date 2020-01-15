


class JobScheduler
{
	int arrivalTime[];
	int brustTime[];
	int processId[];
	int turnAroundTime[];
	int completionTime[]; 
	int waitingTime[];
	int noOfProcess;
	
	public JobScheduler(int time[][])
	{	
		noOfProcess=time.length;
		
		brustTime=new int[noOfProcess];
		processId=new int[noOfProcess];
		arrivalTime=new int[noOfProcess];
		for(int i=0;i<noOfProcess;i++)
		{	
			
			arrivalTime[i]=time[i][0];
			brustTime[i]=time[i][1];
			processId[i]=i+1;
			
					
		}
		
	}

	int[] completionTime()
	{	
		 completionTime = new int[noOfProcess];
		
		for(int i=0;i<noOfProcess;i++)
		{	int temp;
			for(int j=0;j<2;j++)
			if( arrivalTime[j] > arrivalTime[j+1])
			{
				temp = arrivalTime[j];
				arrivalTime[j]=arrivalTime[j+1] ;
				arrivalTime[j+1]=temp;
				temp = brustTime[j];
				brustTime[j] = brustTime[j+1];
				brustTime[j+1] = temp;
				temp = processId[j];
				processId[j] = processId[j+1];
				processId[j+1] = temp;
			}
		}
			for( int i = 0 ; i < noOfProcess; i++)
			{
				if( i == 0)
				{	
					completionTime[i] = arrivalTime[i] + brustTime[i];
				}
				else
				{
					if( arrivalTime[i] > completionTime[i-1])
					{
						completionTime[i] = arrivalTime[i] + brustTime[i];
					}
					else
						completionTime[i] = completionTime[i-1] + brustTime[i];
				}
		}
		
		return completionTime;
	}
	
	int[] waitingTime()
	{	waitingTime= new int[noOfProcess];
		for(int i=0;i<noOfProcess;i++)
		{
			waitingTime[i]= turnAroundTime[i] -brustTime[i];
		}
		return waitingTime ;
	}
	
	int[] turnAroundTime()
	{	
		turnAroundTime=new int[noOfProcess];
		for(int i=0;i<noOfProcess;i++)
		{
			turnAroundTime[i] = completionTime[i] - arrivalTime[i];
		}
		return turnAroundTime;
		
	}
	
	double averageWaitingTime()
	{
		float totalWaitingTime=0;
		for(int i:waitingTime)
		{
			totalWaitingTime+=i;
		}
		return totalWaitingTime/noOfProcess;
	}
	
	int maxWaitingTime()
	{	int maxWaitingTime=waitingTime[0];
		for(int i:waitingTime)
		{
			if(i>maxWaitingTime)
				maxWaitingTime=i;
		}
		return maxWaitingTime;
	}
	
}
