package com.binit.study;

import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TimeZone;
import java.util.WeakHashMap;


public class CalendarPoolCopy {
	
	private static CalendarPoolCopy INSTANCE = new CalendarPoolCopy();
	
	private Map<Long, WeakReference<Calendar>> pool = new WeakHashMap<Long, WeakReference<Calendar>>();
	
	public static CalendarPoolCopy getInstance(){
		return INSTANCE;
	}
	
	
	public synchronized Calendar getCalendarFromLong(Long milliseconds){
		Calendar result = null;
		WeakReference<Calendar> reference = pool.get(milliseconds);
		if(reference != null){
			result = reference.get();
		}
		if(result == null){
			result = new ImmutableCalendar(milliseconds);

            reference = new WeakReference<Calendar>(result);

            pool.put(milliseconds, reference);
		}
		return result;
	}
	
	  public Calendar getCalendarFromDate(Date date) {

          return getCalendarFromLong(date.getTime());

   }

	private static class ImmutableCalendar extends GregorianCalendar {
		private Long milliseconds;
		
		private ImmutableCalendar(Long milliseconds) {
		super();
		super.setTimeInMillis(milliseconds);
		this.milliseconds = milliseconds;
		}
		
		private void throwException(){
			if (milliseconds != null && milliseconds.longValue() != -1L){
				RuntimeException e = new RuntimeException("Attempt to modify immutable Calendar");

				e.printStackTrace();
				throw e;
			}
		}
		@Override

		public Object clone() {

			ImmutableCalendar other = (ImmutableCalendar) super.clone();

			// clones need to be mutable, so set milliseconds to -1 on the clone to indicate that it is now mutable

			other.milliseconds = -1L;

			return other;

		}
		
		 @Override

         public void setGregorianChange(Date date) {

                throwException();

                super.setGregorianChange(date);

         }



         @Override

         public void add(int field, int amount) {

                throwException();

                super.add(field, amount);

         }



         @Override

         public void roll(int field, boolean up) {

                throwException();

                super.roll(field, up);

         }



         @Override

         public void roll(int field, int amount) {

                throwException();

                super.roll(field, amount);

         }



         @Override

         public void setTimeZone(TimeZone zone) {

                throwException();

                super.setTimeZone(zone);

         }



         @Override

         public void setTimeInMillis(long millis) {

                // When GregorianCalendar superclass calls this method during constructor we want to do nothing

                // as we will be immediately setting a specific millisecond value.

                if (milliseconds == null) {

                      return;

                }

                throwException();

                super.setTimeInMillis(millis);

         }



         @Override

         public void set(int field, int value) {

                throwException();

                super.set(field, value);

         }



         @Override

         public void setLenient(boolean lenient) {

                throwException();

                super.setLenient(lenient);

         }



         @Override

         public void setFirstDayOfWeek(int value) {

                throwException();

                super.setFirstDayOfWeek(value);

         }



         @Override

         public void setMinimalDaysInFirstWeek(int value) {

                throwException();

                super.setMinimalDaysInFirstWeek(value);

         }



         @Override

         public boolean equals(Object obj) {

                // There is a strange concurrency issue in Calendar.equals so implement our own equals

                if (obj != null && obj instanceof Calendar) {

                      Calendar that = (Calendar) obj;

                      return this.getTimeInMillis() == that.getTimeInMillis();

                }

                return super.equals(obj);

         }

		
	}
	
	
}
