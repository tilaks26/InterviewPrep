import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom 
{
	
	public static class Interval
	{
		int start;
		int end;
		
		public Interval(int start, int end)
		{
			this.start = start;
			this.end = end;
		}
	}
	
	public static boolean canAttendAllMeetings(Interval[] intervals)
	{
		Arrays.sort(intervals, new Comparator<Interval>()
		{
				public int compare(Interval a, Interval b)
				{
					return a.start-b.start;
				}
		});
		
		for (int i = 0; i < intervals.length; i++)
		{
			if (intervals[i].end < intervals[i+1].start)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static int minimumRoomsRequired(Interval[] intervals)
	{
		if (intervals == null || intervals.length == 0)
		{
			return 0;
		}
		
		Arrays.sort(intervals, new Comparator<Interval>() 
		{
			public int compare(Interval a, Interval b)
			{
				return a.start-b.start;
			}
		});
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		int count = 1;
		queue.offer(intervals[0].end);
		
		for (int i = 1; i < intervals.length; i++)
		{
			if (intervals[i].start < queue.peek())
			{
				count++;
			}
			else
			{
				queue.poll();
			}
			
			queue.offer(intervals[i].end);
		}
		
		return count;
	}
	
}