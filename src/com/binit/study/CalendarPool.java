package com.binit.study;

import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.TimeZone;
import java.util.WeakHashMap;

 
/**

* This class caches Calendar instances using weak references so that Calendar instances based on the same millisecond

* value can be shared in order to greatly reduce memory consumption (each Calendar instance uses almost 500 bytes). For

* safe sharing the Calendar instances are immutable and an exception will be thrown if an attempt to mutate them is

* made. The returned instances must be cloned and any state mutation must be done on the cloned object. When the

* Calendar instances are no longer referenced by any client code they will be removed from the pool by the garbage

* collector, so no size limiting or cleanup code is required.

*/

public class CalendarPool {

 

       private static CalendarPool singleton = new CalendarPool();

 

       private Map<Long, WeakReference<Calendar>> pool = new WeakHashMap<Long, WeakReference<Calendar>>();

 

       private CalendarPool() {

       }

 

       public static CalendarPool singleton() {

              return singleton;

       }

 

       /**

       * Return an immutable Calendar using the passed in milliseconds, if possible sharing Calendar instances in a pool.

       * Attempting to mutate the returned Calendar in any way will result in an exception being thrown.

       *

        * @param milliseconds

       * @return

       */

       public synchronized Calendar getCalendarFromLong(Long milliseconds) {

              Calendar result = null;

              WeakReference<Calendar> reference = pool.get(milliseconds);

              if (reference != null) {

                     result = reference.get();

              }

              // Note that the GC may have kicked in clearing the weak reference so result may be null even if we found

              // reference

              if (result == null) {

                     result = new ImmutableCalendar(milliseconds);

                     reference = new WeakReference<Calendar>(result);

                     pool.put(milliseconds, reference);

              }

              return result;

       }

 

       /**

       * Return an immutable Calendar using the passed in Date, if possible sharing Calendar instances in a pool.

       * Attempting to mutate the returned Calendar in any way will result in an exception being thrown.

       *

        * @param date

       * @return

       */

       public Calendar getCalendarFromDate(Date date) {

              return getCalendarFromLong(date.getTime());

       }

 

       /**

       * All mutable methods except clear and setTimeInMillis are overridden to throw and exception. The clear method is

       * final and so can't do anything about that one. The setTimeInMillis is overridden to do nothing in this class so

       * immutability is maintained.

       */

       @SuppressWarnings("serial")

       private static class ImmutableCalendar extends GregorianCalendar {

 

              /**

              * Will be null initially so that when GregorianCalendar constructor calls setTimeInMillis we know to ignore it.

              * Note that the superclass constructor gets called before any field initialization

              */

              private Long milliseconds;

 

              private ImmutableCalendar(Long milliseconds) {

                     // set timezone, locale and other required fields

                     super();

                     // The above call tried to setTimeInMillis to the current time, but we override it below to do nothing

                     // since we want to set a specific milliseconds value

                     super.setTimeInMillis(milliseconds);

                     // We need to hold a hard reference to the Long to prevent the entry in the WeakHashMap being GC'd

                     // and also indicates that this instance is immutable and should throw an exception if a modification

                     // attempt is made.

                     this.milliseconds = milliseconds;

              }

 

              private void throwException() {

                     if (milliseconds != null && milliseconds.longValue() != -1L) {

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

 

 

