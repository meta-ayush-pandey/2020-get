package que2;

/**
 * 
 * @author Ayush
 * class implementing the functions of queue using array
 *
 */
public class Queue implements QueueInterface{
	int rear, front;
	int capacity;
	int queue[];

	/** 
	 * constructor to initialise queue capacity front and rear 
	 */
	Queue(){}

	Queue(int capacity)
	{
		this.rear = -1;
		this.front = -1;
		this.capacity = capacity;
		this.queue = new int[this.capacity];
	}

	@Override
	public int size()
	{
		return ((this.capacity - this.front + this.rear + 1) % (this.capacity));
	}

	@Override
	public boolean isFull()
	{
		return ((this.rear + 1) % this.capacity == this.front);
	}

	@Override
	public boolean isEmpty()
	{
		return (this.front == -1);
	}

	@Override
	public void add(int value)
	{
		if (isFull())
		{
			System.out.println("Overflow");
		} else
		{
			this.rear = (this.rear + 1) % this.capacity;
			this.queue[this.rear] = value;
			if (this.front == -1)
			{
				this.front = this.rear;
			}
		}
	}

	@Override
	public void delete()
	{
		if (isEmpty()) 
		{
			System.out.println("Queue is empty");
		} else 
		{
			if (this.front == this.rear) 
			{
				this.front = this.rear = -1;
			} else 
			{
				this.front = (this.front + 1) % this.capacity;
			}
		}
	}

	@Override
	public void show() 
	{
		int temporary1 = this.front;
		int i = 0, size;
		if (isEmpty()) 
		{
			System.out.println("Queue is empty");
		} else 
		{
			if (size() == 0)
			{
				size = 4;
			} else
			{
				size = size();
			}
			while (i < size)
			{
				System.out.println(this.queue[temporary1]);
				temporary1 = (temporary1 + 1) % this.capacity;
				i++;
			}
		}
	}
}
