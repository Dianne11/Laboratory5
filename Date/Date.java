public class Date {
    private int year;
    private int month;
    private int day;

    //Implement a default blank constructor which will set the date to 1/1/1000
    //mm/dd/yy

    public Date() {
        this.year = 1000;
	    this.month = 1;
        this.day = 1;
    }

    public Date(int a, int b, int c) {
        this.year = a;
	    this.month = b;
	    this.day = c;
    }

    public String toString(){//overriding the toString() method
        String formattedDate = String.format("%d/%02d/%02d", year, month, day);
        return formattedDate;  
    }  
    
    

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        checkYear(year);
	   this.year = year;
    }

    public int getMonth() {
	   return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
	this.day = day;
    }
    
    public void checkYear(int year) {
    if(year < 1000 || year > 9999) {
    throw new IllegalArgumentException("Invalid year!");
    }
    this.year = year;
    }

    public void checkMonth(int month) {
    if(month < 1 || month > 12) {
    throw new IllegalArgumentException("Invalid month!");
    }
    this.month = month;
    }

    public void checkDay(int day, int month) {
    if(day < 1 || day > 31) {
            throw new IllegalArgumentException("Invalid day!");
    }
        if((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
            throw new IllegalArgumentException("Invalid day!");
        }
        this.day = day;
    }   

    public void checkLeapYear(int year, int day) {
        int leapYear = 0;

        if(year % 100 == 0 && year % 400 == 0) {
            leapYear = 1;
            }
        if(year % 4 == 0 && year % 100 != 0) {
            leapYear = 1;       
        }

        if((leapYear == 1 && day > 29) || (leapYear == 0 && day > 28)) {
            throw new IllegalArgumentException("Invalid day!");
        }
    }

    public void setDate(int year, int month, int day) {
	this.year = year;
	this.month = month;
	this.day = day;
    
    if(month == 2) {
        checkLeapYear(year, day);        
    }
        checkYear(year);
        checkMonth(month);
        checkDay(day, month);
    }
    
}
